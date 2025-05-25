package Engine;


import com.microsoft.z3.*;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import soot.*;
import soot.dava.internal.javaRep.DIntConstant;
import soot.jimple.*;
import soot.jimple.internal.JNewArrayExpr;
import utils.Log;


public class SymGen {
    // public Context ctx;
    private static final String STRING_TYPE = "java.lang.String";
    private static final String CHAR_SEQUENCE_TYPE = "java.lang.CharSequence";
    private static final String STRING_BUILDER_TYPE = "java.lang.StringBuilder";

    public static SymBase makeArray(Context ctx, JNewArrayExpr newArrayExpr, String name){
        // Extract the base type of the array
        Type baseType = newArrayExpr.getBaseType();
        
        // Extract array size expression
        Value sizeValue = newArrayExpr.getSize();
        
        // Handle constant size array
        if (sizeValue instanceof IntConstant) {
            int size = ((IntConstant) sizeValue).value;
            SymList arrayList = new SymList(baseType, name);
            
            // Pre-allocate array elements
            for (int i = 0; i < size; i++) {
                String elemName = name + "[" + i + "]";
                
                // Initialize according to type
                if (baseType instanceof PrimType) {
                    // For primitive types, create symbolic variables
                    SymBase elemValue = makeSymbol(ctx, baseType, elemName);
                    arrayList.add(elemValue);
                } else if (baseType instanceof RefType) {
                    RefType refType = (RefType) baseType;
                    String className = refType.getClassName();
                    
                    if (STRING_TYPE.equals(className) || CHAR_SEQUENCE_TYPE.equals(className)) {
                        // For strings, create symbolic string variables
                        SeqExpr<CharSort> stringExpr = ctx.mkString(elemName);
                        SymString stringElem = new SymString(stringExpr, elemName);
                        arrayList.add(stringElem);
                    } else {
                        // For other reference types, add null placeholder
                        arrayList.add(new SymBase(baseType, elemName));
                    }
                } else {
                    // For other types, add null placeholder
                    arrayList.add(new SymBase(baseType, elemName));
                }
            }
            
            return arrayList;
        } else {
            // Handle symbolic size array (size is not a constant)
            // For now, create a default-sized array
            SymList arrayList = new SymList(baseType, name);
            // Add a symbolic value to indicate it has unknown elements
            arrayList.add(makeSymbol(ctx, baseType, name + "[symbolic]"));
            
            Log.error("Array with non-constant size is not fully supported: " + newArrayExpr);
            return arrayList;
        }
    }

  

    public static SymBase mkFalse(Context ctx){
        return new SymPrim(BooleanType.v(), ctx.mkFalse());
    }
    public static SymBase mkTrue(Context ctx){
        return new SymPrim(BooleanType.v(), ctx.mkTrue());
    }


    public static SymBase makeIntSym(Context ctx, String name){
        SymPrim sym = new SymPrim(IntType.v(), ctx.mkBVConst(name, 32));
        sym.setName(name);
        return sym;
    }



    public static SymBase maketoString(Context ctx, SymBase sym){
        if(sym instanceof SymString symString){
            return symString;
        } else if(sym instanceof SymPrim prim){
            Expr expr = prim.getExpr();
            Type type = prim.getType();
            if(expr instanceof BitVecNum bitVecNum){
                if(type instanceof IntType){
                   int value = bitVecNum.getInt();
                   String str = String.valueOf(value);
                   return new SymString(ctx.mkString(str), str);
                } else if(type instanceof LongType){
                    long value = bitVecNum.getLong();
                    String str = String.valueOf(value);
                    return new SymString(ctx.mkString(str), str);
                } else if(type instanceof BooleanType){
                    boolean value = bitVecNum.getInt() == 1;
                    String str;
                    if(value){
                        str = "true";
                    } else{
                        str = "false";
                    }
                    return new SymString(ctx.mkString(str), str);
                } else if(type instanceof CharType){
                    char value = (char) bitVecNum.getInt();
                    String str = String.valueOf(value);
                    return new SymString(ctx.mkString(str), str);
                } else if(type instanceof ShortType){
                    short value = (short) bitVecNum.getInt();
                    String str = String.valueOf(value);
                    return new SymString(ctx.mkString(str), str);
                } else if(type instanceof ByteType){
                    byte value = (byte) bitVecNum.getInt();
                    String str = String.valueOf(value);
                    return new SymString(ctx.mkString(str), str);
                } else{
                    Log.error("Unsupported type in maketoString: " + type.toString());
                }
            }
        }
        return null;
    }

