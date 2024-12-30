import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2014Tests {
    private final Solution2014 solution2014 = new Solution2014();

    @Test
    public void example1() {
        String s = "letsleetcode";
        int k = 2;
        String expected = "let";
        Assertions.assertEquals(expected, solution2014.longestSubsequenceRepeatedK(s, k));
    }

    @Test
    public void example2() {
        String s = "bb";
        int k = 2;
        String expected = "b";
        Assertions.assertEquals(expected, solution2014.longestSubsequenceRepeatedK(s, k));
    }

    @Test
    public void example3() {
        String s = "ab";
        int k = 2;
        String expected = "";
        Assertions.assertEquals(expected, solution2014.longestSubsequenceRepeatedK(s, k));
    }
}