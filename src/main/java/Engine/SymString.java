package Engine;
import com.microsoft.z3.*;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;

public class SymString extends SymObject {
    public SeqExpr<CharSort> value;

    public SymString(Context ctx, String str){
        value = ctx.mkString(str);
        isNull = false;
    }
    
    
}
