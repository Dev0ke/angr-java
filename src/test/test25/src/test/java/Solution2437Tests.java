import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2437Tests {
    private final Solution2437 solution2437 = new Solution2437();

    @Test
    public void example1() {
        String time = "?5:00";
        int expected = 2;
        Assertions.assertEquals(expected, solution2437.countTime(time));
        Assertions.assertEquals(expected, solution2437.countTime2(time));
    }

    @Test
    public void example2() {
        String time = "0?:0?";
        int expected = 100;
        Assertions.assertEquals(expected, solution2437.countTime(time));
        Assertions.assertEquals(expected, solution2437.countTime2(time));
    }

    @Test
    public void example3() {
        String time = "??:??";
        int expected = 1440;
        Assertions.assertEquals(expected, solution2437.countTime(time));
        Assertions.assertEquals(expected, solution2437.countTime2(time));
    }
}
