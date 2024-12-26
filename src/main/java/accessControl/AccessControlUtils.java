package accessControl;

import com.microsoft.z3.Expr;

public  class AccessControlUtils {
    public static boolean isAccessControlExpr(Expr e) {
        return e.toString().contains("TYPE_");
    }

    public static boolean isUIDExpr(Expr e) {
        return e.toString().contains("TYPE_UID");
    }

    public static boolean isPIDExpr(Expr e) {
        return e.toString().contains("TYPE_PID");
    }
}
