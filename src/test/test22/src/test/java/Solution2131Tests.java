import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2131Tests {
    private final Solution2131 solution2131 = new Solution2131();

    @Test
    public void example1() {
        String[] words = {"lc", "cl", "gg"};
        int expected = 6;
        Assertions.assertEquals(expected, solution2131.longestPalindrome(words));
    }

    @Test
    public void example2() {
        String[] words = {"ab", "ty", "yt", "lc", "cl", "ab"};
        int expected = 8;
        Assertions.assertEquals(expected, solution2131.longestPalindrome(words));
    }

    @Test
    public void example3() {
        String[] words = {"cc", "ll", "xx"};
        int expected = 2;
        Assertions.assertEquals(expected, solution2131.longestPalindrome(words));
    }

    // 补充用例
    @Test
    public void example4() {
        String[] words = {"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"};
        int expected = 22;
        Assertions.assertEquals(expected, solution2131.longestPalindrome(words));
    }
}
