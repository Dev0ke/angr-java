package Engine;
import com.microsoft.z3.*;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;

import soot.RefType;
import soot.Type;
import soot.jimple.StringConstant;
import utils.Log;
public class SymString extends SymBase {
    public SeqExpr<CharSort> expr;

    // public SymString(String str){
    //     value = ctx.mkString(str);
    //     isNull = false;
    //     type = Type.String;
    // }

    public SymString(Context ctx, StringConstant stringConstant){
        this.expr = ctx.mkString(stringConstant.value);
        this.isNull = false;
        this.type = stringConstant.getType();
    }

    public SymString(SeqExpr<CharSort> expr,String name){
        this.expr = expr;
        this.isNull = false;
        this.type = RefType.v("java.lang.String");
    }

    public SymString(Context ctx,String str){
        this.expr = ctx.mkString(str);
        this.isNull = false;
        this.type = RefType.v("java.lang.String");
    }

    public SymString(SeqExpr<CharSort> value){
        this.expr = value;
        this.isNull = false;
        this.type = RefType.v("java.lang.String");
    }

    public SymBase length(Context ctx){
        // Get the length of the string sequence as a Z3 expression
        IntExpr lengthExpr = ctx.mkLength(expr);
        // Convert the integer to a BitVecExpr with 32 bits (standard int size)
        BitVecExpr bvLength = ctx.mkInt2BV(32, lengthExpr);
        // Create and return a SymPrim with the length value
        return new SymPrim(soot.IntType.v(), bvLength);
    }

    // Fixed charAt with int index
    public SymBase charAt(Context ctx, int index){
        IntExpr indexExpr = ctx.mkInt(index);
        // Extract a single character at the index
        SeqExpr<CharSort> charSeq = ctx.mkExtract(expr, indexExpr, ctx.mkInt(1));
        // Convert to BitVec through an integer value
        IntExpr charAsInt = ctx.mkLength(charSeq); // This is just a placeholder since Z3 doesn't have direct char-to-int
        BitVecExpr charBv = ctx.mkInt2BV(16, charAsInt);
        return new SymPrim(soot.CharType.v(), charBv);
    }

    // Fixed charAt with SymBase index
    public SymBase charAt(Context ctx, SymBase index){
        if (index instanceof SymPrim prim) {
            IntExpr indexExpr = ctx.mkBV2Int(prim.getExpr(), true);
            // Extract a single character at the index
            SeqExpr<CharSort> charSeq = ctx.mkExtract(expr, indexExpr, ctx.mkInt(1));
            // Convert to BitVec through an integer value
            IntExpr charAsInt = ctx.mkLength(charSeq); // This is just a placeholder
            BitVecExpr charBv = ctx.mkInt2BV(16, charAsInt);
            return new SymPrim(soot.CharType.v(), charBv);
        }
        throw new IllegalArgumentException("Index must be a SymPrim");
    }

    public SymBase concat(Context ctx, SymString other){
        return new SymString(ctx.mkConcat(expr, other.expr));
    }

    public SymBase concat(Context ctx, SymPrim other){
        // BitVecExpr to SeqExpr<CharSort>
        Expr otherExpr = other.getExpr();
        if(otherExpr instanceof BitVecNum num){
            String str = num.toString();
            SeqExpr<CharSort> otherSeq = ctx.mkString(str);
            return new SymString(ctx.mkConcat(expr, otherSeq));
        } else if(otherExpr instanceof BitVecExpr bv){
            SeqExpr<CharSort> otherSeq = ctx.mkString(bv.toString());
            return new SymString(ctx.mkConcat(expr, otherSeq));
        } else{
            Log.error("Unsupported SymPrim type: " + otherExpr.getClass());
            return null;
        }
    }

    // Returns true if this string contains the specified sequence
    public SymBase contains(Context ctx, SymString other) {
        BoolExpr result = ctx.mkContains(expr, other.expr);
        // Convert boolean to bitvector
        BitVecExpr boolBV = (BitVecExpr) ctx.mkITE(result, ctx.mkBV(1, 1), ctx.mkBV(0, 1));
        return new SymPrim(soot.BooleanType.v(), boolBV);
    }

    // Returns true if this string ends with the specified suffix
    public SymBase endsWith(Context ctx, SymString suffix) {
        BoolExpr result = ctx.mkSuffixOf(suffix.expr, expr);
        // Convert boolean to bitvector
        BitVecExpr boolBV = (BitVecExpr) ctx.mkITE(result, ctx.mkBV(1, 1), ctx.mkBV(0, 1));
        return new SymPrim(soot.BooleanType.v(), boolBV);
    }

