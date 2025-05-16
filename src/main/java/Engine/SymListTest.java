// package Engine;

// import com.microsoft.z3.*;

// import soot.IntType;
// import soot.RefType;
// import soot.Scene;

// /**
//  * Test cases for the symbolic list implementation
//  */
// public class SymListTest {

//     /**
//      * Test basic list operations
//      */
//     public static void testBasicOperations() {
//         // Initialize Z3 context
//         Context ctx = new Context();
        
//         System.out.println("Testing basic list operations...");
        
//         // Create a list of integers
//         SymList intList = new SymList(ctx, IntType.v(), "intList");
        
//         // Add some constants
//         intList.add(ctx.mkBV(10, 32));
//         intList.add(ctx.mkBV(20, 32));
//         intList.add(ctx.mkBV(30, 32));
        
//         // Create a solver
//         Solver solver = ctx.mkSolver();
        
//         // Check that the list size is 3
//         BoolExpr sizeIs3 = ctx.mkEq(intList.size(), ctx.mkBV(3, 32));
//         solver.add(sizeIs3);
        
//         // Check that get(1) == 20
//         BoolExpr get1Is20 = ctx.mkEq(intList.get(1), ctx.mkBV(20, 32));
//         solver.add(get1Is20);
        
//         // Check list contains 30
//         BoolExpr contains30 = intList.contains(ctx.mkBV(30, 32));
//         solver.add(contains30);
        
//         // List should not contain 15
//         BoolExpr notContains15 = ctx.mkNot(intList.contains(ctx.mkBV(15, 32)));
//         solver.add(notContains15);
        
//         // Verify constraints
//         Status status = solver.check();
//         System.out.println("Constraint status: " + status);
//         if (status == Status.SATISFIABLE) {
//             System.out.println("Basic operation test passed!");
//         } else {
//             System.out.println("Basic operation test failed!");
//         }
//     }
    
//     /**
//      * Test list removal operation
//      */
//     public static void testRemoveOperation() {
//         // Initialize Z3 context
//         Context ctx = new Context();
        
//         System.out.println("Testing list removal...");
        
//         // Create a list of integers
//         SymList intList = new SymList(ctx, IntType.v(), "intList");
        
//         // Add some constants
//         intList.add(ctx.mkBV(10, 32));  // index 0
//         intList.add(ctx.mkBV(20, 32));  // index 1
//         intList.add(ctx.mkBV(30, 32));  // index 2
//         intList.add(ctx.mkBV(40, 32));  // index 3
        
//         // Remove element at index 1 (should be 20)
//         intList.remove(1);
        
//         // Create a solver
//         Solver solver = ctx.mkSolver();
        
//         // Check that the list size is now 3
//         BoolExpr sizeIs3 = ctx.mkEq(intList.size(), ctx.mkBV(3, 32));
//         solver.add(sizeIs3);
        
//         // Check that get(1) is now 30 (shifted from index 2)
//         BoolExpr get1Is30 = ctx.mkEq(intList.get(1), ctx.mkBV(30, 32));
//         solver.add(get1Is30);
        
//         // Check that get(2) is now 40 (shifted from index 3)
//         BoolExpr get2Is40 = ctx.mkEq(intList.get(2), ctx.mkBV(40, 32));
//         solver.add(get2Is40);
        
//         // Verify constraints
//         Status status = solver.check();
//         System.out.println("Constraint status: " + status);
//         if (status == Status.SATISFIABLE) {
//             System.out.println("Remove operation test passed!");
//         } else {
//             System.out.println("Remove operation test failed!");
//         }
//     }
    
//     /**
//      * Test symbolic reasoning with unknown values
//      */
//     public static void testSymbolicValues() {
//         // Initialize Z3 context
//         Context ctx = new Context();
        
//         System.out.println("Testing symbolic reasoning...");
        
//         // Create a list of integers
//         SymList intList = new SymList(ctx, IntType.v(), "intList");
        
//         // Create symbolic values
//         BitVecExpr a = (BitVecExpr) Expression.makeSymbol(ctx, IntType.v(), "a");
//         BitVecExpr b = (BitVecExpr) Expression.makeSymbol(ctx, IntType.v(), "b");
        
//         // Add to list
//         intList.add(a);
//         intList.add(b);
//         intList.add(ctx.mkBVAdd(a, b)); // a + b
        
