package Engine;

import soot.Type;
import com.microsoft.z3.Expr;

public class SymObject {
    public Boolean isNull;
    public Expr expr;

    public SymObject(){
        isNull = true;
    }


    public void setNull(boolean value) {
        isNull = value;
    }

    public boolean isNull() {
        return isNull;
    }


}
