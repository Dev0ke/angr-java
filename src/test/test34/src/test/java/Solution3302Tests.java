import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3302Tests {
    private final Solution3302 solution3302 = new Solution3302();

    @Test
    public void example1() {
        String word1 = "vbcca";
        String word2 = "abc";
        int[] expected = {0, 1, 2};
        Assertions.assertArrayEquals(expected, solution3302.validSequence(word1, word2));
    }

    @Test
    public void example2() {
        String word1 = "bacdc";
        String word2 = "abc";
        int[] expected = {1, 2, 4};
        Assertions.assertArrayEquals(expected, solution3302.validSequence(word1, word2));
    }

    @Test
    public void example3() {
        String word1 = "aaaaaa";
        String word2 = "aaabc";
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution3302.validSequence(word1, word2));
    }

    @Test
    public void example4() {
        String word1 = "abc";
        String word2 = "ab";
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution3302.validSequence(word1, word2));
    }
}