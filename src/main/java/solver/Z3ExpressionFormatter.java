package solver;

import com.microsoft.z3.*;
import java.util.*;

import utils.Log;

public class Z3ExpressionFormatter {
    
    private static final Map<String, String> OPERATOR_MAP = new HashMap<String, String>() {{
        put("bvsge", ">=");
        put("bvsle", "<=");
        put("bvsgt", ">");
        put("bvslt", "<");
        put("bvule", "<=");
        put("bvuge", ">=");
        put("bvult", "<");
        put("bvugt", ">");
        put("bvadd", "+");
        put("bvsub", "-");
        put("bvmul", "*");
        put("bvudiv", "/");
        put("bvsdiv", "/");
        put("bvsdiv_i", "/");
        put("bvudiv_i", "/");
        put("bvurem", "%");
        put("bvsrem", "%");
        put("bvsrem_i", "%");
        put("bvurem_i", "%");
        put("bvsmod", "%");
        put("bvand", "&");
        put("bvor", "|");
        put("bvxor", "^");
        put("bvnot", "~");
        put("bvshl", "<<");
        put("bvlshr", ">>");
        put("bvashr", ">>>");
        put("bvshl_i", "<<");
        put("bvlshr_i", ">>");
        put("bvashr_i", ">>>");
        put("lengthof", "length");
    }};

    public static String formatExpression(Expr expr) {
        if (expr == null) return "";
        
        if (expr instanceof BoolExpr) {
            return formatBoolExpr((BoolExpr)expr);
        } else if (expr instanceof BitVecExpr) {
            return formatBitVecExpr((BitVecExpr)expr);
        } else if (expr instanceof IntExpr) {
            return formatIntExpr((IntExpr)expr);
        } else if (expr instanceof RealExpr) {
            return formatRealExpr((RealExpr)expr);
        } else {
            Log.info("Unknown expression type: " + expr.getClass().getName());
            return expr.toString();
        }
        
    }

    private static String formatBoolExpr(BoolExpr expr) {
        if (expr.isTrue()) return "true";
        if (expr.isFalse()) return "false";
        
        String declName = expr.getFuncDecl().getName().toString();
        
        if (OPERATOR_MAP.containsKey(declName)) {
            return formatBinaryOp(expr, OPERATOR_MAP.get(declName));
        }
        
        switch (declName) {
            case "not":
                Expr arg = expr.getArgs()[0];
                // Handle double negation
                if (arg instanceof BoolExpr && arg.getFuncDecl().getName().toString().equals("not")) {
                    return formatExpression(arg.getArgs()[0]);
                }
                // Handle negation of equality
                if (arg instanceof BoolExpr && arg.getFuncDecl().getName().toString().equals("=")) {
                    return formatBinaryOp(arg, "!=");
                }
                return "NOT " + formatExpression(arg);
            case "and":
                return formatNaryOp(expr, "AND");
            case "or":
                return formatNaryOp(expr, "OR");
            case "=":
                return formatBinaryOp(expr, "==");
            case "distinct":
                return formatBinaryOp(expr, "!=");
            default:
                return formatDefaultExpr(expr);
        }
    }

    private static String formatBitVecExpr(BitVecExpr expr) {
        if (expr instanceof BitVecNum) {
            BitVecNum num = (BitVecNum) expr;
            try {
                // Try to get the value as a long first
                return String.valueOf(num.getLong());
            } catch (Z3Exception e) {
                // If that fails, get the string representation
                return num.toString();
            }
        }
        
        String declName = expr.getFuncDecl().getName().toString();
        
        if (OPERATOR_MAP.containsKey(declName)) {
            if (declName.equals("lengthof")) {
                return OPERATOR_MAP.get(declName) + "(" + formatExpression(expr.getArgs()[0]) + ")";
            }
            if (declName.equals("bvnot")) {
                String arg = formatExpression(expr.getArgs()[0]);
                if (needsParentheses(expr.getArgs()[0], expr)) {
                    arg = "(" + arg + ")";
                }
                return OPERATOR_MAP.get(declName) + arg;
            }
            return formatBinaryOp(expr, OPERATOR_MAP.get(declName));
        }
        
        return formatDefaultExpr(expr);
    }

