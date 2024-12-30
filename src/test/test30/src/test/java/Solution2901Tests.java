import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2901Tests {
    private final Solution2901 solution2901 = new Solution2901();

    @Test
    public void example1() {
        int n = 3;
        String[] words = {"bab", "dab", "cab"};
        int[] groups = {1, 2, 2};
//        List<String> expected = List.of("bab", "cab");
        // 另一个可行的答案是 [words[0],words[1]] = ["bab","dab"] 。
        List<String> expected = List.of("bab", "dab");
        Assertions.assertEquals(expected, solution2901.getWordsInLongestSubsequence(words, groups));
    }

    @Test
    public void example2() {
        int n = 4;
        String[] words = {"a", "b", "c", "d"};
        int[] groups = {1, 2, 3, 4};
        List<String> expected = List.of("a", "b", "c", "d");
        Assertions.assertEquals(expected, solution2901.getWordsInLongestSubsequence(words, groups));
    }
}