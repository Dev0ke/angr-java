import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2825Tests {
    private final Solution2825 solution2825 = new Solution2825();

    @Test
    public void example1() {
        String str1 = "abc";
        String str2 = "ad";
        Assertions.assertTrue(solution2825.canMakeSubsequence(str1, str2));
    }

    @Test
    public void example2() {
        String str1 = "zc";
        String str2 = "ad";
        Assertions.assertTrue(solution2825.canMakeSubsequence(str1, str2));
    }

    @Test
    public void example3() {
        String str1 = "ab";
        String str2 = "d";
        Assertions.assertFalse(solution2825.canMakeSubsequence(str1, str2));
    }
}