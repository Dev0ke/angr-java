import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2272Tests {
    private final Solution2272 solution2272 = new Solution2272();

    @Test
    public void example1() {
        String s = "aababbb";
        int expected = 3;
        Assertions.assertEquals(expected, solution2272.largestVariance(s));
    }

    @Test
    public void example2() {
        String s = "abcde";
        int expected = 0;
        Assertions.assertEquals(expected, solution2272.largestVariance(s));
    }
}
