package Engine;

import soot.*;
import soot.dava.internal.javaRep.DIntConstant;
import soot.jimple.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TypeUtils {


    private static final Set<String> StringClass = Set.of(
        "java.lang.String",
        "java.lang.CharSequence",
        "java.lang.StringBuilder",
        "java.lang.StringBuffer"
    );




    // Cache for type width to avoid repeated calculations
    private static final Map<Type, Integer> TYPE_WIDTH_CACHE = new HashMap<>();

    // Cache for signed type checks
    private static final Map<Type, Boolean> SIGNED_TYPE_CACHE = new HashMap<>();
        
    public static boolean isPrimType(Type type) {
        return type instanceof PrimType;
    }
    public static boolean isStringType(String className){
        return StringClass.contains(className);
    }

    public static boolean isStringType(RefType refType){
        return StringClass.contains(refType.getClassName());
    }


    public static boolean isSignedType(Type type) {
        if (type == null) {
            return false;
        }
        
        // Use cache for repeated type checks
        Boolean cached = SIGNED_TYPE_CACHE.get(type);
        if (cached != null) {
            return cached;
        }
        
        boolean result = type instanceof ByteType || 
                         type instanceof ShortType || 
                         type instanceof IntType || 
                         type instanceof LongType || 
                         type instanceof DoubleType || 
                         type instanceof FloatType;
        
        // Cache the result
        SIGNED_TYPE_CACHE.put(type, result);
        return result;
    }

    public static int getTypeWidth(PrimType type) {
        return getTypeWidth((Type)type);
    }

    public static int getTypeWidth(Type type) {
        if (type == null) {
            throw new RuntimeException("Type cannot be null");
        }
        
        // Check cache first
        Integer cachedWidth = TYPE_WIDTH_CACHE.get(type);
        if (cachedWidth != null) {
            return cachedWidth;
        }
        
        int width;
        
        // Use pattern matching for more efficient type checking
        if (type instanceof ByteType || type instanceof UByteType) {
            width = 8;
        } else if (type instanceof ShortType || type instanceof UShortType || type instanceof CharType) {
            width = 16;
        } else if (type instanceof IntType || type instanceof UIntType || type instanceof FloatType) {
            width = 32;
        } else if (type instanceof LongType || type instanceof ULongType || type instanceof DoubleType) {
            width = 64;
        } else if (type instanceof BooleanType) {
            width = 1;
        } else {
            throw new RuntimeException("Unsupported type for width calculation: " + type);
        }
        
        // Cache the result
        TYPE_WIDTH_CACHE.put(type, width);
        return width;
    }
}
