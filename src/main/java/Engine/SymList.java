package Engine;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.microsoft.z3.*;
import soot.*;
import soot.jimple.ArrayRef;
import soot.jimple.*;
import soot.jimple.internal.*;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;

import solver.SymbolSolver;
import utils.Log;
/**
 * Symbolic representation of a Java List using Z3 arrays
 */
public class SymList extends SymBase {
    private static final int INDEX_BV_SIZE = 32;  // Size of index bitvectors
    private static final String STRING_TYPE = "java.lang.String";
    private static final String CHAR_SEQUENCE_TYPE = "java.lang.CharSequence";
    public ArrayList<SymBase> list;

    /**
     * Create an empty list
     */
    public SymList() {
        super();
        this.list = new ArrayList<>();
        this.isNull = false;
    }

    /**
     * Create a list with an initial size
     * @param size initial size of the list
     */
    public SymList(int size) {
        super();
        this.list = new ArrayList<>(size);
        this.isNull = false;
    }

    /**
     * Create a list with a specific type
     * @param type the type of elements in the list
     */
    public SymList(Type type) {
        super(type);
        this.list = new ArrayList<>();
        this.isNull = false;
    }

    /**
     * Create a list with a specific type and name
     * @param type the type of elements in the list
     * @param name the name of the list
     */
    public SymList(Type type, String name) {
        super(type, name);
        this.list = new ArrayList<>();
        this.isNull = false;
    }

    public SymBase lengthof(Context ctx){
        Expr v =  ctx.mkBV(list.size(), INDEX_BV_SIZE);
        // return int 
        return new SymPrim(soot.IntType.v(), v);
    }

    /**
     * Returns the size of the list
     * @param ctx Z3 context
     * @return BitVecExpr representing the size
     */
    public BitVecExpr size(Context ctx) {
        return ctx.mkBV(list.size(), INDEX_BV_SIZE);
    }

    /**
     * Add an element to the list
     * @param element element to add
     * @return true if successful
     */
    public boolean add(SymBase element) {
        return list.add(element);
    }

    /**
     * Get element at specified index
     * @param index the index
     * @return the element at the index
     */
    public SymBase get(int index) {
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }

    public SymBase get(Context ctx, SymBase index, SimState state) {
        if (index == null) {
            return null;
        }
        Expr indexExpr = index.getExpr();
        if(indexExpr instanceof BitVecNum bitVecNum){
            int indexValue = bitVecNum.getInt();
            return list.get(indexValue);
        } else if(indexExpr instanceof BitVecExpr bitVecExpr){
            //solve the value of the index
            List<Expr> constraints = new ArrayList<>();
            int indexValue = SymbolSolver.getBitVecIntValue(ctx, bitVecExpr, constraints);
            if(indexValue == -1){
                Log.error("Failed to solve the value of the index: " + bitVecExpr.toString());
                return null;
            } else if(indexValue < list.size())
                return list.get(indexValue);
            else{
                return SymGen.makeSymbol(ctx, type, String.format("%s[%d]", name, indexValue));
            }
            
        } else{
            Log.error("Unsupported index type: " + indexExpr.getClass());
        } 
        return null;
    }

    /**
     * Set element at specified index
     * @param index the index
     * @param element element to set
     * @return previous element at this position
     */
    public SymBase set(int index, SymBase element) {
        if (index < 0 || index >= list.size()) {
            // If list is not large enough, pad with nulls
            while (list.size() <= index) {
                list.add(null);
            }
        }
        return list.set(index, element);
    }

    /**
     * Remove element at specified index
     * @param index the index to remove
     * @return the removed element
     */
    public SymBase remove(int index) {
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.remove(index);
    }

    /**
     * Remove a specific element from the list
     * @param element the element to remove
     * @return true if removed
     */
    public boolean remove(SymBase element) {
        return list.remove(element);
    }

    /**
     * Check if list contains the element
     * @param element the element to check
     * @return true if contained
     */
    public boolean contains(SymBase element) {
        return list.contains(element);
    }

    /**
     * Check if list contains the element
     * @param ctx Z3 context
     * @param element the element to check
     * @return BoolExpr representing if contained
     */
    public BoolExpr contains(Context ctx, Expr element) {
        BoolExpr result = ctx.mkFalse();
        
        for (SymBase item : list) {
            if (item != null && item.expr != null) {
                BoolExpr equals = ctx.mkEq(item.expr, element);
                result = ctx.mkOr(result, equals);
            }
        }
        
        return result;
    }

    /**
     * Clear the list
     */
    public void clear() {
        list.clear();
    }

    /**
     * Check if list is empty
     * @return true if empty
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Get a sublist from this list
     * @param fromIndex start index (inclusive)
     * @param toIndex end index (exclusive)
     * @return a new SymList containing the sublist
     */
    public SymList subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > list.size() || fromIndex > toIndex) {
            return null;
        }
        
        SymList result = new SymList(this.type, this.name + "_sub");
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(list.get(i));
        }
        
        return result;
    }

    /**
     * Creates a symbolic equality check between this list and another
     * @param ctx Z3 context
     * @param other the other list to compare with
     * @return BoolExpr representing the equality
     */
    public BoolExpr equals(Context ctx, SymList other) {
        if (other == null) {
            return ctx.mkFalse();
        }
        
        // First check sizes are equal
        BoolExpr sizeEqual = ctx.mkEq(size(ctx), other.size(ctx));
        
        // If sizes aren't equal, lists aren't equal
        if (list.size() != other.list.size()) {
            return ctx.mkFalse();
        }
        
        // Check all elements are equal
        BoolExpr allEqual = ctx.mkTrue();
        for (int i = 0; i < list.size(); i++) {
            SymBase thisElem = list.get(i);
            SymBase otherElem = other.list.get(i);
            
            if (thisElem == null || otherElem == null) {
                if (thisElem != otherElem) {
                    return ctx.mkFalse();
                }
            } else if (thisElem.expr != null && otherElem.expr != null) {
                BoolExpr elemEqual = ctx.mkEq(thisElem.expr, otherElem.expr);
                allEqual = ctx.mkAnd(allEqual, elemEqual);
            }
        }
        
        return ctx.mkAnd(sizeEqual, allEqual);
    }

    /**
     * Get the index of an element
     * @param element the element to find
     * @return the index or -1 if not found
     */
    public int indexOf(SymBase element) {
        return list.indexOf(element);
    }

    /**
     * Get the last index of an element
     * @param element the element to find
     * @return the last index or -1 if not found
     */
    public int lastIndexOf(SymBase element) {
        return list.lastIndexOf(element);
    }

    /**
     * Add an element at a specific index
     * @param index the index to add at
     * @param element the element to add
     */
    public void add(int index, SymBase element) {
        if (index < 0) {
            return;
        }
        
        // If list is not large enough, pad with nulls
        while (list.size() < index) {
            list.add(null);
        }
        
        list.add(index, element);
    }

    /**
     * Convert the list to a Java array
     * @return array of SymBase elements
     */
    public SymBase[] toArray() {
        return list.toArray(new SymBase[0]);
    }

    /**
     * Get the number of elements in the list
     * @return number of elements
     */
    public int size() {
        return list.size();
    }

    @Override
    public Expr getExpr() {
        return expr;
    }
}