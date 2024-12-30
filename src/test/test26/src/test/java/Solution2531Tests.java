import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2531Tests {
    private final Solution2531 solution2531 = new Solution2531();

    @Test
    public void example1() {
        String word1 = "ac";
        String word2 = "b";
        Assertions.assertFalse(solution2531.isItPossible(word1, word2));
    }

    @Test
    public void example2() {
        String word1 = "abcc";
        String word2 = "aab";
        Assertions.assertTrue(solution2531.isItPossible(word1, word2));
    }

    @Test
    public void example3() {
        String word1 = "abcde";
        String word2 = "fghij";
        Assertions.assertTrue(solution2531.isItPossible(word1, word2));
    }
}
