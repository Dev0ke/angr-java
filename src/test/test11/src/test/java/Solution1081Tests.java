import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1081Tests {
    private final Solution1081 solution1081 = new Solution1081();

    @Test
    public void example1() {
        String s = "bcabc";
        String expected = "abc";
        Assertions.assertEquals(expected, solution1081.smallestSubsequence(s));
    }

    @Test
    public void example2() {
        String s = "cbacdcbc";
        String expected = "acdb";
        Assertions.assertEquals(expected, solution1081.smallestSubsequence(s));
    }
}
