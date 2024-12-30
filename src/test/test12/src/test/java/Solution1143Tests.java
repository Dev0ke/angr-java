import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1143Tests {
    private final Solution1143 solution1143 = new Solution1143();

    @Test
    public void example1() {
        String text1 = "abcde";
        String text2 = "ace";
        int expected = 3;
        Assertions.assertEquals(expected, solution1143.longestCommonSubsequence(text1, text2));
    }

    @Test
    public void example2() {
        String text1 = "abc";
        String text2 = "abc";
        int expected = 3;
        Assertions.assertEquals(expected, solution1143.longestCommonSubsequence(text1, text2));
    }

    @Test
    public void example3() {
        String text1 = "abc";
        String text2 = "def";
        int expected = 0;
        Assertions.assertEquals(expected, solution1143.longestCommonSubsequence(text1, text2));
    }
}
