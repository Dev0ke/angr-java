import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2210Tests {
    private final Solution2210 solution2210 = new Solution2210();

    @Test
    public void example1() {
        int[] nums = {2, 4, 1, 1, 6, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution2210.countHillValley(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 6, 5, 5, 4, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution2210.countHillValley(nums));
    }
}
