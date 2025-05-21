package module;

import java.util.ArrayList;
import java.util.List;


import com.microsoft.z3.BitVecNum;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;


import Engine.SimState;
import accessControl.CheckAppOpAPI;
import accessControl.CheckPermissionAPI;
import accessControl.EnforcePermissionAPI;

import soot.jimple.InvokeExpr;
import utils.Log;

import static accessControl.EnforcePermissionAPI.*;

import Engine.SymBase;
import Engine.SymGen;
import Engine.SymPrim;
import Engine.SymString;

public class HookSymbol {
    public static final String UID_PREFIX = "<UID>";
    public static final String PID_PREFIX = "<PID>";
    public static final String APPOP_PREFIX = "<APPOP>";
    public static final String PERMISSION_PREFIX = "<PERMISSION>";
    // TODO add uid limit
    public static SymBase handleUidAPI(Context ctx, InvokeExpr expr, SimState state) {
        String methodName = expr.getMethod().getName();
        if (methodName.equals("getCallingUid")) {
            String symbolName = UID_PREFIX + "CallingUid";
            SymBase uid = state.getSymbolByName(symbolName);
            if (uid == null) {
                uid = SymGen.makeIntSym(ctx, symbolName);
                state.addSymbol(uid);
            }
            return uid;
        }
        return null;
    }

    // TODO add uid limit
    public static SymBase handlePidAPI(Context ctx, InvokeExpr expr, SimState state) {
        String methodName = expr.getMethod().getName();
        if (methodName.equals("getCallingPid")) {
            String symbolName = PID_PREFIX + "CallingPid";
            SymBase pid = state.getSymbolByName(symbolName);
            if (pid == null) {
                pid = SymGen.makeIntSym(ctx, symbolName);
                state.addSymbol(pid);
            }
            return pid;
        }
        return null;
    }

    public static SymBase handleMyPidAPI(Context ctx, InvokeExpr expr, SimState state) {
        String symbolName = PID_PREFIX + "MyPID";
        SymBase pid = state.getSymbolByName(symbolName);
        if (pid == null) {
            pid = SymGen.makeIntSym(ctx, symbolName);
            state.addSymbol(pid);
        }
        return pid;

    }

    public static SymBase handleAppOpAPI(Context ctx, InvokeExpr expr, SimState state) {
        List<SymBase> params = state.getLastParam();
        String methodName = expr.getMethod().getName();
        if (CheckAppOpAPI.getAllMethodNameByClassName("android.app.AppOpsManager").contains(methodName)
                || methodName.equals("noteOp") || methodName.equals("checkOp")) {
            // get APPOP STR
            String appOPSTR;
            SymBase appOP = params.get(0);
            if (appOP instanceof SymString symString) {
                appOPSTR = symString.getStringExpr().getString();
            } else if (appOP instanceof SymPrim symPrim) {
                appOPSTR = String.valueOf(symPrim.getExpr());
            } else if (appOP.isBitVecNum()){
                BitVecNum bitVecNum = (BitVecNum) appOP.getExpr();
                appOPSTR = String.valueOf(bitVecNum.getLong());
            } else {
                Log.error("Unsupported APPOP type: " + params.get(0).getClass());
                return null;
            }
            String symbolName = APPOP_PREFIX + appOPSTR;

            // create or get Expr
            SymBase AppOpSym = state.getSymbolByName(symbolName);
            if (AppOpSym == null) {
                AppOpSym = SymGen.makeIntSym(ctx, symbolName);
                state.addSymbol(AppOpSym);
            }

            // add Constraint for possible results
            List<Expr> possbileValueConstraints = new ArrayList<>();
            for (int i : CheckAppOpAPI.POSSIBLE_APPOP_CHECK_RESULTS) {
                possbileValueConstraints.add(ctx.mkEq(AppOpSym.getExpr(), ctx.mkBV(i, 32)));
            }
            state.addConstraint(ctx.mkEq(ctx.mkOr(possbileValueConstraints.toArray(new Expr[0])), ctx.mkTrue()));
            return AppOpSym;
        }
        return null;
    }

    public static SymBase handlePermissionAPI(Context ctx, InvokeExpr expr, SimState state) {
        List<SymBase> params = state.getLastParam();
        String className = expr.getMethod().getDeclaringClass().getName();
        String methodName = expr.getMethod().getName();

        //enforcePermission
        if (EnforcePermissionAPI.isEnforcePermissionAPI(className, methodName)) {
            SymBase param = params.get(0);
            String permissionValue;
            if (param instanceof SymString symString) {
                permissionValue = symString.getStringExpr().getString();
            } else {
                permissionValue = "UNFOUND";
            }

            // create or get Expr
            String permissionSymbolName = PERMISSION_PREFIX + permissionValue;
            SymBase permissionSym = state.getSymbolByName(permissionSymbolName);
            if (permissionSym == null) {
                permissionSym = SymGen.makeIntSym(ctx, permissionSymbolName);
                state.addSymbol(permissionSym);
            }
            Expr enforceExpr = ctx.mkEq(permissionSym.getExpr(), ctx.mkBV(PERMISSION_GRANTED, 32));
            state.addConstraint(enforceExpr);
            return permissionSym;


        // checkPermission
        } else if (CheckPermissionAPI.isCheckPermissionAPI(className, methodName)) {
            String permissionValue;
            SymBase param = params.get(0);
            if (param instanceof SymString symString) {
                permissionValue = symString.getStringExpr().getString();
            } else {
                permissionValue = "UNFOUND";
            }


            // create or get Expr
            String permissionSymbolName = PERMISSION_PREFIX + permissionValue;
            SymBase permissionSym = state.getSymbolByName(permissionSymbolName);
            if (permissionSym == null) {
                permissionSym = SymGen.makeIntSym(ctx, permissionSymbolName);
                state.addSymbol(permissionSym);
            }

            // add Constraint for possible results
            List<Expr> possbileValueConstraints = new ArrayList<>();
            for (int i : EnforcePermissionAPI.POSSIBLE_PERMISSIONS_CHECK_RESULTS) {
                possbileValueConstraints.add(ctx.mkEq(permissionSym.getExpr(), ctx.mkBV(i, 32)));
            }
            state.addConstraint(ctx.mkEq(ctx.mkOr(possbileValueConstraints.toArray(new Expr[0])), ctx.mkTrue()));
            return permissionSym;
        }
        return null;
    }

}