    public static SymBase makeSymbol(Context ctx, Type type, String name) {
        if (type instanceof BooleanType) {
            Expr expr = ctx.mkBoolConst(name);
            return new SymPrim(BooleanType.v(), expr, name);
        } else if (type instanceof ByteType) {
            Expr expr = ctx.mkBVConst(name, 8);
            return new SymPrim(type, expr, name);
        } else if (type instanceof CharType || type instanceof ShortType) {
            Expr expr = ctx.mkBVConst(name, 16);
            return new SymPrim(type, expr, name);
        } else if (type instanceof IntType) {
            Expr expr = ctx.mkBVConst(name, 32);
            return new SymPrim(type, expr, name);
        } else if (type instanceof LongType) {
            Expr expr = ctx.mkBVConst(name, 64);
            return new SymPrim(type, expr, name);
        } else if (type instanceof RefType refType) {
            String refClassName = refType.getClassName();
            // Use String.equals for string comparison
            if (STRING_TYPE.equals(refClassName) || CHAR_SEQUENCE_TYPE.equals(refClassName) || STRING_BUILDER_TYPE.equals(refClassName)) {
                SeqExpr<CharSort> stringExpr = ctx.mkString(name);
                return new SymString(stringExpr, name);
            } 
            
            Log.error("Unsupported RefType in makeSymbol: " + refClassName);
            return null;
        }
        // } else if (type instanceof ArrayType arrayType) {
        //     Type baseType = arrayType.getBaseType();
        // }
        
        Log.error("Unsupported type in makeSymbol: " + type.getClass());
        return null;
    }

    public static SymBase makeCastExpr(Context ctx, Type type, SymBase sym) {

        if(sym == null){
            return SymGen.makeSymbol(ctx, type, type.toString());
        }
        Expr src = sym.getExpr();
        if(src == null){
            return SymGen.makeSymbol(ctx, type, sym.getName()+"_cast_"+type.toString());
        }


        int targetWidth = TypeUtils.getTypeWidth(type);

        if (src instanceof BoolExpr) {
            // bool to BitVec
            // TODO : fix unknown BOOL EXPR
            BitVecExpr trueExpr = ctx.mkBV(1, targetWidth);
            BitVecExpr falseExpr = ctx.mkBV(0, targetWidth);
            Expr dst = ctx.mkITE(src, trueExpr, falseExpr);
            return new SymPrim(type, dst, sym.getName());
        }

        // Early validation to avoid ClassCastException
        if (!(src instanceof BitVecExpr)) {
            Log.error("Expected BitVecExpr but got: " + src.getClass());
            return null;
        }

        int srcWidth = ((BitVecExpr)src).getSortSize();
        
        // Fast path: if source and target widths are the same, return source
        if (srcWidth == targetWidth) {
            return sym;
        }
        
        // Handle width conversion
        if (targetWidth > srcWidth) {
            Expr dst = TypeUtils.isSignedType(type) 
                ? ctx.mkSignExt(targetWidth - srcWidth, src)
                : ctx.mkZeroExt(targetWidth - srcWidth, src);
            return new SymPrim(type, dst, sym.getName());
        } else {
            Expr dst = ctx.mkExtract(targetWidth - 1, 0, src);
            return new SymPrim(type, dst, sym.getName());
        }
    }


