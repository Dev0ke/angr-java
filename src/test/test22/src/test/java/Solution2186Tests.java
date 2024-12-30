import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2186Tests {
    private final Solution2186 solution2186 = new Solution2186();

    @Test
    public void example1() {
        String s = "leetcode";
        String t = "coats";
        int expected = 7;
        Assertions.assertEquals(expected, solution2186.minSteps(s, t));
    }

    @Test
    public void example2() {
        String s = "night";
        String t = "thing";
        int expected = 0;
        Assertions.assertEquals(expected, solution2186.minSteps(s, t));
    }
}
