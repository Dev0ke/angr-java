package Engine;
import com.microsoft.z3.*;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import soot.*;
import soot.dava.internal.javaRep.DIntConstant;
import soot.jimple.*;

import java.util.HashMap;
import java.util.Map;
import utils.Log;

public class Expression {

    // Common string constants to avoid repeated string creation
    private static final String STRING_TYPE = "java.lang.String";
    private static final String CHAR_SEQUENCE_TYPE = "java.lang.CharSequence";

    public static Expr makeSymbol(Context ctx, Type type, String name) {
        if (ctx == null || type == null || name == null) {
            return null;
        }
        
        // Use pattern matching for more efficient type checking
        if (type instanceof BooleanType) {
            return ctx.mkBoolConst(name);
        } 
        
        // Use bit vector for numeric types
        if (type instanceof ByteType) {
            return ctx.mkBVConst(name, 8);
        } 
        if (type instanceof CharType || type instanceof ShortType) {
            return ctx.mkBVConst(name, 16);
        } 
        if (type instanceof IntType) {
            return ctx.mkBVConst(name, 32);
        } 
        if (type instanceof LongType) {
            return ctx.mkBVConst(name, 64);
        } 
        
        // Handle reference types
        if (type instanceof RefType refType) {
            String refClassName = refType.getClassName();
            // Use String.equals for string comparison
            if (STRING_TYPE.equals(refClassName) || CHAR_SEQUENCE_TYPE.equals(refClassName)) {
                return ctx.mkString(name);
            }
            
            Log.error("Unsupported RefType in makeSymbol: " + refClassName);
            return null;
        }
        
        Log.error("Unsupported type in makeSymbol: " + type.getClass());
        return null;
    }
    

    // BV Width convert
    public static Expr makeCastExpr(Context ctx, Type type, Expr src) {
        if (src == null || ctx == null || type == null) {
            return null;
        }
        
        int targetWidth = TypeUtils.getTypeWidth(type);

        if (src instanceof BoolExpr) {
            return ctx.mkBV(src.isTrue() ? 1 : 0, targetWidth);
        }

        // Early validation to avoid ClassCastException
        if (!(src instanceof BitVecExpr)) {
            Log.error("Expected BitVecExpr but got: " + src.getClass());
            return null;
        }

        int srcWidth = ((BitVecExpr)src).getSortSize();
        
        // Fast path: if source and target widths are the same, return source
        if (srcWidth == targetWidth) {
            return src;
        }
        
        // Handle width conversion
        if (targetWidth > srcWidth) {
            return TypeUtils.isSignedType(type) 
                ? ctx.mkSignExt(targetWidth - srcWidth, src)
                : ctx.mkZeroExt(targetWidth - srcWidth, src);
        } else {
            return ctx.mkExtract(targetWidth - 1, 0, src);
        }
    }

    public static Expr makeExpr(Type type) {
        return null; // Empty implementation
    }
    


