package solver;

import com.microsoft.z3.*;
import com.microsoft.z3.enumerations.Z3_ast_kind;
import com.microsoft.z3.enumerations.Z3_sort_kind;

import java.util.*;

public class SymbolSolver {
    public static int getBitVecIntValue(Context ctx, BitVecExpr targetBitVec, List<Expr> constraints)
        {
            Solver solver = ctx.mkSolver(); // 创建求解器
            // 添加所有约束条件
            for (Expr constraint : constraints) {
                solver.add(constraint);
            }
            // 检查可满足性
            Status status = solver.check();
            if (status == Status.SATISFIABLE) {
                Model model = solver.getModel(); // 获取模型
                // 在模型下评估目标 BitVecExpr
                // 第二个参数 'false' 表示在模型不能完全确定一个具体值时，不要创建新的常量。
                // 对于求解具体值，我们期望它能被完全确定。
                Expr resultExpr = model.eval(targetBitVec, false);
                if (resultExpr instanceof BitVecNum) {
                    BitVecNum bitVecResult = (BitVecNum) resultExpr;
    
                    // 从 BitVecNum 获取 long 值。
                    // BitVecNum.getInt() 也可以，但 getLong() 更通用一些，
                    // 因为 bit-vector 可以表示比Java int更大的数。
                    long longValue = bitVecResult.getLong(); // 或者 bitVecResult.getInt64()
    
                    // 检查该 long 值是否在 Java int 的范围内
                    if (longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) {
                        return -1;
                    }
                    return (int) longValue;
    
                } else {
                    // 如果评估结果不是一个具体的 BitVecNum，说明可能存在问题
                    return -1;
                    
                }
            } else if (status == Status.UNSATISFIABLE) {
                return -1;
            } else { // Status.UNKNOWN
                return -1;
            }
        }

    /**symbolSolver
     * Solves the given constraints and returns results based on the following rules:
     * - If unsatisfiable, return empty list
     * - For symbols with <= 50 values, return format "x = [1,2,3]"
     * - For symbols with > 50 values, return simplified constraints
     *
     * @param ctx The Z3 context
     * @param constraints List of constraints to solve
     * @return List of formatted solutions or simplified constraints
     */

    public static boolean solveConstraintsSingle(Context z3Ctx, List<Expr> constraints) {
        if (constraints.size() == 0)
            return true;
        Solver s = z3Ctx.mkSolver();
        boolean sat = false;
        for (Expr c : constraints) {
            // Log.info("Constraint: " + c);
            s.add(c);
        }

        if (s.check() == com.microsoft.z3.Status.SATISFIABLE) {
            sat = true;
        }
        return sat;
    }

