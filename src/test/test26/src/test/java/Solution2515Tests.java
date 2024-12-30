import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2515Tests {
    private final Solution2515 solution2515 = new Solution2515();

    @Test
    public void example1() {
        String[] words = {"hello", "i", "am", "leetcode", "hello"};
        String target = "hello";
        int startIndex = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution2515.closetTarget(words, target, startIndex));
    }

    @Test
    public void example2() {
        String[] words = {"a", "b", "leetcode"};
        String target = "leetcode";
        int startIndex = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution2515.closetTarget(words, target, startIndex));
    }

    @Test
    public void example3() {
        String[] words = {"i", "eat", "leetcode"};
        String target = "ate";
        int startIndex = 0;
        int expected = -1;
        Assertions.assertEquals(expected, solution2515.closetTarget(words, target, startIndex));
    }
}
