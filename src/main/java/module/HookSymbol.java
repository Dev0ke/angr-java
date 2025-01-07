package module;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;

import Engine.SimState;
import accessControl.CheckAppOpAPI;
import accessControl.CheckPermissionAPI;
import soot.Local;
import soot.Value;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.StringConstant;
import utils.Log;

import static accessControl.CheckPermissionAPI.*;

public class HookSymbol {
    // TODO add uid limit
    public static Expr handleUidAPI(InvokeExpr expr, SimState state, Context z3Ctx) {
        List<Value> args = expr.getArgs();
        String methodName = expr.getMethod().getName();
        if (methodName.equals("getCallingUid")) {
            String symbolName = "TYPE_UID#CallingUid";
            Expr uidExpr = state.getSymbolByName(symbolName);
            if (uidExpr == null) {
                uidExpr = z3Ctx.mkBVConst(symbolName, 32);
                state.addSymbol(uidExpr);
            }
            return uidExpr;
        }
        return null;
    }

    // TODO add uid limit
    public static Expr handlePidAPI(InvokeExpr expr, SimState state, Context z3Ctx) {
        List<Value> args = expr.getArgs();
        String methodName = expr.getMethod().getName();
        if (methodName.equals("getCallingPid")) {
            String symbolName = "TYPE_PID#CallingPid";
            Expr pidExpr = state.getSymbolByName(symbolName);
            if (pidExpr == null) {
                pidExpr = z3Ctx.mkBVConst(symbolName, 32);
                state.addSymbol(pidExpr);
            }
            return pidExpr;
        }
        return null;
    }

    public static Expr handleMyPidAPI(InvokeExpr expr, SimState state, Context z3Ctx) {
        String symbolName = "TYPE_PID#MY_PID";
        Expr pidExpr = state.getSymbolByName(symbolName);
        if (pidExpr == null) {
            pidExpr = z3Ctx.mkBVConst(symbolName, 32);
            state.addSymbol(pidExpr);
        }
        return pidExpr;

    }

    public static Expr handleAppOpAPI(InvokeExpr expr, SimState state, Context z3Ctx) {
        List<Value> args = expr.getArgs();
        String methodName = expr.getMethod().getName();
        if (CheckAppOpAPI.getAllMethodNameByClassName("android.app.AppOpsManager").contains(methodName)
                || methodName.equals("noteOp") || methodName.equals("checkOp")) {
            // get APPOP STR
            String appOPSTR;
            if (args.get(0) instanceof StringConstant)
                appOPSTR = ((StringConstant) args.get(0)).value;
            // TODO FIX APPOP 2 OPSTR
            else if (args.get(0) instanceof IntConstant)
                appOPSTR = String.valueOf(((IntConstant) args.get(0)).value);
            else if (args.get(0) instanceof Local) {
                Value permission = args.get(0);
                Expr permissionExpr = state.getExpr(permission);
                appOPSTR = permissionExpr.toString();
            } else {
                Log.error("[-] Unsupported APPOP type: " + args.get(0).getClass());
                return null;
            }
            String symbolName = "TYPE_AppOp#" + appOPSTR;

            // create or get Expr
            Expr AppOpExpr = state.getSymbolByName(symbolName);
            if (AppOpExpr == null) {
                AppOpExpr = z3Ctx.mkBVConst(symbolName, 32);
                state.addSymbol(AppOpExpr);
            }

            // add Constraint for possible results
            List<Expr> possbileValueConstraints = new ArrayList<>();
            for (int i : CheckAppOpAPI.POSSIBLE_APPOP_CHECK_RESULTS) {
                possbileValueConstraints.add(z3Ctx.mkEq(AppOpExpr, z3Ctx.mkBV(i, 32)));
            }
            state.addConstraint(z3Ctx.mkEq(z3Ctx.mkOr(possbileValueConstraints.toArray(new Expr[0])), z3Ctx.mkTrue()));
            return AppOpExpr;
        }
        return null;
    }

    public static Expr handlePermissionAPI(InvokeExpr expr, SimState state, Context z3Ctx) {
        List<Value> args = expr.getArgs();
        String methodName = expr.getMethod().getName();

        //enforcePermission
        if (methodName.startsWith("enforce")) {
            String permissionValue;
            if (args.get(0) instanceof StringConstant strConstant) {
                // add permission symbol
                permissionValue = strConstant.value;
            } else if (args.get(0) instanceof Local) {
                Value permission = args.get(0);
                Expr permissionExpr = state.getExpr(permission);
                permissionValue = permissionExpr.getString();
            } else {
                Log.error("[-] Unsupported permission type: " + args.get(0).getClass());
                return null;
            }

            // create or get Expr
            String permissionSymbolName = "TYPE_PERMISSION#" + permissionValue;
            Expr permissionExpr = state.getSymbolByName(permissionSymbolName);
            if (permissionExpr == null) {
                permissionExpr = z3Ctx.mkBVConst(permissionValue, 32);
                state.addSymbol(permissionExpr);
            }
            Expr enforceExpr = z3Ctx.mkEq(permissionExpr, z3Ctx.mkBV(PERMISSION_GRANTED, 32));
            state.addConstraint(enforceExpr);
            return enforceExpr;


        // checkPermission
        } else if (methodName.startsWith("check")) {
            String permissionValue;
            if (args.get(0) instanceof StringConstant strConstant) {
                // add permission symbol
                permissionValue = strConstant.value;
            } else if (args.get(0) instanceof Local) {
                Value permission = args.get(0);
                Expr permissionExpr = state.getExpr(permission);
                permissionValue = permissionExpr.getString();
            } else {
                Log.error("[-] Unsupported permission type: " + args.get(0).getClass());
                return null;
            }

            // create or get Expr
            String permissionSymbolName = "TYPE_PERMISSION#" + permissionValue;
            Expr permissionExpr = state.getSymbolByName(permissionSymbolName);
            if (permissionExpr == null) {
                permissionExpr = z3Ctx.mkBVConst(permissionValue, 32);
                state.addSymbol(permissionExpr);
            }

            // add Constraint for possible results
            List<Expr> possbileValueConstraints = new ArrayList<>();
            for (int i : CheckPermissionAPI.POSSIBLE_PERMISSIONS_CHECK_RESULTS_OLD) {
                possbileValueConstraints.add(z3Ctx.mkEq(permissionExpr, z3Ctx.mkBV(i, 32)));
            }
            state.addConstraint(z3Ctx.mkEq(z3Ctx.mkOr(possbileValueConstraints.toArray(new Expr[0])), z3Ctx.mkTrue()));
            return permissionExpr;
        }
        return null;
    }

}
