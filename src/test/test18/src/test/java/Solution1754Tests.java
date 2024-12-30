import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1754Tests {
    private final Solution1754 solution1754 = new Solution1754();

    @Test
    public void example1() {
        String word1 = "cabaa";
        String word2 = "bcaaa";
        String expected = "cbcabaaaaa";
        Assertions.assertEquals(expected, solution1754.largestMerge(word1, word2));
    }

    @Test
    public void example2() {
        String word1 = "abcabc";
        String word2 = "abdcaba";
        String expected = "abdcabcabcaba";
        Assertions.assertEquals(expected, solution1754.largestMerge(word1, word2));
    }
}
