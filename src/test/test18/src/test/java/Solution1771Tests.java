import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1771Tests {
    private final Solution1771 solution1771 = new Solution1771();

    @Test
    public void example1() {
        String word1 = "cacb";
        String word2 = "cbba";
        int expected = 5;
        Assertions.assertEquals(expected, solution1771.longestPalindrome(word1, word2));
    }

    @Test
    public void example2() {
        String word1 = "ab";
        String word2 = "ab";
        int expected = 3;
        Assertions.assertEquals(expected, solution1771.longestPalindrome(word1, word2));
    }

    @Test
    public void example3() {
        String word1 = "aa";
        String word2 = "bb";
        int expected = 0;
        Assertions.assertEquals(expected, solution1771.longestPalindrome(word1, word2));
    }
}