import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2900Tests {
    private final Solution2900 solution2900 = new Solution2900();

    @Test
    public void example1() {
        int n = 3;
        String[] words = {"bab", "dab", "cab"};
        int[] groups = {1, 2, 2};
        List<String> expected = List.of("bab", "cab");
        Assertions.assertEquals(expected, solution2900.getWordsInLongestSubsequence(n, words, groups));
    }

    @Test
    public void example2() {
        int n = 4;
        String[] words = {"a", "b", "c", "d"};
        int[] groups = {1, 2, 3, 4};
        List<String> expected = List.of("a", "b", "c", "d");
        Assertions.assertEquals(expected, solution2900.getWordsInLongestSubsequence(n, words, groups));
    }
}