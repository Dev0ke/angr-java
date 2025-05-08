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

    public static Expr makeSymbol(Context ctx, Type type, String name){
        // All use BV
        Expr v = null;
        if(type instanceof BooleanType) {
            v = ctx.mkBoolConst(name);
        } else if(type instanceof ByteType) {
            v = ctx.mkBVConst(name, 8);           // byte用8位BV
        } else if(type instanceof CharType) {
            v = ctx.mkBVConst(name, 16);          // char用16位BV
        } else if(type instanceof ShortType) {
            v = ctx.mkBVConst(name, 16);          // short用16位BV
        } else if(type instanceof IntType) {
            v = ctx.mkBVConst(name, 32);          // int用32位BV
        } else if(type instanceof LongType) {
            v = ctx.mkBVConst(name, 64);          // long用64位BV                         // void类型返回null
        } else if(type instanceof RefType refType) {
            //java.lang.String
            String refClassName = refType.getClassName();
            if(refClassName.equals("java.lang.String") || refClassName.equals("java.lang.CharSequence"))
                v = ctx.mkString(name);
            
            //TODO LIST
            // else if(refClassName.equals("soot.ArrayType")){
                
            // }
       
            else{
                Log.error("Unsupported RefType in makeSymbol: " + refType.getClassName());
            }
        } 
        else {
            Log.error("Unsupported type in makeSymbol: " + type.getClass());
        }
        
        return v;
    }
    
    //BV Width convert
    // src is BV
    public static Expr makeCastExpr(Context ctx, Type type, Expr src) {
        Expr value = null;
        if(src == null)
            return null;
        
        int targetWidth = getTypeWidth(type);

        if(src instanceof BoolExpr){
            return ctx.mkBV(src.isTrue() ? 1 : 0, targetWidth);
        }


        int srcWidth = ((BitVecExpr)src).getSortSize();
        // 如果源和目标位宽相同，直接返回
        if(srcWidth == targetWidth) {
            return src;
        }
        
        
        // 扩展位宽
        if(targetWidth > srcWidth) {
            // 有符号类型使用符号扩展，无符号类型使用零扩展
            if(isSignedType(type)) {
                value = ctx.mkSignExt(targetWidth - srcWidth, src);
            } else {
                value = ctx.mkZeroExt(targetWidth - srcWidth, src);
            }
        }
        // 缩小位宽
        else {
            value = ctx.mkExtract(targetWidth - 1, 0, src);
        }
        
        return value;
    }

    public static Expr makeExpr(Type type){
        Expr v = null;
        return v;
    }


    // public static Expr convertToBV(Context ctx, Expr src){
    //     Expr v = null;
    //     if(src.isBV())
    //         v = src;
    //     else if(src.isInt()){ //TODO FIX LONG 
    //         v = ctx.mkInt2BV(64, src);
    //     } else if(src.isBool()){
    //         v = ctx.mkInt2BV(1, src);
    //     } else{
    //         Log.error("Unsupported type: " + src.getClass());
    //     }
    //     return v;
    // }
    
    
    public static boolean isSignedType(Type type){
        if(type instanceof ByteType || type instanceof ShortType || type instanceof IntType || type instanceof LongType || type instanceof DoubleType || type instanceof FloatType)
            return true;
        return false;
    }

    public static Expr makeBinOpExpr(Context ctx, BinopExpr binopExpr, Expr left, Expr right){
        Expr v = null;

        Type leftType = binopExpr.getOp1().getType();
        boolean isSigned = isSignedType(leftType);

        //handle null
        //TODO is it right?
        if(binopExpr.getOp2() instanceof NullConstant){
            if(binopExpr instanceof EqExpr){
                if(left == null)
                    return null;
                else if(left.isConst())
                    return ctx.mkFalse();
                return ctx.mkEq(left, right);
            }
            else if(binopExpr instanceof NeExpr){
                if(left == null)
                    return null;
                else if(left.isConst())
                    return ctx.mkTrue();
                return ctx.mkNot(ctx.mkEq(left,right));
            }
        }


        if (right == null || left == null)
            return null;    


        // TODO UNSTABLE PATCH
        if(left instanceof BoolExpr){
            left = ctx.mkBV(left.isTrue() ? 1 : 0, 32);
        }
        if(right instanceof BoolExpr){
            right = ctx.mkBV(right.isTrue() ? 1 : 0, 32);
        }

        assert(left instanceof BitVecExpr && right instanceof BitVecExpr);
        BitVecExpr leftBV = (BitVecExpr) left;
        BitVecExpr rightBV = (BitVecExpr) right;

        if (binopExpr instanceof EqExpr) {
            v = ctx.mkEq(leftBV, rightBV);
        } else if (binopExpr instanceof NeExpr) {
            v = ctx.mkNot(ctx.mkEq(leftBV, rightBV));
        } else if (binopExpr instanceof GeExpr) {
            v = isSigned ? ctx.mkBVSGE(leftBV, rightBV) : ctx.mkBVUGE(leftBV, rightBV);
        } else if (binopExpr instanceof GtExpr) {
            v = isSigned ? ctx.mkBVSGT(leftBV, rightBV) : ctx.mkBVUGT(leftBV, rightBV);
        } else if (binopExpr instanceof LeExpr) {
            v = isSigned ? ctx.mkBVSLE(leftBV, rightBV) : ctx.mkBVULE(leftBV, rightBV);
        } else if (binopExpr instanceof LtExpr) {
            v = isSigned ? ctx.mkBVSLT(leftBV, rightBV) : ctx.mkBVULT(leftBV, rightBV);
        }   
        // 算术运算
        else if (binopExpr instanceof AddExpr) {
            v = ctx.mkBVAdd(leftBV, rightBV);
        } else if (binopExpr instanceof SubExpr) {
            v = ctx.mkBVSub(leftBV, rightBV);
        } else if (binopExpr instanceof MulExpr) {
            v = ctx.mkBVMul(leftBV, rightBV);
        } else if (binopExpr instanceof DivExpr) {
            v = isSigned ? ctx.mkBVSDiv(leftBV, rightBV) : ctx.mkBVUDiv(leftBV, rightBV);
        } else if (binopExpr instanceof RemExpr) {
            v = isSigned ? ctx.mkBVSRem(leftBV, rightBV) : ctx.mkBVURem(leftBV, rightBV);
        }   
        // 比较运算
        else if (binopExpr instanceof CmpExpr) {
            v = ctx.mkEq(leftBV, rightBV);
        } else if (binopExpr instanceof CmpgExpr) {
            v = isSigned ? ctx.mkBVSGE(leftBV, rightBV) : ctx.mkBVUGE(leftBV, rightBV);
        } 
        // 位运算 
        else if (binopExpr instanceof AndExpr) {
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
        else {
            Log.error("Unsupported BinopExpr type: " + binopExpr.getClass());
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
            Log.error("Unsupported UnopExpr type: " + unopExpr.getClass());
        }  else{
            Log.error("Unsupported UnopExpr type: " + unopExpr.getClass());
        }
        return v;
    }


    public static Expr makeConstantExpr(Context ctx, Constant src) {
        Expr v = null;
        if(src == null)
            return null;
        if(src instanceof ArithmeticConstant) {
            if(src instanceof BooleanConstant boolConstant)
                v = ctx.mkBV(boolConstant.getBoolean() ? 1 : 0, 1);
            else if(src instanceof CharConstant charConstant)
                v = ctx.mkBV(charConstant.value, 16);  // char是16位无符号
            else if(src instanceof ByteConstant byteConstant)
                v = ctx.mkBV(byteConstant.value, 8);   // byte是8位有符号
            else if(src instanceof UByteConstant ubyteConstant)
                v = ctx.mkBV(ubyteConstant.value, 8);  // ubyte是8位无符号
            else if(src instanceof ShortConstant shortConstant)
                v = ctx.mkBV(shortConstant.value, 16); // short是16位有符号
            else if(src instanceof UShortConstant ushortConstant)
                v = ctx.mkBV(ushortConstant.value, 16); // ushort是16位无符号
            else if(src instanceof IntConstant intConstant)
                v = ctx.mkBV(intConstant.value, 32);    // int是32位有符号
            else if(src instanceof UIntConstant uintConstant)
                v = ctx.mkBV(uintConstant.value, 32);   // uint是32位无符号
            else if(src instanceof DIntConstant dIntConstant)
                v = ctx.mkBV(dIntConstant.value, 32);   // dint是32位有符号
            else if(src instanceof LongConstant longConstant)
                v = ctx.mkBV(longConstant.value, 64);   // long是64位有符号
            else if(src instanceof ULongConstant uLongConstant)
                v = ctx.mkBV(uLongConstant.value, 64);  // ulong是64位无符号
            else
                Log.error("Unsupported ArithmeticConstant: " + src.getClass()); 
        } else if(src instanceof StringConstant stringConstant)
            v = ctx.mkString(stringConstant.value);     // 字符串保持不变
        else if(src instanceof NullConstant)
            v = ctx.mkBV(0xdeadbeef, 32);               
        else if(src instanceof ClassConstant classConstant){
            String className = classConstant.value;
            //TODO          
        }
        else 
            Log.error("Unsupported Constant : " + src.getClass());
        
        return v;
    }

    public static Expr conditionToExpr(){


        return null;

    }


    
    public static int getTypeWidth(Type type) {
        // 有符号整数类型
        if (type instanceof ByteType) {
            return 8;
        } else if (type instanceof ShortType) {
            return 16;
        } else if (type instanceof IntType) {
            return 32;
        } else if (type instanceof LongType) {
            return 64;
        }
        // 无符号整数类型
        else if (type instanceof UByteType) {
            return 8;
        } else if (type instanceof UShortType) {
            return 16;
        } else if (type instanceof UIntType) {
            return 32;
        } else if (type instanceof ULongType) {
            return 64;
        }
        // 浮点类型
        else if (type instanceof FloatType) {
            return 32;
        } else if (type instanceof DoubleType) {
            return 64;
        }
        // 其他基本类型
        else if (type instanceof BooleanType) {
            return 1;
        } else if (type instanceof CharType) {
            return 16;
        } 
        
        // 对于不支持的类型抛出异常
        throw new RuntimeException("Unsupported type for width calculation: " + type);
    }
}
