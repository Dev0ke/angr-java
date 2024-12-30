import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1662Tests {
    private final Solution1662 solution1662 = new Solution1662();

    @Test
    public void example1() {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        Assertions.assertTrue(solution1662.arrayStringsAreEqual(word1, word2));
    }

    @Test
    public void example2() {
        String[] word1 = {"a", "cb"};
        String[] word2 = {"ab", "c"};
        Assertions.assertFalse(solution1662.arrayStringsAreEqual(word1, word2));
    }

    @Test
    public void example3() {
        String[] word1 = {"abc", "d", "defg"};
        String[] word2 = {"abcddefg"};
        Assertions.assertTrue(solution1662.arrayStringsAreEqual(word1, word2));
    }
}
