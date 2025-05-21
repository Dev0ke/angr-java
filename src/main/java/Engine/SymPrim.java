package Engine;

import com.microsoft.z3.BitVecExpr;
import com.microsoft.z3.Expr;

import soot.Type;

public class SymPrim extends SymBase{
    // public SymPrim(String name, Type type){
    //     super(name, type);
    // }
    public String name;
    
    public SymPrim(Type type){
        super(type);
        this.isNull = false;
    }
    public SymPrim(Type type, String name){
        super(type, name);        
        this.isNull = false;
    }

    public SymPrim(Type type, Expr expr){
        super(type, expr);
        this.isNull = false;
    }

    public SymPrim(Type type, Expr expr, String name){
        super(type, expr, name);
        this.isNull = false;
    }

    public SymPrim(Type type, BitVecExpr expr){
        super(type);
        this.expr = expr;
        isNull = false;
    }

    public Expr getExpr(){
        return expr;
    }

    public boolean isPrimType(){
        return TypeUtils.isPrimType(this.type);
    }

    


}
