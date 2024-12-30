import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution140Tests {
    private final Solution140 solution140 = new Solution140();

    @Test
    public void example1() {
        String s = "catsanddog";
        List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
        List<String> expected = Arrays.asList("cats and dog", "cat sand dog");
        List<String> actual = solution140.wordBreak(s, wordDict);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String s = "pineapplepenapple";
        List<String> wordDict = List.of("apple", "pen", "applepen", "pine", "pineapple");
        List<String> expected = Arrays.asList("pine apple pen apple", "pineapple pen apple", "pine applepen apple");
        List<String> actual = solution140.wordBreak(s, wordDict);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        String s = "catsandog";
        List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat");
        List<String> expected = new ArrayList<>();
        List<String> actual = solution140.wordBreak(s, wordDict);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
