package Engine;



import com.microsoft.z3.*;

import soot.*;

import com.microsoft.z3.Context;

/**
 * Symbolic representation of a Java List using Z3 arrays
 */
public class SymList2 {
    private static final int INDEX_BV_SIZE = 32;  // Size of index bitvectors
    
    /**
     * Creates a new symbolic list
     * 
     * @param ctx Z3 context
     * @param elementType Soot type of list elements
     * @param name Base name for Z3 symbols
     * @return Array expression for the list
     */
    public static ArrayExpr createList(Context ctx, Type elementType, String name) {
        int elementWidth = TypeUtils.getTypeWidth(elementType);
        BitVecSort indexSort = ctx.mkBitVecSort(INDEX_BV_SIZE);
        BitVecSort elementSort = ctx.mkBitVecSort(elementWidth);
        // Create array for storing elements
        return ctx.mkArrayConst(name + "_array", indexSort, elementSort);
    }
    
    /**
     * Creates size expression with initial value 0
     * 
     * @param ctx Z3 context
     * @return BitVecExpr representing size=0
     */
    public static BitVecExpr createSize(Context ctx) {
        return ctx.mkBV(0, INDEX_BV_SIZE);
    }
    
    /**
     * Adds an element to the end of the list
     * 
     * @param ctx Z3 context
     * @param array Z3 array representing the list
     * @param size Z3 expression for current list size
     * @param elementType Soot type of list elements
     * @param element Z3 expression for the element to add
     * @return Updated array
     */
    public static ArrayExpr add(Context ctx, ArrayExpr array, BitVecExpr size, Type elementType, Expr element) {
        // Convert element to correct bit vector width if needed
        BitVecExpr elementBV;
        if (element instanceof BitVecExpr) {
            elementBV = (BitVecExpr) Expression.makeCastExpr(ctx, elementType, element);
        } else if (element instanceof BoolExpr) {
            elementBV = ctx.mkBV(element.isTrue() ? 1 : 0, TypeUtils.getTypeWidth(elementType));
        } else {
            throw new IllegalArgumentException("Unsupported expression type: " + element.getClass());
        }
        
        // Store element at current size index
        return ctx.mkStore(array, size, elementBV);
    }
    
    /**
     * Increments the size after adding an element
     * 
     * @param ctx Z3 context
     * @param size Current size expression
     * @return Incremented size expression
     */
    public static BitVecExpr incrementSize(Context ctx, BitVecExpr size) {
        return ctx.mkBVAdd(size, ctx.mkBV(1, INDEX_BV_SIZE));
    }
    
    /**
     * Gets the element at the specified index
     * 
     * @param ctx Z3 context
     * @param array Z3 array representing the list
     * @param index Z3 expression for the index
     * @return Z3 expression for the element at the index
     */
    public static BitVecExpr get(Context ctx, ArrayExpr array, BitVecExpr index) {
        return (BitVecExpr) ctx.mkSelect(array, index);
    }
    
    /**
     * Gets the element at the specified index
     * 
     * @param ctx Z3 context
     * @param array Z3 array representing the list
     * @param index Integer index
     * @return Z3 expression for the element at the index
     */
    public static BitVecExpr get(Context ctx, ArrayExpr array, int index) {
        return get(ctx, array, ctx.mkBV(index, INDEX_BV_SIZE));
    }
    
    /**
     * Sets the element at the specified index
     * 
     * @param ctx Z3 context
     * @param array Z3 array representing the list
     * @param index Z3 expression for the index
     * @param elementType Soot type of list elements
     * @param element Z3 expression for the new element
     * @return Updated array
     */
    public static ArrayExpr set(Context ctx, ArrayExpr array, BitVecExpr index, Type elementType, Expr element) {
        // Convert element to correct bit vector width if needed
        BitVecExpr elementBV;
        if (element instanceof BitVecExpr) {
            elementBV = (BitVecExpr) Expression.makeCastExpr(ctx, elementType, element);
        } else if (element instanceof BoolExpr) {
            elementBV = ctx.mkBV(element.isTrue() ? 1 : 0, TypeUtils.getTypeWidth(elementType));
        } else {
            throw new IllegalArgumentException("Unsupported expression type: " + element.getClass());
        }
        
        // Store element at index
        return ctx.mkStore(array, index, elementBV);
    }
    
    /**
     * Sets the element at the specified index
     * 
     * @param ctx Z3 context
     * @param array Z3 array representing the list
     * @param index Integer index
     * @param elementType Soot type of list elements
     * @param element Z3 expression for the new element
     * @return Updated array
     */
    public static ArrayExpr set(Context ctx, ArrayExpr array, int index, Type elementType, Expr element) {
        return set(ctx, array, ctx.mkBV(index, INDEX_BV_SIZE), elementType, element);
    }
    