    public static List<String> solve(Context ctx, List<Expr> constraints) {
        List<String> results = new ArrayList<>();
        
        // Create solver and add constraints
        Solver solver = ctx.mkSolver();
        for (Expr constraint : constraints) {
    
                solver.add((BoolExpr) constraint);
            
        }
        
        // Check if satisfiable
        Status status = solver.check();
        if (status != Status.SATISFIABLE) {
            return new ArrayList<>(); // UNSAT, return empty list
        }
        
        // Get the model and all symbols
        Model model = solver.getModel();
        Set<String> symbolNames = new HashSet<>();
        
        for (Expr constraint : constraints) {
            collectSymbols(constraint, symbolNames);
        }
        
        // Process each symbol
        List<String> symbolsWithManyValues = new ArrayList<>();
        Set<String> symbolsWithFewValues = new HashSet<>();
        Goal goal = ctx.mkGoal(true, false, false);
        
        for (String symbolName : symbolNames) {
            // Count constraints involving this symbol
            int constraintCount = 0;
            for (Expr constraint : constraints) {
                Set<String> constraintSymbols = new HashSet<>();
                collectSymbols(constraint, constraintSymbols);
                if (constraintSymbols.contains(symbolName)) {
                    constraintCount++;
                }
            }
            symbolName = symbolName.replace("|", "");
            // If there are few constraints, try to find all values
            if (constraintCount <= 2) {
                List<String> values = findAllValues(ctx, solver, model, symbolName);
                if (values.size() <= 50) {
                    // For symbols with <= 50 values, format as "x = [1,2,3]" or "x = 1" for single value
                    if (values.size() == 1) {
                        results.add(symbolName + " == " + values.get(0).replace("|", ""));
                    } else {
                        results.add(symbolName + " == " + values.toString().replace("|", ""));
                    }
                    symbolsWithFewValues.add(symbolName);
                } else {
                    symbolsWithManyValues.add(symbolName);
                }
            } else {
                symbolsWithManyValues.add(symbolName);
            }
        }
        
        // If there are symbols with many values, output all their constraints
        if (!symbolsWithManyValues.isEmpty()) {
            // Add all constraints to the goal
            for (Expr constraint : constraints) {
                if (constraint instanceof BoolExpr) {
                    // Only add constraints that involve symbols with many values
                    Set<String> constraintSymbols = new HashSet<>();
                    collectSymbols(constraint, constraintSymbols);
                    if (!Collections.disjoint(constraintSymbols, symbolsWithManyValues)) {
                        goal.add((BoolExpr) constraint);
                    }
                }
            }
            
            // Apply tactics to simplify
            Tactic simplify = ctx.mkTactic("simplify");
            Tactic ctxSimplify = ctx.mkTactic("ctx-simplify");
            Tactic ctxSolverSimplify = ctx.mkTactic("ctx-solver-simplify");
            
            Tactic combinedTactic = ctx.then(simplify, ctxSimplify, ctxSolverSimplify);
            ApplyResult simplifiedResult = combinedTactic.apply(goal);
            
            // Get all formulas from the simplified result
            BoolExpr[] formulas = simplifiedResult.getSubgoals()[0].getFormulas();
            
            // Format and output each constraint
            StringBuilder constraintOutput = new StringBuilder();
            // constraintOutput.append("Constraints for ").append(String.join(", ", symbolsWithManyValues)).append(":\n");
            for (int i = 0; i < formulas.length; i++) {
                String formattedConstraint = Z3ExpressionFormatter.formatConstraint(formulas[i]).replace("|", "");
                constraintOutput.append(formattedConstraint);
                // Add comma separator only if not the last element
                if (i < formulas.length - 1) {
                    constraintOutput.append(", ");
                }
            }
            results.add(constraintOutput.toString().trim());
        }
        
        return results;
    }
    
    /**
     * Recursively collects all symbol names from an expression
     */
    private static void collectSymbols(Expr expr, Set<String> symbolNames) {
        if (expr.isConst() && !expr.isNumeral()) {
            String name = expr.toString();
            // Skip constant values like true and false
            if (!name.equals("true") && !name.equals("false")) {
                symbolNames.add(name);
            }
        }
        
        for (Expr child : expr.getArgs()) {
            collectSymbols(child, symbolNames);
        }
    }
    
    /**
     * Finds all possible values for a given symbol
     */
    private static List<String> findAllValues(Context ctx, Solver solver, Model model, String symbolName) {
        List<String> values = new ArrayList<>();
        Expr symbol = null;
        
        // Find the declaration for this symbol
        for (FuncDecl decl : model.getDecls()) {
            if (decl.getName().toString().equals(symbolName)) {
                symbol = ctx.mkConst(decl);
                break;
            }
        }
        
        if (symbol == null) {
            return values;
        }
        
        // Get the current value
        Expr currentValue = model.eval(symbol, true);
        values.add(currentValue.toString());
        
        // Try to find more values by adding exclusion and checking again
        Solver valueEnumSolver = ctx.mkSolver();
        valueEnumSolver.add(solver.getAssertions());
        
        int maxValues = 51; // Stop after finding 51 values (> 50)
        int found = 1;
        
        while (found < maxValues) {
            // Create constraint to exclude already found values
            BoolExpr[] exclusions = new BoolExpr[values.size()];
            for (int i = 0; i < values.size(); i++) {
                // Parse the current value string to create a proper Z3 constant
                Expr parsedValue;
                if (symbol.getSort().getSortKind() == Z3_sort_kind.Z3_BV_SORT) {
                    int bitSize = ((BitVecSort) symbol.getSort()).getSize();
                    try {
                        // Try to parse as a number
                        int val = Integer.parseInt(values.get(i));
                        parsedValue = ctx.mkBV(val, bitSize);
                    } catch (NumberFormatException e) {
                        // If not a simple number, use the string directly
                        parsedValue = ctx.mkBV(values.get(i), bitSize);
                    }
                } else {
                    // Handle other types if needed
                    parsedValue = currentValue;
                }
                exclusions[i] = ctx.mkNot(ctx.mkEq(symbol, parsedValue));
            }
            
            BoolExpr exclusionConstraint = ctx.mkAnd(exclusions);
            valueEnumSolver.push();
            valueEnumSolver.add(exclusionConstraint);
            
            if (valueEnumSolver.check() == Status.SATISFIABLE) {
                Model newModel = valueEnumSolver.getModel();
                Expr newValue = newModel.eval(symbol, true);
                values.add(newValue.toString());
                found++;
                valueEnumSolver.pop();
            } else {
                break; // No more values
            }
        }
        
        return values;
    }
    
