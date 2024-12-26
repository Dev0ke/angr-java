package Engine;

import java.util.List;

import com.microsoft.z3.*;
public class SymbolSolver {
     
    public static boolean solveConstraintsSingle(Context z3Ctx, List<Expr> constraints) {
        if (constraints.size() == 0)
            return true;
        Solver s = z3Ctx.mkSolver();
        boolean sat = false;
        for (Expr c : constraints) {
            s.add(c);
        }

        if (s.check() == com.microsoft.z3.Status.SATISFIABLE) {
            sat = true;
        }
        return sat;
    }

     public static boolean solveConstraints(Context z3Ctx, List<Expr> constraints) {
      
        Solver s = z3Ctx.mkSolver();
        boolean sat = false;
        for (Expr c : constraints) {
            s.add(c);
       
        }
        // list all symbol and remove which is not constaint

        // while (s.check() == com.microsoft.z3.Status.SATISFIABLE) {
        // Log.info("[+] SATISFIABLE");
        // sat = true;
        //
        // Model model = s.getModel();
        // Map<Expr, Expr> currentSolution = new HashMap<>();
        //
        // // 获取并输出符号的解
        // for (FuncDecl<?> decl : model.getConstDecls()) {
        // String symbolName = decl.getName().toString();
        // Expr<?> value = model.getConstInterp(decl);
        // Log.info("Symbol: " + symbolName + ", Value: " + value);
        // currentSolution.put(this.z3Ctx.mkConst(decl), value);
        // }
        //
        // // 添加约束以避免找到相同的解
        // List<BoolExpr> blockingClause = new ArrayList<>();
        // for (Map.Entry<Expr, Expr> entry : currentSolution.entrySet()) {
        // blockingClause.add(this.z3Ctx.mkNot(this.z3Ctx.mkEq(entry.getKey(),
        // entry.getValue())));
        // }
        // s.add(this.z3Ctx.mkOr(blockingClause.toArray(new BoolExpr[0])));
        // }

       
        return sat;
    }
}
