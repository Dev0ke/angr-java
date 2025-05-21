package Engine;

import soot.Type;

import com.microsoft.z3.BitVecExpr;
import com.microsoft.z3.BitVecNum;
import com.microsoft.z3.CharSort;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.SeqExpr;

public class SymBase {
    public String name;
    public Boolean isNull;
    public Type type;   
    public Expr expr;

    public SymBase(){
        isNull = true;
    }

    public SymBase(Type type){
        this.type = type;
        isNull = true;
    }

    public SymBase(Type type, Expr expr){
        this.type = type;
        this.expr = expr;
        isNull = false;
    }

    public SymBase(Type type, String name){
        this.type = type;
        this.name = name;
        isNull = true;
    }

    public SymBase(Type type, Expr expr, String name){
        this.type = type;
        this.expr = expr;
        this.name = name;
        isNull = false;
    }

    public void setNull(boolean value) {
        isNull = value;
    }

    public boolean isNull() {
        return isNull;
    }
    
    public Expr getExpr(){
        return null;
    }

    public Type getType(){
        return type;
    }

    public void setType(Type type){
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public void setName(String nameString){
        this.name = nameString;
    }

    public boolean isBitVecExpr(){
        return this.expr instanceof BitVecExpr;
    }

    public boolean isBitVecNum(){
        return this.expr instanceof BitVecNum;
    }

    // public boolean isSeqExpr(){
    //     return this.expr instanceof SeqExpr;
    // }

    public boolean isString(){
        return this.expr instanceof SeqExpr;
    }

}
