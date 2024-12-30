import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3295Tests {
    private final Solution3295 solution3295 = new Solution3295();

    @Test
    public void example1() {
        String[] message = {"hello", "world", "leetcode"};
        String[] bannedWords = {"world", "hello"};
        Assertions.assertTrue(solution3295.reportSpam(message, bannedWords));
    }

    @Test
    public void example2() {
        String[] message = {"hello", "programming", "fun"};
        String[] bannedWords = {"world", "programming", "leetcode"};
        Assertions.assertFalse(solution3295.reportSpam(message, bannedWords));
    }
}