    public static void main(String[] args) {
        try (Context ctx = new Context()) {
            System.out.println("Running symbolSolver test cases:");
            
            // Test Case 1: Simple equality a = 5
            {
                System.out.println("\nTest Case 1: Simple equality a = 5");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                Expr five = ctx.mkBV(5, 32);
                constraints.add(ctx.mkEq(a, five));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 2: UNSAT case a = 5 AND a = 6
            {
                System.out.println("\nTest Case 2: UNSAT case a = 5 AND a = 6");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                Expr five = ctx.mkBV(5, 32);
                Expr six = ctx.mkBV(6, 32);
                constraints.add(ctx.mkEq(a, five));
                constraints.add(ctx.mkEq(a, six));
                
                List<String> results = solve(ctx, constraints);
                System.out.println(results.isEmpty() ? "UNSAT (correctly detected)" : "Test failed");
            }
            
            // Test Case 3: Multiple solutions a < 5
            {
                System.out.println("\nTest Case 3: Multiple solutions a < 5");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                Expr five = ctx.mkBV(5, 32);
                constraints.add(ctx.mkBVULT(a, five)); // a < 5 (unsigned)
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 4: Multiple variables with simple constraints
            {
                System.out.println("\nTest Case 4: Multiple variables a = 1, b = 2");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                Expr b = ctx.mkBVConst("b", 32);
                constraints.add(ctx.mkEq(a, ctx.mkBV(1, 32)));
                constraints.add(ctx.mkEq(b, ctx.mkBV(2, 32)));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 5: OR condition a = 1 OR a = 2
            {
                System.out.println("\nTest Case 5: OR condition a = 1 OR a = 2");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                constraints.add(ctx.mkOr(
                    ctx.mkEq(a, ctx.mkBV(1, 32)),
                    ctx.mkEq(a, ctx.mkBV(2, 32))
                ));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 6: Relationship between variables a = b + 1
            {
                System.out.println("\nTest Case 6: Relationship between variables a = b + 1");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                Expr b = ctx.mkBVConst("b", 32);
                constraints.add(ctx.mkEq(a, ctx.mkBVAdd(b, ctx.mkBV(1, 32))));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 7: Large number of solutions a >= 0 AND a <= 100
            {
                System.out.println("\nTest Case 7: Large number of solutions a >= 0 AND a <= 100");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                Expr zero = ctx.mkBV(0, 32);
                Expr hundred = ctx.mkBV(100, 32);
                constraints.add(ctx.mkBVUGE(a, zero)); // a >= 0
                constraints.add(ctx.mkBVULE(a, hundred)); // a <= 100
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 8: Constraints with arithmetic a * 2 = b
            {
                System.out.println("\nTest Case 8: Constraints with arithmetic a * 2 = b");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                Expr b = ctx.mkBVConst("b", 32);
                constraints.add(ctx.mkEq(ctx.mkBVMul(a, ctx.mkBV(2, 32)), b));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 9: Constrained to powers of 2
            {
                System.out.println("\nTest Case 9: Constrained to powers of 2 (a & (a-1) = 0)");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                Expr aMinus1 = ctx.mkBVSub(a, ctx.mkBV(1, 32));
                Expr zero = ctx.mkBV(0, 32);
                // a & (a-1) = 0 means a is a power of 2 or 0
                constraints.add(ctx.mkEq(ctx.mkBVAND(a, aMinus1), zero));
                // a > 0 to exclude 0
                constraints.add(ctx.mkBVUGT(a, zero));
                // a < 256 to limit solutions
                constraints.add(ctx.mkBVULT(a, ctx.mkBV(256, 32)));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 10: Complex constraint a XOR b = c
            {
                System.out.println("\nTest Case 10: Complex constraint a XOR b = c");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 8); // 8-bit
                Expr b = ctx.mkBVConst("b", 8);
                Expr c = ctx.mkBVConst("c", 8);
                constraints.add(ctx.mkEq(ctx.mkBVXOR(a, b), c));
                // Add some bounds to limit solutions
                constraints.add(ctx.mkBVULT(a, ctx.mkBV(5, 8)));
                constraints.add(ctx.mkBVULT(b, ctx.mkBV(5, 8)));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 11: Modular arithmetic a % 5 = 0
            {
                System.out.println("\nTest Case 11: Modular arithmetic a % 5 = 0");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                Expr five = ctx.mkBV(5, 32);
                Expr zero = ctx.mkBV(0, 32);
                constraints.add(ctx.mkEq(ctx.mkBVURem(a, five), zero)); // a % 5 = 0
                // Limit range to make it solvable
                constraints.add(ctx.mkBVULT(a, ctx.mkBV(100, 32)));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 12: System of equations a + b = 10, a - b = 4
            {
                System.out.println("\nTest Case 12: System of equations a + b = 10, a - b = 4");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                Expr b = ctx.mkBVConst("b", 32);
                constraints.add(ctx.mkEq(ctx.mkBVAdd(a, b), ctx.mkBV(10, 32))); // a + b = 10
                constraints.add(ctx.mkEq(ctx.mkBVSub(a, b), ctx.mkBV(4, 32))); // a - b = 4
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 13: Bit manipulation operations a & 0xF0 = 0xA0
            {
                System.out.println("\nTest Case 13: Bit manipulation a & 0xF0 = 0xA0");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 8); // 8-bit
                Expr mask = ctx.mkBV(0xF0, 8); // 0xF0
                Expr target = ctx.mkBV(0xA0, 8); // 0xA0
                constraints.add(ctx.mkEq(ctx.mkBVAND(a, mask), target)); // a & 0xF0 = 0xA0
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 14: More complex bit manipulation a | b = 0xFF, a & b = 0
            {
                System.out.println("\nTest Case 14: More complex bit manipulation a | b = 0xFF, a & b = 0");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 8);
                Expr b = ctx.mkBVConst("b", 8);
                Expr allOnes = ctx.mkBV(0xFF, 8);
                Expr zero = ctx.mkBV(0, 8);
                constraints.add(ctx.mkEq(ctx.mkBVOR(a, b), allOnes)); // a | b = 0xFF
                constraints.add(ctx.mkEq(ctx.mkBVAND(a, b), zero)); // a & b = 0
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 15: Circular relationship a > b, b > c, c > a (UNSAT)
            {
                System.out.println("\nTest Case 15: Circular relationship a > b, b > c, c > a (UNSAT)");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                Expr b = ctx.mkBVConst("b", 32);
                Expr c = ctx.mkBVConst("c", 32);
                constraints.add(ctx.mkBVUGT(a, b)); // a > b
                constraints.add(ctx.mkBVUGT(b, c)); // b > c
                constraints.add(ctx.mkBVUGT(c, a)); // c > a
                
                List<String> results = solve(ctx, constraints);
                System.out.println(results.isEmpty() ? "UNSAT (correctly detected)" : "Test failed");
            }
            
            // Test Case 16: Bitwise rotation (a << 2) | (a >> 6) = 0xA5 (8-bit)
            {
                System.out.println("\nTest Case 16: Bitwise rotation (a << 2) | (a >> 6) = 0xA5");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 8);
                Expr rotated = ctx.mkBVOR(
                    ctx.mkBVSHL(a, ctx.mkBV(2, 8)),
                    ctx.mkBVLSHR(a, ctx.mkBV(6, 8))
                );
                constraints.add(ctx.mkEq(rotated, ctx.mkBV(0xA5, 8)));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 17: Large symbolic space a is 32-bit with minimal constraints
            {
                System.out.println("\nTest Case 17: Large symbolic space a is 32-bit with a > 0x7FFFFFFF");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                constraints.add(ctx.mkBVUGT(a, ctx.mkBV(0x7FFFFFFF, 32))); // a > 0x7FFFFFFF
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 18: Combined constraints with multiple operators
            {
                System.out.println("\nTest Case 18: Combined constraints (a & 0x0F) + (b & 0xF0) = 0xFF");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 8);
                Expr b = ctx.mkBVConst("b", 8);
                Expr resultxx = ctx.mkBVAdd(
                    ctx.mkBVAND(a, ctx.mkBV(0x0F, 8)),
                    ctx.mkBVAND(b, ctx.mkBV(0xF0, 8))
                );
                constraints.add(ctx.mkEq(resultxx, ctx.mkBV(0xFF, 8)));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 19: One solution among many variables
            {
                System.out.println("\nTest Case 19: One solution among many variables (a^2 + b^2 = c^2)");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32);
                Expr b = ctx.mkBVConst("b", 32);
                Expr c = ctx.mkBVConst("c", 32);
                
                // a^2 + b^2 = c^2 (looking for Pythagorean triples)
                Expr aSquared = ctx.mkBVMul(a, a);
                Expr bSquared = ctx.mkBVMul(b, b);
                Expr cSquared = ctx.mkBVMul(c, c);
                constraints.add(ctx.mkEq(ctx.mkBVAdd(aSquared, bSquared), cSquared));
                
                // Add constraints to find specific triples
                constraints.add(ctx.mkBVULT(a, ctx.mkBV(20, 32)));
                constraints.add(ctx.mkBVULT(b, ctx.mkBV(20, 32)));
                constraints.add(ctx.mkBVULT(c, ctx.mkBV(30, 32)));
                constraints.add(ctx.mkBVUGT(a, ctx.mkBV(0, 32)));
                constraints.add(ctx.mkBVUGT(b, ctx.mkBV(0, 32)));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            
            // Test Case 20: Boolean logic with BV as boolean values
            {
                System.out.println("\nTest Case 20: Boolean logic using BV as boolean values");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 1); // 1-bit BV as boolean
                Expr b = ctx.mkBVConst("b", 1);
                Expr c = ctx.mkBVConst("c", 1);
                
                // (a OR b) AND (NOT c) = 1
                Expr expr = ctx.mkBVAND(
                    ctx.mkBVOR(a, b),
                    ctx.mkBVNot(c)
                );
                constraints.add(ctx.mkEq(expr, ctx.mkBV(1, 1)));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }

                        // Test Case 20: Boolean logic with BV as boolean values
            {
                System.out.println("\nTest Case 20: Boolean logic using BV as boolean values");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 1); // 1-bit BV as boolean
                Expr b = ctx.mkBVConst("b", 1);
                Expr c = ctx.mkBVConst("c", 1);
                
                // (a OR b) AND (NOT c) = 1
                Expr expr = ctx.mkBVAND(
                    ctx.mkBVOR(a, b),
                    ctx.mkBVNot(c)
                );
                constraints.add(ctx.mkEq(expr, ctx.mkBV(1, 1)));
                
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            // Test Case 21: MM
            {
                System.out.println("\nTest Case 21: MM");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32); // 1-bit BV as boolean
                Expr b = ctx.mkBVConst("b", 32);
                Expr c = ctx.mkBVConst("c", 32);
                
                constraints.add(ctx.mkBVSGE(a, ctx.mkBV(0, 32)));
                constraints.add(ctx.mkBVSGE(b, ctx.mkBV(0, 32)));
                constraints.add(ctx.mkBVSGE(c, ctx.mkBV(0, 32)));
                constraints.add(ctx.mkBVSLE(c, ctx.mkBV(20, 32)));
                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
            // Test Case 22: NN
            {
                System.out.println("\nTest Case 22: NN");
                List<Expr> constraints = new ArrayList<>();
                Expr a = ctx.mkBVConst("a", 32); // 1-bit BV as boolean
                Expr b = ctx.mkBVConst("b", 32);
                Expr c = ctx.mkBVConst("c", 32);
                
                constraints.add(ctx.mkBVUGE(a, ctx.mkBV(0, 32)));

                List<String> results = solve(ctx, constraints);
                for (String result : results) {
                    System.out.println(result);
                }
            }
        }
    }
}
