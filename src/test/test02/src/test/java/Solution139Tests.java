import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution139Tests {
    private final Solution139 solution139 = new Solution139();

    @Test
    public void example1() {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        Assertions.assertTrue(solution139.wordBreak(s, wordDict));
    }

    @Test
    public void example2() {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple", "pen");
        Assertions.assertTrue(solution139.wordBreak(s, wordDict));
    }

    @Test
    public void example3() {
        String s = "catsandog";
        List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat");
        Assertions.assertFalse(solution139.wordBreak(s, wordDict));
    }
}
