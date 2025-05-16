package Engine;

import soot.Type;
import com.microsoft.z3.Context;

public class SymBase {
    public String name;
    public static Context ctx;
    public Boolean isNull;
    public Type type;   

    public SymBase(){
        isNull = true;
    }

    public void setNull(boolean value) {
        isNull = value;
    }

    public boolean isNull() {
        return isNull;
    }


}
