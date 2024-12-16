package Engine;
import com.microsoft.z3.*;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import soot.*;
import soot.dava.internal.javaRep.DIntConstant;
import soot.jimple.*;
import soot.jimple.internal.*;

import utils.Log;

public class Expression {
    public static Expr makeCastExpr(Context ctx,Type type, Expr src){
        Expr value = null;

        if(type instanceof BooleanType){
            // src != 0 
            value = ctx.mkNot(ctx.mkEq(src, ctx.mkInt(0)));
        }
        return value;

    }

    public static Expr makeExpr(Type type){
        Expr v = null;
        return v;
    }


    public static Expr convertToBV(Context ctx, Expr src){
        Expr v = null;
        if(src.isBV())
            v = src;
        else if(src.isInt()){ //TODO FIX LONG 
            v = ctx.mkInt2BV(64, src);
        } else if(src.isBool()){
            v = ctx.mkInt2BV(1, src);
        } else{
            Log.error("[Expression] Unsupported type: " + src.getClass());
        }
        return v;
    }
    
    public static Expr handleBVCalculate(Context ctx, BinopExpr binopExpr, Expr left, Expr right) {
        Expr v = null;
        Expr leftBV = convertToBV(ctx, left);
        Expr rightBV = convertToBV(ctx, right);
        
        // 执行位运算
        if (binopExpr instanceof AndExpr) {
            v = ctx.mkBVAND(leftBV, rightBV);
        } else if (binopExpr instanceof OrExpr) {
            v = ctx.mkBVOR(leftBV, rightBV);
        } else if (binopExpr instanceof XorExpr) {
            v = ctx.mkBVXOR(leftBV, rightBV);
        } else if (binopExpr instanceof ShlExpr) {
            v = ctx.mkBVSHL(leftBV, rightBV);
        } else if (binopExpr instanceof ShrExpr) {
            v = ctx.mkBVASHR(leftBV, rightBV);
        } else if (binopExpr instanceof UshrExpr) {
            v = ctx.mkBVLSHR(leftBV, rightBV);
        }
        
        // 将结果转换回左操作数的类型
        if (left.isInt()) {
            v = ctx.mkBV2Int(v, true);
        } else if (left.isBool()) {
            // 对于布尔类型，我们需要检查结果是否为0
            v = ctx.mkNot(ctx.mkEq(v, ctx.mkBV(0, 1)));
        }
        // 如果左操作数已经是BV类型，则不需要转换
        
        return v;
    }


    public static Expr makeBinOpExpr(Context ctx,BinopExpr binopExpr, Expr left, Expr right){
        Expr v = null;
        if (right == null || left == null)
              return null;    
        // TODO FIX?
        if (binopExpr instanceof EqExpr) {
            if (right.toString().contains("NULL") ) {
                if (left == null)
                    v = ctx.mkTrue();
                else
                    v = ctx.mkFalse();
            } else
                v = ctx.mkEq(left, right);
        } else if (binopExpr instanceof NeExpr) {
            if (right.toString().contains("NULL") ) {
                if (left != null)
                    v = ctx.mkTrue();
                else
                    v = ctx.mkFalse();
            } else
                v = ctx.mkNot(ctx.mkEq(left, right));
        } else if (binopExpr instanceof GeExpr) {
            v = ctx.mkGe(left, right);
        } else if (binopExpr instanceof GtExpr) {
            v = ctx.mkGt(left, right);
        } else if (binopExpr instanceof LeExpr) {
            v = ctx.mkLe(left, right);
        } else if (binopExpr instanceof LtExpr) {
            v = ctx.mkLt(left, right);
        }   
        // base
        else if (binopExpr instanceof AddExpr) {
            v = ctx.mkAdd(left, right);
        } else if (binopExpr instanceof SubExpr) {
            v = ctx.mkSub(left, right);
        } else if (binopExpr instanceof MulExpr) {
            v = ctx.mkMul(left, right);
        } else if (binopExpr instanceof DivExpr) {
            v = ctx.mkDiv(left, right);
        } else if (binopExpr instanceof RemExpr) {
            v = ctx.mkRem(left, right);
        }   
        // CMPExpr
        // TODO is it right?
        else if (binopExpr instanceof CmpExpr) {
            v = ctx.mkEq(left, right);
        } else if (binopExpr instanceof CmpgExpr) {
            v = ctx.mkGe(left, right);
        } else if(binopExpr instanceof AndExpr || binopExpr instanceof OrExpr || binopExpr instanceof XorExpr || binopExpr instanceof ShlExpr || binopExpr instanceof ShrExpr || binopExpr instanceof UshrExpr) {
            v = handleBVCalculate(ctx, binopExpr, left, right);
        } 
        else{
            Log.error("[Expression] Unsupported BinopExpr type: " + binopExpr.getClass());
        }
    
        return v;
    }


    //TODO
    public static Expr makeUnOpExpr(Context ctx,UnopExpr unopExpr, Expr src){
        Expr v = null;
        if(src == null)
            return null;
        if (unopExpr instanceof NegExpr) {
            v = ctx.mkNot(src);
        } else if (unopExpr instanceof LengthExpr) {
            // TODO
            Log.error("[Expression] Unsupported UnopExpr type: " + unopExpr.getClass());
        }  else{
            Log.error("[Expression] Unsupported UnopExpr type: " + unopExpr.getClass());
        }
        return v;
    }


    public static Expr makeConstantExpr(Context ctx,Constant src){
        Expr v = null;
        if(src == null)
            return null;
        if(src instanceof ArithmeticConstant){
            if(src instanceof BooleanConstant boolConstant)
                v = ctx.mkBool(boolConstant.getBoolean());
            else if(src instanceof CharConstant charConstant)
                v = ctx.mkBV(charConstant.value, 16);
            else if(src instanceof ByteConstant byteConstant)
                v = ctx.mkBV(byteConstant.value, 8);
            else if(src instanceof UByteConstant ubyteConstant)
                v = ctx.mkBV(ubyteConstant.value, 8);
            else if(src instanceof ShortConstant shortConstant)
                v = ctx.mkInt(shortConstant.value);
            else if(src instanceof UShortConstant ushortConstant)
                v = ctx.mkBV(ushortConstant.value, 16);
            else if(src instanceof IntConstant intConstant)
                v = ctx.mkInt(intConstant.value);
            else if(src instanceof UIntConstant uintConstant)
                v = ctx.mkBV(uintConstant.value, 16);
            else if(src instanceof DIntConstant dIntConstant)
                v = ctx.mkInt(dIntConstant.value);
            else if(src instanceof LongConstant longConstant)
                v = ctx.mkInt(longConstant.value);
            else if(src instanceof ULongConstant uLongConstant)
                v = ctx.mkBV(uLongConstant.value, 64);
            else
                Log.error("[Expression] Unsupported ArithmeticConstant: " + src.getClass()); 
        } else if(src instanceof StringConstant stringConstant)
            v = ctx.mkString(stringConstant.value);
        else if(src instanceof NullConstant)
            v = ctx.mkIntConst("NULL");
        else 
            Log.error("[Expression] Unsupported : " + src.getClass());
        
        return v;
    }
    
}