    public static SymBase makeBinOpExpr(Context ctx, BinopExpr binopExpr, SymBase leftSym, SymBase rightSym) {
    
        // Handle null operands
        if (binopExpr.getOp2() instanceof NullConstant) {
            if (binopExpr instanceof EqExpr) {
                if(leftSym == null){
                    return SymGen.makeSymbol(ctx,BooleanType.v(), binopExpr.toString());
                }
                if (leftSym.isNull()) {
                    return mkTrue(ctx);
                } else{
                    return mkFalse(ctx);
                }
             
            } else if (binopExpr instanceof NeExpr) {
                if(leftSym == null){
                    return SymGen.makeSymbol(ctx,BooleanType.v(), binopExpr.toString());
                }
                if (leftSym.isNull()) {
                    return mkFalse(ctx);
                } else{
                    return mkTrue(ctx);
                } 
            }
        }

        if(leftSym == null || rightSym == null){
            if( binopExpr instanceof ConditionExpr)
                return SymGen.makeSymbol(ctx,BooleanType.v(), binopExpr.toString());
            return SymGen.makeSymbol(ctx, binopExpr.getOp1().getType(), binopExpr.toString()); 
        }

        Expr left = leftSym.getExpr();
        Expr right = rightSym.getExpr();

        if(left == null || right == null){
            if( binopExpr instanceof ConditionExpr)
                return SymGen.makeSymbol(ctx,BooleanType.v(), binopExpr.toString());
            return SymGen.makeSymbol(ctx, binopExpr.getOp1().getType(), binopExpr.toString()); 
        }

        // Convert boolean expressions to bit vectors
        if (left instanceof BoolExpr) {
            left = makeCastExpr(ctx, IntType.v(), leftSym).getExpr();
        }
        if (right instanceof BoolExpr) {
            right = makeCastExpr(ctx, IntType.v(), rightSym).getExpr();
        }

        // Type safety check
        if (!(left instanceof BitVecExpr) || !(right instanceof BitVecExpr)) {
            Log.error("Expected BitVecExpr but got: " + left.getClass() + " and " + right.getClass());
            return SymGen.makeSymbol(ctx, BooleanType.v(), binopExpr.toString());
        }

        BitVecExpr leftBV = (BitVecExpr) left;
        BitVecExpr rightBV = (BitVecExpr) right;
        Type leftType = binopExpr.getOp1().getType();
        boolean isSigned = TypeUtils.isSignedType(leftType);

        // Use instanceof pattern matching for more efficient operator checks
        // Comparison operators
        Expr result;
        if (binopExpr instanceof EqExpr) {
            result = ctx.mkEq(leftBV, rightBV);
            return new SymPrim(BooleanType.v(), result);
        } 
        if (binopExpr instanceof NeExpr) {
            result = ctx.mkNot(ctx.mkEq(leftBV, rightBV));
            return new SymPrim(BooleanType.v(), result);
        } 
        if (binopExpr instanceof GeExpr) {
            result = isSigned ? ctx.mkBVSGE(leftBV, rightBV) : ctx.mkBVUGE(leftBV, rightBV);
            return new SymPrim(BooleanType.v(), result);
        } 
        if (binopExpr instanceof GtExpr) {
            result = isSigned ? ctx.mkBVSGT(leftBV, rightBV) : ctx.mkBVUGT(leftBV, rightBV);
            return new SymPrim(BooleanType.v(), result);
        } 
        if (binopExpr instanceof LeExpr) {
            result = isSigned ? ctx.mkBVSLE(leftBV, rightBV) : ctx.mkBVULE(leftBV, rightBV);
            return new SymPrim(BooleanType.v(), result);
        } 
        if (binopExpr instanceof LtExpr) {
            result = isSigned ? ctx.mkBVSLT(leftBV, rightBV) : ctx.mkBVULT(leftBV, rightBV);
            return new SymPrim(BooleanType.v(), result);
        }
        
        // Arithmetic operators
        if (binopExpr instanceof AddExpr) {
            result = ctx.mkBVAdd(leftBV, rightBV);
            return new SymPrim(leftSym.getType(), result);
        } 
        if (binopExpr instanceof SubExpr) {
            result = ctx.mkBVSub(leftBV, rightBV);
            return new SymPrim(leftSym.getType(), result);
        } 
        if (binopExpr instanceof MulExpr) {
            result = ctx.mkBVMul(leftBV, rightBV);
            return new SymPrim(leftSym.getType(), result);
        } 
        if (binopExpr instanceof DivExpr) {
            result = isSigned ? ctx.mkBVSDiv(leftBV, rightBV) : ctx.mkBVUDiv(leftBV, rightBV);
            return new SymPrim(leftSym.getType(), result);
        } 
        if (binopExpr instanceof RemExpr) {
            result = isSigned ? ctx.mkBVSRem(leftBV, rightBV) : ctx.mkBVURem(leftBV, rightBV);
            return new SymPrim(leftSym.getType(), result);
        }
        
        // Comparison operators
        if (binopExpr instanceof CmpExpr) {
            result = ctx.mkEq(leftBV, rightBV);
            return new SymPrim(BooleanType.v(), result);
        } 
        if (binopExpr instanceof CmpgExpr) {
            result = isSigned ? ctx.mkBVSGE(leftBV, rightBV) : ctx.mkBVUGE(leftBV, rightBV);
            return new SymPrim(BooleanType.v(), result);
        }
        
        // Bitwise operators
        if (binopExpr instanceof AndExpr) {
            result = ctx.mkBVAND(leftBV, rightBV);
            return new SymPrim(leftSym.getType(), result);
        } 
        if (binopExpr instanceof OrExpr) {
            result = ctx.mkBVOR(leftBV, rightBV);
            return new SymPrim(leftSym.getType(), result);
        } 
        if (binopExpr instanceof XorExpr) {
            result = ctx.mkBVXOR(leftBV, rightBV);
            return new SymPrim(leftSym.getType(), result);
        } 
        if (binopExpr instanceof ShlExpr) {
            result = ctx.mkBVSHL(leftBV, rightBV);
            return new SymPrim(leftSym.getType(), result);
        } 
        if (binopExpr instanceof ShrExpr) {
            result = ctx.mkBVASHR(leftBV, rightBV);
            return new SymPrim(leftSym.getType(), result);
        } 
        if (binopExpr instanceof UshrExpr) {
            result = ctx.mkBVLSHR(leftBV, rightBV);
            return new SymPrim(leftSym.getType(), result);
        }
        
        Log.error("Unsupported BinopExpr type: " + binopExpr.getClass());
        return null;
    }