    /**
     * Removes an element at the specified index
     * 
     * @param ctx Z3 context
     * @param array Z3 array representing the list
     * @param size Z3 expression for current list size
     * @param index Z3 expression for the index
     * @param maxSize Maximum size to consider for shifting
     * @return Updated array after removal
     */
    public static ArrayExpr remove(Context ctx, ArrayExpr array, BitVecExpr size, BitVecExpr index, int maxSize) {
        // Create bounds check: 0 <= index < size
        BoolExpr validIndex = ctx.mkAnd(
            ctx.mkBVULE(ctx.mkBV(0, INDEX_BV_SIZE), index),
            ctx.mkBVULT(index, size)
        );
        
        // Create the shifted array by copying elements
        ArrayExpr shiftedArray = array;
        
        // Create an assertion that for all valid positions, if i >= index && i < size-1,
        // then shiftedArray[i] = array[i+1]
        BitVecExpr sizeMinusOne = ctx.mkBVSub(size, ctx.mkBV(1, INDEX_BV_SIZE));
        
        // Iterate through remaining elements and shift them
        for (int idx = 0; idx < maxSize - 1; idx++) {
            BitVecExpr idxExpr = ctx.mkBV(idx, INDEX_BV_SIZE);
            BitVecExpr nextIdxExpr = ctx.mkBV(idx + 1, INDEX_BV_SIZE);
            
            // Condition: idxExpr >= index && idxExpr < size-1
            BoolExpr shouldShift = ctx.mkAnd(
                ctx.mkBVUGE(idxExpr, index),
                ctx.mkBVULT(idxExpr, sizeMinusOne)
            );
            
            // If shouldShift, new_array[idxExpr] = old_array[idxExpr + 1]
            BitVecExpr valueToAssign = (BitVecExpr) ctx.mkITE(
                shouldShift,
                ctx.mkSelect(array, nextIdxExpr),
                ctx.mkSelect(shiftedArray, idxExpr)
            );
            
            shiftedArray = ctx.mkStore(shiftedArray, idxExpr, valueToAssign);
        }
        
        // Update the array only if index is valid
        return (ArrayExpr) ctx.mkITE(validIndex, shiftedArray, array);
    }
    
    /**
     * Decrements size after removing an element
     * 
     * @param ctx Z3 context
     * @param size Current size expression
     * @param index Removal index
     * @return Updated size after removal
     */
    public static BitVecExpr decrementSize(Context ctx, BitVecExpr size, BitVecExpr index) {
        // Create bounds check: 0 <= index < size
        BoolExpr validIndex = ctx.mkAnd(
            ctx.mkBVULE(ctx.mkBV(0, INDEX_BV_SIZE), index),
            ctx.mkBVULT(index, size)
        );
        
        return (BitVecExpr) ctx.mkITE(validIndex, 
                ctx.mkBVSub(size, ctx.mkBV(1, INDEX_BV_SIZE)), 
                size);
    }
    
    /**
     * Removes an element at the specified index
     * 
     * @param ctx Z3 context
     * @param array Z3 array representing the list
     * @param size Z3 expression for current list size
     * @param index Integer index
     * @param maxSize Maximum size to consider for shifting
     * @return Updated array after removal
     */
    public static ArrayExpr remove(Context ctx, ArrayExpr array, BitVecExpr size, int index, int maxSize) {
        return remove(ctx, array, size, ctx.mkBV(index, INDEX_BV_SIZE), maxSize);
    }
    
    /**
     * Checks if the list is empty
     * 
     * @param ctx Z3 context
     * @param size Z3 expression for current list size
     * @return Z3 boolean expression indicating if the list is empty
     */
    public static BoolExpr isEmpty(Context ctx, BitVecExpr size) {
        return ctx.mkEq(size, ctx.mkBV(0, INDEX_BV_SIZE));
    }
    
    /**
     * Checks if the list contains the specified element
     * 
     * @param ctx Z3 context
     * @param array Z3 array representing the list
     * @param size Z3 expression for current list size
     * @param elementType Soot type of list elements
     * @param element Z3 expression for the element to find
     * @param maxSize Maximum size to check
     * @return Z3 boolean expression indicating if the element is in the list
     */
    public static BoolExpr contains(Context ctx, ArrayExpr array, BitVecExpr size, Type elementType, Expr element, int maxSize) {
        // Convert element to correct bit vector width if needed
        BitVecExpr elementBV;
        if (element instanceof BitVecExpr) {
            elementBV = (BitVecExpr) Expression.makeCastExpr(ctx, elementType, element);
        } else if (element instanceof BoolExpr) {
            elementBV = ctx.mkBV(element.isTrue() ? 1 : 0, TypeUtils.getTypeWidth(elementType));
        } else {
            throw new IllegalArgumentException("Unsupported expression type: " + element.getClass());
        }
        
        // Check each position in the list
        BoolExpr result = ctx.mkFalse();
        
        for (int i = 0; i < maxSize; i++) {
            BitVecExpr index = ctx.mkBV(i, INDEX_BV_SIZE);
            
            // Check if i < size && array[i] == element
            BoolExpr indexInBounds = ctx.mkBVULT(index, size);
            BoolExpr valueMatches = ctx.mkEq(ctx.mkSelect(array, index), elementBV);
            
            // Update result: result = result || (indexInBounds && valueMatches)
            result = ctx.mkOr(
                result,
                ctx.mkAnd(indexInBounds, valueMatches)
            );
        }
        
        return result;
    }
    
