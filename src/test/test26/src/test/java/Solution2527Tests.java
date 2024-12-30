import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2527Tests {
    private final Solution2527 solution2527 = new Solution2527();

    @Test
    public void example1() {
        int[] nums = {1, 4};
        int expected = 5;
        Assertions.assertEquals(expected, solution2527.xorBeauty(nums));
    }

    @Test
    public void example2() {
        int[] nums = {15, 45, 20, 2, 34, 35, 5, 44, 32, 30};
        int expected = 34;
        Assertions.assertEquals(expected, solution2527.xorBeauty(nums));
    }
}
