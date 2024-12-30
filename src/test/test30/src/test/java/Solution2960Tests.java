import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2960Tests {
    private final Solution2960 solution2960 = new Solution2960();

    @Test
    public void example1() {
        int[] batteryPercentages = {1, 1, 2, 1, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution2960.countTestedDevices(batteryPercentages));
    }

    @Test
    public void example2() {
        int[] batteryPercentages = {0, 1, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution2960.countTestedDevices(batteryPercentages));
    }
}