    private static String formatIntExpr(IntExpr expr) {
        if (expr instanceof IntNum) {
            return String.valueOf(((IntNum)expr).getInt());
        }
        return formatDefaultExpr(expr);
    }

    private static String formatRealExpr(RealExpr expr) {
        if (expr instanceof RatNum) {
            return expr.toString();
        }
        return formatDefaultExpr(expr);
    }

    private static String formatBinaryOp(Expr expr, String operator) {
        Expr[] args = expr.getArgs();
        if (args.length != 2) {
            return formatDefaultExpr(expr);
        }
        
        String left = formatExpression(args[0]);
        String right = formatExpression(args[1]);
        
        // Add parentheses if needed
        if (needsParentheses(args[0], expr)) {
            left = "(" + left + ")";
        }
        if (needsParentheses(args[1], expr)) {
            right = "(" + right + ")";
        }
        
        return left + " " + operator + " " + right;
    }

    private static String formatNaryOp(Expr expr, String operator) {
        Expr[] args = expr.getArgs();
        if (args.length == 0) {
            return formatDefaultExpr(expr);
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                result.append(" ").append(operator).append(" ");
            }
            String arg = formatExpression(args[i]);
            if (needsParentheses(args[i], expr)) {
                arg = "(" + arg + ")";
            }
            result.append(arg);
        }
        return result.toString();
    }

    private static String formatDefaultExpr(Expr expr) {
        if (expr.getArgs().length == 0) {
            return expr.toString();
        }
        
        StringBuilder result = new StringBuilder();
        result.append(expr.getFuncDecl().getName()).append("(");
        for (int i = 0; i < expr.getArgs().length; i++) {
            if (i > 0) result.append(", ");
            result.append(formatExpression(expr.getArgs()[i]));
        }
        result.append(")");
        return result.toString();
    }

    private static boolean needsParentheses(Expr child, Expr parent) {
        if (child.getArgs().length == 0) return false;
        
        String childOp = child.getFuncDecl().getName().toString();
        String parentOp = parent.getFuncDecl().getName().toString();
        
        // Define operator precedence
        Map<String, Integer> precedence = new HashMap<String, Integer>() {{
            put("bvnot", 4);
            put("lengthof", 4);
            put("bvand", 3);
            put("bvor", 2);
            put("bvxor", 2);
            put("bvadd", 1);
            put("bvsub", 1);
            put("bvmul", 1);
            put("bvudiv", 1);
            put("bvsdiv", 1);
            put("bvsdiv_i", 1);
            put("bvudiv_i", 1);
            put("bvurem", 1);
            put("bvsrem", 1);
            put("bvsrem_i", 1);
            put("bvurem_i", 1);
            put("bvsmod", 1);
            put("bvshl", 1);
            put("bvlshr", 1);
            put("bvashr", 1);
            put("bvshl_i", 1);
            put("bvlshr_i", 1);
            put("bvashr_i", 1);
        }};
        
        Integer childPrec = precedence.get(childOp);
        Integer parentPrec = precedence.get(parentOp);
        
        if (childPrec == null || parentPrec == null) return false;
        return childPrec < parentPrec;
    }

    public static String formatModelValue(Model model, Expr expr) throws Z3Exception {
        Expr value = model.evaluate(expr, false);
        if (value == null) return expr.toString() + " = undefined";
        
        String formattedExpr = formatExpression(expr);
        String formattedValue = formatExpression(value);
        return formattedExpr + " = " + formattedValue;
    }

    public static String formatConstraint(BoolExpr expr) {
        return formatExpression(expr);
    }
} 