import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2734Tests {
    private final Solution2734 solution2734 = new Solution2734();

    @Test
    public void example1() {
        String s = "cbabc";
        String expected = "baabc";
        Assertions.assertEquals(expected, solution2734.smallestString(s));
    }

    @Test
    public void example2() {
        String s = "acbbc";
        String expected = "abaab";
        Assertions.assertEquals(expected, solution2734.smallestString(s));
    }

    @Test
    public void example3() {
        String s = "leetcode";
        String expected = "kddsbncd";
        Assertions.assertEquals(expected, solution2734.smallestString(s));
    }
}