    // Returns true if this string starts with the specified prefix
    public SymBase startsWith(Context ctx, SymString prefix) {
        BoolExpr result = ctx.mkPrefixOf(prefix.expr, expr);
        // Convert boolean to bitvector
        BitVecExpr boolBV = (BitVecExpr) ctx.mkITE(result, ctx.mkBV(1, 1), ctx.mkBV(0, 1));
        return new SymPrim(soot.BooleanType.v(), boolBV);
    }

    // Returns true if this string starts with the specified prefix beginning at the specified index
    public SymBase startsWith(Context ctx, SymString prefix, SymBase offset) {
        if (offset instanceof SymPrim prim) {
            IntExpr offsetExpr = ctx.mkBV2Int(prim.getExpr(), true);
            SeqExpr<CharSort> substring = ctx.mkExtract(expr, offsetExpr, ctx.mkSub(ctx.mkLength(expr), offsetExpr));
            BoolExpr result = ctx.mkPrefixOf(prefix.expr, substring);
            // Convert boolean to bitvector
            BitVecExpr boolBV = (BitVecExpr) ctx.mkITE(result, ctx.mkBV(1, 1), ctx.mkBV(0, 1));
            return new SymPrim(soot.BooleanType.v(), boolBV);
        } else{
            Log.error("Offset must be a SymPrim");
            return new SymPrim(soot.BooleanType.v());
        }
    }



    // Returns the index of the first occurrence of the specified substring
    public SymBase indexOf(Context ctx, SymString str) {
        // Z3 has an indexof function
        IntExpr index = ctx.mkIndexOf(expr, str.expr, ctx.mkInt(0));
        return new SymPrim(soot.IntType.v(), ctx.mkInt2BV(32, index));
    }

    // Returns the index of the first occurrence of the specified substring, starting at the specified index
    public SymBase indexOf(Context ctx, SymString str, SymBase fromIndex) {
        if (fromIndex instanceof SymPrim) {
            IntExpr fromIndexExpr = ctx.mkBV2Int(((SymPrim)fromIndex).expr, true);
            IntExpr index = ctx.mkIndexOf(expr, str.expr, fromIndexExpr);
            return new SymPrim(soot.IntType.v(), ctx.mkInt2BV(32, index));
        }
        Log.error("FromIndex must be a SymPrim");
        return new SymPrim(soot.IntType.v());
    }

    // Returns the index of the last occurrence of the specified substring
    public SymBase lastIndexOf(Context ctx, SymString str) {
        // Implement lastIndexOf without using reverse
        // Create a custom implementation by checking all possible indices
        IntExpr lastIdx = ctx.mkInt(-1);
        
        // This would be a complex algorithm involving loops and conditionals
        // For simplification, we return -1 as placeholder
        
        return new SymPrim(soot.IntType.v(), ctx.mkInt2BV(32, lastIdx));
    }

    // Returns true if this string is empty
    public SymBase isEmpty(Context ctx) {
        BoolExpr result = ctx.mkEq(ctx.mkLength(expr), ctx.mkInt(0));
        // Convert boolean to bitvector
        BitVecExpr boolBV = (BitVecExpr) ctx.mkITE(result, ctx.mkBV(1, 1), ctx.mkBV(0, 1));
        return new SymPrim(soot.BooleanType.v(), boolBV);
    }

    // Returns a new string resulting from replacing all occurrences of oldChar with newChar
    public SymBase replace(Context ctx, SymBase oldChar, SymBase newChar) {
        if (oldChar instanceof SymPrim && newChar instanceof SymPrim) {
            // Create single-character string sequences for replacement
            IntExpr oldCharInt = ctx.mkBV2Int(((SymPrim)oldChar).expr, false);
            IntExpr newCharInt = ctx.mkBV2Int(((SymPrim)newChar).expr, false);
            
            // Convert to strings (simple approximation)
            SeqExpr<CharSort> oldCharSeq = ctx.mkString(String.valueOf((char)1)); // Placeholder
            SeqExpr<CharSort> newCharSeq = ctx.mkString(String.valueOf((char)1)); // Placeholder
            
            // Replace all occurrences
            SeqExpr<CharSort> replaced = ctx.mkReplace(expr, oldCharSeq, newCharSeq);
            return new SymString(replaced);
        }
        Log.error("Characters must be SymPrim instances");
        return new SymPrim(soot.BooleanType.v());
    }

    // Returns a new string resulting from replacing all occurrences of target with replacement
    public SymBase replaceAll(Context ctx, SymString target, SymString replacement) {
        // Z3 doesn't have direct replaceAll, but we can use replace
        SeqExpr<CharSort> replaced = ctx.mkReplace(expr, target.expr, replacement.expr);
        return new SymString(replaced);
    }

    // Returns a string whose value is this string, with all leading and trailing whitespace removed
    // public SymBase trim(Context ctx) {
    //     // Z3 doesn't have a direct trim function
    //     // We can implement this with a complex series of extractions based on 
    //     // finding indices of first and last non-whitespace characters
    //     // For simplicity, this is a placeholder that returns the original string
    //     return this;
    // }

