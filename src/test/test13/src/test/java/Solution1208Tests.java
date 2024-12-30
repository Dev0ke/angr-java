import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1208Tests {
    private final Solution1208 solution1208 = new Solution1208();

    @Test
    public void example1() {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1208.equalSubstring(s, t, maxCost));
    }

    @Test
    public void example2() {
        String s = "abcd";
        String t = "cdef";
        int maxCost = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution1208.equalSubstring(s, t, maxCost));
    }

    @Test
    public void example3() {
        String s = "abcd";
        String t = "acde";
        int maxCost = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution1208.equalSubstring(s, t, maxCost));
    }
}