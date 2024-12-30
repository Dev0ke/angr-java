import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2068Tests {
    private final Solution2068 solution2068 = new Solution2068();

    @Test
    public void example1() {
        String word1 = "aaaa";
        String word2 = "bccb";
        Assertions.assertFalse(solution2068.checkAlmostEquivalent(word1, word2));
    }

    @Test
    public void example2() {
        String word1 = "abcdeef";
        String word2 = "abaaacc";
        Assertions.assertTrue(solution2068.checkAlmostEquivalent(word1, word2));
    }

    @Test
    public void example3() {
        String word1 = "cccddabba";
        String word2 = "babababab";
        Assertions.assertTrue(solution2068.checkAlmostEquivalent(word1, word2));
    }
}