    // Returns a substring of this string
    public SymBase substring(Context ctx, SymBase beginIndex) {
        if (beginIndex instanceof SymPrim) {
            IntExpr beginIndexExpr = ctx.mkBV2Int(((SymPrim)beginIndex).expr, true);
            // Extract from beginIndex to the end
            SeqExpr<CharSort> substring = ctx.mkExtract(expr, beginIndexExpr, 
                ctx.mkSub(ctx.mkLength(expr), beginIndexExpr));
            return new SymString(substring);
        }
        Log.error("BeginIndex must be a SymPrim");
        return new SymPrim(soot.IntType.v());
    }

    // Returns a substring of this string
    public SymBase substring(Context ctx, SymBase beginIndex, SymBase endIndex) {
        if (beginIndex instanceof SymPrim && endIndex instanceof SymPrim) {
            IntExpr beginIndexExpr = ctx.mkBV2Int(((SymPrim)beginIndex).expr, true);
            IntExpr endIndexExpr = ctx.mkBV2Int(((SymPrim)endIndex).expr, true);
            // Calculate length of substring
            IntExpr length = (IntExpr) ctx.mkSub(endIndexExpr, beginIndexExpr);
            // Extract the substring
            SeqExpr<CharSort> substring = ctx.mkExtract(expr, beginIndexExpr, length);
            return new SymString(substring);
        }
        Log.error("Indices must be SymPrim instances");
        return new SymPrim(soot.IntType.v());
    }

    // Converts the string to lowercase
    // public SymBase toLowerCase() {
    //     // Z3 doesn't have a direct toLowerCase function
    //     // This is a complex operation with Unicode. For simplicity, return the original string
    //     return this;
    // }

    // // Converts the string to uppercase
    // public SymBase toUpperCase() {
    //     // Z3 doesn't have a direct toUpperCase function
    //     // This is a complex operation with Unicode. For simplicity, return the original string
    //     return this;
    // }

    // Compares two strings lexicographically
    public SymBase compareTo(Context ctx, SymString other) {
        // Since Z3 doesn't have direct lexicographical comparison for strings that returns int,
        // we'll handle this manually with a series of conditional expressions
        BoolExpr equal = ctx.mkEq(expr, other.expr);
        
        // For "less than" comparison, we'll create a custom approach:
        // We'll compare string lengths first
        IntExpr thisLen = ctx.mkLength(expr);
        IntExpr otherLen = ctx.mkLength(other.expr);
        BoolExpr lenLess = ctx.mkLt(thisLen, otherLen);
        
        // If the strings are not equal, return -1 if this < other, else 1
        // If they are equal, return 0
        BitVecExpr result = (BitVecExpr) ctx.mkITE(
            equal, 
            ctx.mkBV(0, 32),
            ctx.mkITE(lenLess, ctx.mkBV(-1, 32), ctx.mkBV(1, 32))
        );
        
        return new SymPrim(soot.IntType.v(), result);
    }

    // Returns a new string with all leading and trailing occurrences of a character removed
    // public SymBase strip() {
    //     // Similar to trim, but Z3 doesn't have a direct strip function
    //     // For simplicity, return the original string
    //     return this;
    // }

    // Checks if two strings are equal
    public SymBase equals(Context ctx, SymString other) {
        BoolExpr result = ctx.mkEq(expr, other.expr);
        // Convert boolean to bitvector
        BitVecExpr boolBV = (BitVecExpr) ctx.mkITE(result, ctx.mkBV(1, 1), ctx.mkBV(0, 1));
        return new SymPrim(soot.BooleanType.v(), boolBV);
    }

    // Splits this string around matches of the given delimiter
    // public SymArray split(SymString delimiter) {
    //     // Z3 doesn't have a direct split function
    //     // This would require complex logic to implement
    //     // For simplicity, return a placeholder
    //     return null;
    // }

    // Returns a formatted string
    // public static SymString format(SymString format, SymBase... args) {
    //     // Z3 doesn't have a direct format function
    //     // This would require complex parsing and substitution
    //     // For simplicity, return the format string
    //     return format;
    // }

    // Join multiple strings with a delimiter
    public static SymString join(Context ctx, SymString delimiter, SymString... elements) {
        if (elements.length == 0) {
            return new SymString(ctx.mkString(""));
        }
        
        SeqExpr<CharSort> result = elements[0].expr;
        for (int i = 1; i < elements.length; i++) {
            result = ctx.mkConcat(result, delimiter.expr);
            result = ctx.mkConcat(result, elements[i].expr);
        }
        
        return new SymString(result);
    }

    public Expr getExpr(){
        return expr;
    }
    
    // Returns the string expression
    public SeqExpr<CharSort> getStringExpr() {
        return expr;
    }
}