    public static SymBase makeUnOpExpr(Context ctx, UnopExpr unopExpr, SymBase src) {
        if (unopExpr == null || src == null || src.isNull()) {
            return makeSymbol(ctx, unopExpr.getType(), unopExpr.toString());
        }
        if (src instanceof SymPrim prim) {
            if (unopExpr instanceof NegExpr) {
                BitVecExpr result = ctx.mkBVNeg(prim.expr);
                return new SymPrim(src.getType(), result);
            } 
            Log.error("Unsupported UnopExpr type: " + unopExpr.getClass());
        } else if (src instanceof SymList symList){
            if (unopExpr instanceof LengthExpr){
                BitVecExpr result = symList.lengthof(ctx);
                return new SymPrim(src.getType(), result);
            } else{
                Log.error("Unsupported UnopExpr type: " + unopExpr.getClass());
            }
        } else{
            Log.error("Unsupported SymBase type: " + src.getClass());
        }
        Log.error("Unsupported SymBase type: " + src.getClass());
        return null;
    }


    public static SymBase makeConstantExpr(Context ctx, Constant src) {
        Type type = src.getType();
        // Handle arithmetic constants efficiently
        if (src instanceof ArithmeticConstant) {
            if (src instanceof BooleanConstant boolConstant) {
                return new SymPrim(type, ctx.mkBV(boolConstant.getBoolean() ? 1 : 0, 1));
            }
            
            if (src instanceof CharConstant charConstant) {
                return new SymPrim(type, ctx.mkBV(charConstant.value, 16));
            }
            
            if (src instanceof ByteConstant byteConstant) {
                return new SymPrim(type, ctx.mkBV(byteConstant.value, 8));
            }
            
            if (src instanceof UByteConstant ubyteConstant) {
                return new SymPrim(type, ctx.mkBV(ubyteConstant.value, 8));
            }
            
            if (src instanceof ShortConstant shortConstant) {
                return new SymPrim(type, ctx.mkBV(shortConstant.value, 16));
            }
            
            if (src instanceof UShortConstant ushortConstant) {
                return new SymPrim(type, ctx.mkBV(ushortConstant.value, 16));
            }
            
            if (src instanceof IntConstant intConstant) {
                return new SymPrim(type, ctx.mkBV(intConstant.value, 32));
            }
            
            if (src instanceof UIntConstant uintConstant) {
                return new SymPrim(type, ctx.mkBV(uintConstant.value, 32));
            }
            
            if (src instanceof DIntConstant dIntConstant) {
                return new SymPrim(type, ctx.mkBV(dIntConstant.value, 32));
            }
            
            if (src instanceof LongConstant longConstant) {
                return new SymPrim(type, ctx.mkBV(longConstant.value, 64));
            }
            
            if (src instanceof ULongConstant uLongConstant) {
                return new SymPrim(type, ctx.mkBV(uLongConstant.value, 64));
            }
            
            Log.error("Unsupported ArithmeticConstant: " + src.getClass());
            return new SymBase(type);
        }
        
        // Handle other constant types
        if (src instanceof StringConstant stringConstant) {
            return new SymString(ctx, stringConstant);
        }
        
        if (src instanceof NullConstant) {
            return new SymBase(type);
        }
        
        if (src instanceof ClassConstant) {
            // TODO: Implement class constant handling
            Log.error("ClassConstant not yet implemented");
            return new SymBase(type);
        }
        
        Log.error("Unsupported Constant: " + src.getClass());
        return new SymBase(type);
    }
}
