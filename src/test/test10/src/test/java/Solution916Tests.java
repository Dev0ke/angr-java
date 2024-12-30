import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution916Tests {
    private final Solution916 solution916 = new Solution916();

    @Test
    public void example1() {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};
        List<String> expected = Arrays.asList("facebook", "google", "leetcode");
        Assertions.assertEquals(expected, solution916.wordSubsets(words1, words2));
    }

    @Test
    public void example2() {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"l", "e"};
        List<String> expected = Arrays.asList("apple", "google", "leetcode");
        Assertions.assertEquals(expected, solution916.wordSubsets(words1, words2));
    }

    @Test
    public void example3() {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "oo"};
        List<String> expected = Arrays.asList("facebook", "google");
        Assertions.assertEquals(expected, solution916.wordSubsets(words1, words2));
    }

    @Test
    public void example4() {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"lo", "eo"};
        List<String> expected = Arrays.asList("google", "leetcode");
        Assertions.assertEquals(expected, solution916.wordSubsets(words1, words2));
    }

    @Test
    public void example5() {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"ec", "oc", "ceo"};
        List<String> expected = Arrays.asList("facebook", "leetcode");
        Assertions.assertEquals(expected, solution916.wordSubsets(words1, words2));
    }
}