//         // Create a solver
//         Solver solver = ctx.mkSolver();
        
//         // Set constraints: a > 0 and b > a
//         solver.add(ctx.mkBVSGT(a, ctx.mkBV(0, 32)));
//         solver.add(ctx.mkBVSGT(b, a));
        
//         // Check that get(2) > get(1)
//         // This means (a + b) > b
//         BoolExpr getConstraint = ctx.mkBVSGT(intList.get(2), intList.get(1));
//         solver.add(getConstraint);
        
//         // Verify constraints
//         Status status = solver.check();
//         System.out.println("Constraint status: " + status);
        
//         if (status == Status.SATISFIABLE) {
//             // Get model
//             Model model = solver.getModel();
//             System.out.println("Symbolic test passed with model:");
//             System.out.println("a = " + model.eval(a, false));
//             System.out.println("b = " + model.eval(b, false));
//             System.out.println("list[2] = " + model.eval(intList.get(2), false));
//         } else {
//             System.out.println("Symbolic test failed!");
//         }
//     }
    
//     /**
//      * Test sublist and equality operations
//      */
//     public static void testSublistAndEquality() {
//         // Initialize Z3 context
//         Context ctx = new Context();
        
//         System.out.println("Testing sublist and equality operations...");
        
//         // Create a list of integers
//         SymList intList = new SymList(ctx, IntType.v(), "intList");
        
//         // Add some constants
//         intList.add(ctx.mkBV(10, 32));  // index 0
//         intList.add(ctx.mkBV(20, 32));  // index 1
//         intList.add(ctx.mkBV(30, 32));  // index 2
//         intList.add(ctx.mkBV(40, 32));  // index 3
//         intList.add(ctx.mkBV(50, 32));  // index 4
        
//         // Create a sublist from index 1 to 4 (elements 20, 30, 40)
//         SymList subList = intList.subList(1, 4);
        
//         // Create a solver
//         Solver solver = ctx.mkSolver();
        
//         // Check that the sublist size is 3
//         BoolExpr sizeIs3 = ctx.mkEq(subList.size(), ctx.mkBV(3, 32));
//         solver.add(sizeIs3);
        
//         // Check that subList[0] = 20
//         BoolExpr sub0is20 = ctx.mkEq(subList.get(0), ctx.mkBV(20, 32));
//         solver.add(sub0is20);
        
//         // Check that subList[2] = 40
//         BoolExpr sub2is40 = ctx.mkEq(subList.get(2), ctx.mkBV(40, 32));
//         solver.add(sub2is40);
        
//         // Create another list with the same elements as the sublist
//         SymList equalList = new SymList(ctx, IntType.v(), "equalList");
//         equalList.add(ctx.mkBV(20, 32));
//         equalList.add(ctx.mkBV(30, 32));
//         equalList.add(ctx.mkBV(40, 32));
        
//         // Check that the sublist and equalList are equal
//         BoolExpr listsEqual = subList.equals(equalList);
//         solver.add(listsEqual);
        
//         // Verify constraints
//         Status status = solver.check();
//         System.out.println("Constraint status: " + status);
        
//         if (status == Status.SATISFIABLE) {
//             Model model = solver.getModel();
//             System.out.println("Sublist and equality test passed!");
//             System.out.println("Sublist size: " + model.eval(subList.size(), false));
//             System.out.println("EqualList size: " + model.eval(equalList.size(), false));
//         } else {
//             System.out.println("Sublist and equality test failed!");
//         }
        
//         // Now test that the original list and equalList are NOT equal
//         solver = ctx.mkSolver();
//         BoolExpr listsNotEqual = ctx.mkNot(intList.equals(equalList));
//         solver.add(listsNotEqual);
        
//         status = solver.check();
//         System.out.println("Lists should not be equal - Status: " + status);
//         if (status == Status.SATISFIABLE) {
//             System.out.println("Different-sized lists correctly identified as not equal!");
//         } else {
//             System.out.println("Different-sized lists equality check failed!");
//         }
//     }
    
//     /**
//      * Main test method
//      */
//     public static void main(String[] args) {
//         try {
//             testBasicOperations();
//             testRemoveOperation();
//             testSymbolicValues();
//             testSublistAndEquality();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// } 