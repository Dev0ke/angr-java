import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2085Tests {
    private final Solution2085 solution2085 = new Solution2085();

    @Test
    public void example1() {
        String[] words1 = {"leetcode", "is", "amazing", "as", "is"};
        String[] words2 = {"amazing", "leetcode", "is"};
        int expected = 2;
        Assertions.assertEquals(expected, solution2085.countWords(words1, words2));
    }

    @Test
    public void example2() {
        String[] words1 = {"b", "bb", "bbb"};
        String[] words2 = {"a", "aa", "aaa"};
        int expected = 0;
        Assertions.assertEquals(expected, solution2085.countWords(words1, words2));
    }

    @Test
    public void example3() {
        String[] words1 = {"a", "ab"};
        String[] words2 = {"a", "a", "a", "ab"};
        int expected = 1;
        Assertions.assertEquals(expected, solution2085.countWords(words1, words2));
    }
}
