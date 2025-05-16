package Engine;
import com.microsoft.z3.*;
import soot.*;
import soot.jimple.ArrayRef;
import soot.jimple.*;
import soot.jimple.internal.*;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;

import utils.Log;
/**
 * Symbolic representation of a Java List using Z3 arrays
 */
public class SymArray extends SymBase {
    private static final int INDEX_BV_SIZE = 32;  // Size of index bitvectors
    private static final String STRING_TYPE = "java.lang.String";
    private static final String CHAR_SEQUENCE_TYPE = "java.lang.CharSequence";

    public static SeqExpr makeArray(Context ctx, JNewArrayExpr newArrayExpr, String name) {
        Type type = newArrayExpr.getType();
        if(type instanceof ArrayType arrayType) {
            Type elementType = arrayType.getElementType();
            if(elementType instanceof PrimType primType) {
                return makePrimArray(ctx, primType, name);
            } else if(elementType instanceof RefType refType) {
                return makeRefArray(ctx, refType, name);
            } else {
                Log.error("Unsupported element type: " + elementType);
                return null;
            }
        } else{
            Log.error("Not ArrayType: " + type);
            return null;
        }


        
    }

    public static BitVecSort makeIndexSort(Context ctx) {
        return ctx.mkBitVecSort(INDEX_BV_SIZE);
    }
    
    private static SeqExpr makePrimArray(Context ctx, PrimType elementType, String name) {
        int elementWidth = TypeUtils.getTypeWidth(elementType);
        // Value size = newArrayExpr.getSize();
        // BitVecSort indexSort = makeIndexSort(ctx);
        BitVecSort elementSort = ctx.mkBitVecSort(elementWidth);
        // Create array for storing elements
        SeqSort seqSort = ctx.mkSeqSort(elementSort);
        SeqExpr array = ctx.mkEmptySeq(seqSort);
        return array;
    }

    public static SeqExpr makeRefArray(Context ctx, RefType elementType, String name) {
        String refClassName = elementType.getClassName();
        if(STRING_TYPE.equals(refClassName) || CHAR_SEQUENCE_TYPE.equals(refClassName)) {
            // BitVecSort indexSort = makeIndexSort(ctx);
            Sort elementSort = ctx.mkStringSort();
            SeqSort seqSort = ctx.mkSeqSort(elementSort);
            SeqExpr array = ctx.mkEmptySeq(seqSort);
            return array;
        } else{
            Log.error("Unsupported element type: " + elementType);
        }
        return null;
    }

    public static Expr get(Context ctx, SeqExpr array, BitVecExpr index) {
        return ctx.mkSelect(array, index);
    }

    public static void set(Context ctx, SeqExpr array, BitVecExpr index, Expr value) {
        ctx.mkSeqUpdate(array, index, value);
    }

    public static BitVecExpr lengthOf(Context ctx, SeqExpr array) {
        IntExpr length = ctx.mkLength(array);
        //convert to bitvec
        BitVecExpr lengthExpr = ctx.mkInt2BV(INDEX_BV_SIZE, length);
        return lengthExpr;
    }

    



  
}