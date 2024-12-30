import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2135Tests {
    private final Solution2135 solution2135 = new Solution2135();

    @Test
    public void example1() {
        String[] startWords = {"ant", "act", "tack"};
        String[] targetWords = {"tack", "act", "acti"};
        int expected = 2;
        Assertions.assertEquals(expected, solution2135.wordCount(startWords, targetWords));
    }

    @Test
    public void example2() {
        String[] startWords = {"ab", "a"};
        String[] targetWords = {"abc", "abcd"};
        int expected = 1;
        Assertions.assertEquals(expected, solution2135.wordCount(startWords, targetWords));
    }
}
