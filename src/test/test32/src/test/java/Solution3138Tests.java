import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3138Tests {
    private final Solution3138 solution3138 = new Solution3138();

    @Test
    public void example1() {
        String s = "abba";
        int expected = 2;
        Assertions.assertEquals(expected, solution3138.minAnagramLength(s));
    }

    @Test
    public void example2() {
        String s = "cdef";
        int expected = 4;
        Assertions.assertEquals(expected, solution3138.minAnagramLength(s));
    }
}