    public static Expr makeBinOpExpr(Context ctx, BinopExpr binopExpr, Expr left, Expr right) {
        if (ctx == null || binopExpr == null) {
            return null;
        }

        // Handle null operands
        if (binopExpr.getOp2() instanceof NullConstant) {
            if (binopExpr instanceof EqExpr) {
                if (left == null) return null;
                if (left.isConst()) return ctx.mkFalse();
                return ctx.mkEq(left, right);
            } else if (binopExpr instanceof NeExpr) {
                if (left == null) return null;
                if (left.isConst()) return ctx.mkTrue();
                return ctx.mkNot(ctx.mkEq(left, right));
            }
        }

        if (right == null || left == null) {
            return null;
        }

        // Convert boolean expressions to bit vectors
        if (left instanceof BoolExpr) {
            left = ctx.mkBV(left.isTrue() ? 1 : 0, 32);
        }
        if (right instanceof BoolExpr) {
            right = ctx.mkBV(right.isTrue() ? 1 : 0, 32);
        }

        // Type safety check
        if (!(left instanceof BitVecExpr) || !(right instanceof BitVecExpr)) {
            Log.error("Expected BitVecExpr but got: " + left.getClass() + " and " + right.getClass());
            return null;
        }

        BitVecExpr leftBV = (BitVecExpr) left;
        BitVecExpr rightBV = (BitVecExpr) right;
        Type leftType = binopExpr.getOp1().getType();
        boolean isSigned = TypeUtils.isSignedType(leftType);

        // Use instanceof pattern matching for more efficient operator checks
        // Comparison operators
        if (binopExpr instanceof EqExpr) {
            return ctx.mkEq(leftBV, rightBV);
        } 
        if (binopExpr instanceof NeExpr) {
            return ctx.mkNot(ctx.mkEq(leftBV, rightBV));
        } 
        if (binopExpr instanceof GeExpr) {
            return isSigned ? ctx.mkBVSGE(leftBV, rightBV) : ctx.mkBVUGE(leftBV, rightBV);
        } 
        if (binopExpr instanceof GtExpr) {
            return isSigned ? ctx.mkBVSGT(leftBV, rightBV) : ctx.mkBVUGT(leftBV, rightBV);
        } 
        if (binopExpr instanceof LeExpr) {
            return isSigned ? ctx.mkBVSLE(leftBV, rightBV) : ctx.mkBVULE(leftBV, rightBV);
        } 
        if (binopExpr instanceof LtExpr) {
            return isSigned ? ctx.mkBVSLT(leftBV, rightBV) : ctx.mkBVULT(leftBV, rightBV);
        }
        
        // Arithmetic operators
        if (binopExpr instanceof AddExpr) {
            return ctx.mkBVAdd(leftBV, rightBV);
        } 
        if (binopExpr instanceof SubExpr) {
            return ctx.mkBVSub(leftBV, rightBV);
        } 
        if (binopExpr instanceof MulExpr) {
            return ctx.mkBVMul(leftBV, rightBV);
        } 
        if (binopExpr instanceof DivExpr) {
            return isSigned ? ctx.mkBVSDiv(leftBV, rightBV) : ctx.mkBVUDiv(leftBV, rightBV);
        } 
        if (binopExpr instanceof RemExpr) {
            return isSigned ? ctx.mkBVSRem(leftBV, rightBV) : ctx.mkBVURem(leftBV, rightBV);
        }
        
        // Comparison operators
        if (binopExpr instanceof CmpExpr) {
            return ctx.mkEq(leftBV, rightBV);
        } 
        if (binopExpr instanceof CmpgExpr) {
            return isSigned ? ctx.mkBVSGE(leftBV, rightBV) : ctx.mkBVUGE(leftBV, rightBV);
        }
        
        // Bitwise operators
        if (binopExpr instanceof AndExpr) {
            return ctx.mkBVAND(leftBV, rightBV);
        } 
        if (binopExpr instanceof OrExpr) {
            return ctx.mkBVOR(leftBV, rightBV);
        } 
        if (binopExpr instanceof XorExpr) {
            return ctx.mkBVXOR(leftBV, rightBV);
        } 
        if (binopExpr instanceof ShlExpr) {
            return ctx.mkBVSHL(leftBV, rightBV);
        } 
        if (binopExpr instanceof ShrExpr) {
            return ctx.mkBVASHR(leftBV, rightBV);
        } 
        if (binopExpr instanceof UshrExpr) {
            return ctx.mkBVLSHR(leftBV, rightBV);
        }
        
        Log.error("Unsupported BinopExpr type: " + binopExpr.getClass());
        return null;
    }

    public static Expr makeUnOpExpr(Context ctx, UnopExpr unopExpr, Expr src) {
        if (ctx == null || unopExpr == null || src == null) {
            return null;
        }
        
        if (unopExpr instanceof NegExpr) {
            return ctx.mkNot(src);
        } 
        
        Log.error("Unsupported UnopExpr type: " + unopExpr.getClass());
        return null;
    }

    public static Expr makeConstantExpr(Context ctx, Constant src) {
        if (ctx == null || src == null) {
            return null;
        }

        // Handle arithmetic constants efficiently
        if (src instanceof ArithmeticConstant) {
            if (src instanceof BooleanConstant boolConstant) {
                return ctx.mkBV(boolConstant.getBoolean() ? 1 : 0, 1);
            }
            
            if (src instanceof CharConstant charConstant) {
                return ctx.mkBV(charConstant.value, 16);
            }
            
            if (src instanceof ByteConstant byteConstant) {
                return ctx.mkBV(byteConstant.value, 8);
            }
            
            if (src instanceof UByteConstant ubyteConstant) {
                return ctx.mkBV(ubyteConstant.value, 8);
            }
            
            if (src instanceof ShortConstant shortConstant) {
                return ctx.mkBV(shortConstant.value, 16);
            }
            
            if (src instanceof UShortConstant ushortConstant) {
                return ctx.mkBV(ushortConstant.value, 16);
            }
            
            if (src instanceof IntConstant intConstant) {
                return ctx.mkBV(intConstant.value, 32);
            }
            
            if (src instanceof UIntConstant uintConstant) {
                return ctx.mkBV(uintConstant.value, 32);
            }
            
            if (src instanceof DIntConstant dIntConstant) {
                return ctx.mkBV(dIntConstant.value, 32);
            }
            
            if (src instanceof LongConstant longConstant) {
                return ctx.mkBV(longConstant.value, 64);
            }
            
            if (src instanceof ULongConstant uLongConstant) {
                return ctx.mkBV(uLongConstant.value, 64);
            }
            
            Log.error("Unsupported ArithmeticConstant: " + src.getClass());
            return null;
        }
        
        // Handle other constant types
        if (src instanceof StringConstant stringConstant) {
            return ctx.mkString(stringConstant.value);
        }
        
        if (src instanceof NullConstant) {
            return ctx.mkBV(0xdeadbeef, 32);
        }
        
        if (src instanceof ClassConstant) {
            // TODO: Implement class constant handling
            Log.error("ClassConstant not yet implemented");
            return null;
        }
        
        Log.error("Unsupported Constant: " + src.getClass());
        return null;
    }

    public static Expr conditionToExpr() {
        return null; // Empty implementation
    }


}
