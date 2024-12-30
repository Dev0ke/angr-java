import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2730Tests {
    private final Solution2730 solution2730 = new Solution2730();

    @Test
    public void example1() {
        String s = "52233";
        int expected = 4;
        Assertions.assertEquals(expected, solution2730.longestSemiRepetitiveSubstring(s));
    }

    @Test
    public void example2() {
        String s = "5494";
        int expected = 4;
        Assertions.assertEquals(expected, solution2730.longestSemiRepetitiveSubstring(s));
    }

    @Test
    public void example3() {
        String s = "1111111";
        int expected = 2;
        Assertions.assertEquals(expected, solution2730.longestSemiRepetitiveSubstring(s));
    }
}