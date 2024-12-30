import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1876Tests {
    private final Solution1876 solution1876 = new Solution1876();

    @Test
    public void example1() {
        String s = "xyzzaz";
        int expected = 1;
        Assertions.assertEquals(expected, solution1876.countGoodSubstrings(s));
    }

    @Test
    public void example2() {
        String s = "aababcabc";
        int expected = 4;
        Assertions.assertEquals(expected, solution1876.countGoodSubstrings(s));
    }
}