import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1768Tests {
    private final Solution1768 solution1768 = new Solution1768();

    @Test
    public void example1() {
        String word1 = "abc";
        String word2 = "pqr";
        String expected = "apbqcr";
        Assertions.assertEquals(expected, solution1768.mergeAlternately(word1, word2));
    }

    @Test
    public void example2() {
        String word1 = "ab";
        String word2 = "pqrs";
        String expected = "apbqrs";
        Assertions.assertEquals(expected, solution1768.mergeAlternately(word1, word2));
    }

    @Test
    public void example3() {
        String word1 = "abcd";
        String word2 = "pq";
        String expected = "apbqcd";
        Assertions.assertEquals(expected, solution1768.mergeAlternately(word1, word2));
    }
}
