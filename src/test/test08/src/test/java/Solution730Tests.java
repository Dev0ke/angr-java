import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution730Tests {
    private final Solution730 solution730 = new Solution730();

    @Test
    public void example1() {
        String s = "bccb";
        int expected = 6;
        Assertions.assertEquals(expected, solution730.countPalindromicSubsequences(s));
    }

    @Test
    public void example2() {
        String s = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba";
        int expected = 104860361;
        Assertions.assertEquals(expected, solution730.countPalindromicSubsequences(s));
    }
}