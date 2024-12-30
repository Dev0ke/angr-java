import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2996Tests {
    private final Solution2996 solution2996 = new Solution2996();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 2, 5};
        int expected = 6;
        Assertions.assertEquals(expected, solution2996.missingInteger(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 4, 5, 1, 12, 14, 13};
        int expected = 15;
        Assertions.assertEquals(expected, solution2996.missingInteger(nums));
    }
}