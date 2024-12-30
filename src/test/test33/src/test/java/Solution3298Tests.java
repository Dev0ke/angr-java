import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3298Tests {
    private final Solution3298 solution3298 = new Solution3298();

    @Test
    public void example1() {
        String word1 = "bcca";
        String word2 = "abc";
        long expected = 1;
        Assertions.assertEquals(expected, solution3298.validSubstringCount(word1, word2));
    }

    @Test
    public void example2() {
        String word1 = "abcabc";
        String word2 = "abc";
        long expected = 10;
        Assertions.assertEquals(expected, solution3298.validSubstringCount(word1, word2));
    }

    @Test
    public void example3() {
        String word1 = "abcabc";
        String word2 = "aaabc";
        long expected = 0;
        Assertions.assertEquals(expected, solution3298.validSubstringCount(word1, word2));
    }
}