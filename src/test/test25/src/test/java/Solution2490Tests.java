import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2490Tests {
    private final Solution2490 solution2490 = new Solution2490();

    @Test
    public void example1() {
        String sentence = "leetcode exercises sound delightful";
        Assertions.assertTrue(solution2490.isCircularSentence(sentence));
    }

    @Test
    public void example2() {
        String sentence = "eetcode";
        Assertions.assertTrue(solution2490.isCircularSentence(sentence));
    }

    @Test
    public void example3() {
        String sentence = "Leetcode is cool";
        Assertions.assertFalse(solution2490.isCircularSentence(sentence));
    }
}
