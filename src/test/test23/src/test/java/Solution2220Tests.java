import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2220Tests {
    private final Solution2220 solution2220 = new Solution2220();

    @Test
    public void example1() {
        int start = 10;
        int goal = 7;
        int expected = 3;
        Assertions.assertEquals(expected, solution2220.minBitFlips(start, goal));
    }

    @Test
    public void example2() {
        int start = 3;
        int goal = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution2220.minBitFlips(start, goal));
    }
}
