import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2770Tests {
    private final Solution2770 solution2770 = new Solution2770();

    @Test
    public void example1() {
        int[] nums = {1, 3, 6, 4, 1, 2};
        int target = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2770.maximumJumps(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 6, 4, 1, 2};
        int target = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solution2770.maximumJumps(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {1, 3, 6, 4, 1, 2};
        int target = 0;
        int expected = -1;
        Assertions.assertEquals(expected, solution2770.maximumJumps(nums, target));
    }
}