    /**
     * Creates a sublist from a list
     * 
     * @param ctx Z3 context
     * @param array Z3 array representing the list
     * @param elementType Soot type of list elements
     * @param fromIndex starting index (inclusive)
     * @param toIndex ending index (exclusive)
     * @param maxSize Maximum size to copy
     * @return Array expression for the sublist
     */
    public static ArrayExpr createSubList(Context ctx, ArrayExpr array, Type elementType, 
                                int fromIndex, int toIndex, int maxSize) {
        BitVecExpr fromIdxExpr = ctx.mkBV(fromIndex, INDEX_BV_SIZE);
        BitVecExpr toIdxExpr = ctx.mkBV(toIndex, INDEX_BV_SIZE);
        return createSubList(ctx, array, elementType, fromIdxExpr, toIdxExpr, maxSize);
    }
    
    /**
     * Gets the size of a sublist
     * 
     * @param ctx Z3 context
     * @param fromIndex starting index
     * @param toIndex ending index
     * @return Size expression for the sublist
     */
    public static BitVecExpr getSubListSize(Context ctx, BitVecExpr fromIndex, BitVecExpr toIndex) {
        return ctx.mkBVSub(toIndex, fromIndex);
    }
    
    /**
     * Creates a sublist from a list
     * 
     * @param ctx Z3 context
     * @param array Z3 array representing the list
     * @param elementType Soot type of list elements
     * @param fromIndex starting index expr (inclusive)
     * @param toIndex ending index expr (exclusive)
     * @param maxSize Maximum size to copy
     * @return Array expression for the sublist
     */
    public static ArrayExpr createSubList(Context ctx, ArrayExpr array, Type elementType, 
                                BitVecExpr fromIndex, BitVecExpr toIndex, int maxSize) {
        // Calculate length of sublist
        BitVecExpr subListLength = ctx.mkBVSub(toIndex, fromIndex);
        
        // Create new array for the sublist
        String newName = "sublist_" + System.identityHashCode(array);
        ArrayExpr sublistArray = createList(ctx, elementType, newName);
        
        // Copy elements from this list to sublist
        for (int i = 0; i < maxSize; i++) {
            BitVecExpr iExpr = ctx.mkBV(i, INDEX_BV_SIZE);
            
            // Check if i < subListLength
            BoolExpr isValidIndex = ctx.mkBVULT(iExpr, subListLength);
            
            // Calculate source index
            BitVecExpr sourceIdx = ctx.mkBVAdd(fromIndex, iExpr);
            
            // Get element from source list
            BitVecExpr element = get(ctx, array, sourceIdx);
            
            // If valid index, store element in sublist
            ArrayExpr updatedArray = ctx.mkStore(sublistArray, iExpr, element);
            
            // Update sublist array only if index is valid
            sublistArray = (ArrayExpr) ctx.mkITE(isValidIndex, updatedArray, sublistArray);
        }
        
        return sublistArray;
    }
    
    /**
     * Tests if two lists have the same elements
     * 
     * @param ctx Z3 context
     * @param array1 Z3 array representing the first list
     * @param size1 Z3 expression for first list size
     * @param array2 Z3 array representing the second list
     * @param size2 Z3 expression for second list size
     * @param maxSize Maximum size to compare
     * @return Z3 boolean expression indicating if the lists are equal
     */
    public static BoolExpr equals(Context ctx, ArrayExpr array1, BitVecExpr size1, 
                                  ArrayExpr array2, BitVecExpr size2, int maxSize) {
        // First check if sizes are the same
        BoolExpr sameSizes = ctx.mkEq(size1, size2);
        
        // Then check if all elements are the same
        BoolExpr allElementsEqual = ctx.mkTrue();
        
        // For each position, if i < size, check that this.array[i] == other.array[i]
        for (int i = 0; i < maxSize; i++) {
            BitVecExpr iExpr = ctx.mkBV(i, INDEX_BV_SIZE);
            
            // Only compare elements within the size bounds
            BoolExpr indexInBounds = ctx.mkBVULT(iExpr, size1);
            
            // Check if elements at index i are equal
            BoolExpr elementsEqual = ctx.mkEq(
                ctx.mkSelect(array1, iExpr),
                ctx.mkSelect(array2, iExpr)
            );
            
            // Update allElementsEqual: allElementsEqual && (!indexInBounds || elementsEqual)
            allElementsEqual = ctx.mkAnd(
                allElementsEqual,
                ctx.mkImplies(indexInBounds, elementsEqual)
            );
        }
        
        // Lists are equal if sizes are equal and all elements are equal
        return ctx.mkAnd(sameSizes, allElementsEqual);
    }
}