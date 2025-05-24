// package Engine;

// import java.util.List;

// import com.microsoft.z3.*;
// import utils.Log;
// public class SymbolSolver {
//     public static int getBitVecIntValue(Context ctx, BitVecExpr targetBitVec, List<Expr> constraints)
//     {
//         Solver solver = ctx.mkSolver(); // 创建求解器
//         // 添加所有约束条件
//         for (Expr constraint : constraints) {
//             solver.add(constraint);
//         }
//         // 检查可满足性
//         Status status = solver.check();
//         if (status == Status.SATISFIABLE) {
//             Model model = solver.getModel(); // 获取模型
//             // 在模型下评估目标 BitVecExpr
//             // 第二个参数 'false' 表示在模型不能完全确定一个具体值时，不要创建新的常量。
//             // 对于求解具体值，我们期望它能被完全确定。
//             Expr resultExpr = model.eval(targetBitVec, false);
//             if (resultExpr instanceof BitVecNum) {
//                 BitVecNum bitVecResult = (BitVecNum) resultExpr;

//                 // 从 BitVecNum 获取 long 值。
//                 // BitVecNum.getInt() 也可以，但 getLong() 更通用一些，
//                 // 因为 bit-vector 可以表示比Java int更大的数。
//                 long longValue = bitVecResult.getLong(); // 或者 bitVecResult.getInt64()

//                 // 检查该 long 值是否在 Java int 的范围内
//                 if (longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) {
//                     return -1;
//                 }
//                 return (int) longValue;

//             } else {
//                 // 如果评估结果不是一个具体的 BitVecNum，说明可能存在问题
//                 return -1;
                
//             }
//         } else if (status == Status.UNSATISFIABLE) {
//             return -1;
//         } else { // Status.UNKNOWN
//             return -1;
//         }
//     }

//     public static boolean solveConstraintsSingle(Context z3Ctx, List<Expr> constraints) {
//         if (constraints.size() == 0)
//             return true;
//         Solver s = z3Ctx.mkSolver();
//         boolean sat = false;
//         for (Expr c : constraints) {
//             // Log.info("Constraint: " + c);
//             s.add(c);
//         }

//         if (s.check() == com.microsoft.z3.Status.SATISFIABLE) {
//             sat = true;
//         }
//         return sat;
//     }

//      public static boolean solveConstraints(Context z3Ctx, List<Expr> constraints) {
      
//         Solver s = z3Ctx.mkSolver();
//         boolean sat = false;
//         for (Expr c : constraints) {
//             s.add(c);
       
//         }
//         // list all symbol and remove which is not constaint

//         // while (s.check() == com.microsoft.z3.Status.SATISFIABLE) {
//         // Log.info("[+] SATISFIABLE");
//         // sat = true;
//         //
//         // Model model = s.getModel();
//         // Map<Expr, Expr> currentSolution = new HashMap<>();
//         //
//         // // 获取并输出符号的解
//         // for (FuncDecl<?> decl : model.getConstDecls()) {
//         // String symbolName = decl.getName().toString();
//         // Expr<?> value = model.getConstInterp(decl);
//         // Log.info("Symbol: " + symbolName + ", Value: " + value);
//         // currentSolution.put(this.z3Ctx.mkConst(decl), value);
//         // }
//         //
//         // // 添加约束以避免找到相同的解
//         // List<BoolExpr> blockingClause = new ArrayList<>();
//         // for (Map.Entry<Expr, Expr> entry : currentSolution.entrySet()) {
//         // blockingClause.add(this.z3Ctx.mkNot(this.z3Ctx.mkEq(entry.getKey(),
//         // entry.getValue())));
//         // }
//         // s.add(this.z3Ctx.mkOr(blockingClause.toArray(new BoolExpr[0])));
//         // }

       
//         return sat;
//     }

//      public static List<String> solve(Context ctx, List<Expr> toSolve) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'solve'");
//      }
// }
