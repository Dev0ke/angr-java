import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1930Tests {
    private final Solution1930 solution1930 = new Solution1930();

    @Test
    public void example1() {
        String s = "aabca";
        int expected = 3;
        Assertions.assertEquals(expected, solution1930.countPalindromicSubsequence(s));
    }

    @Test
    public void example2() {
        String s = "adc";
        int expected = 0;
        Assertions.assertEquals(expected, solution1930.countPalindromicSubsequence(s));
    }

    @Test
    public void example3() {
        String s = "bbcbaba";
        int expected = 4;
        Assertions.assertEquals(expected, solution1930.countPalindromicSubsequence(s));
    }
}
