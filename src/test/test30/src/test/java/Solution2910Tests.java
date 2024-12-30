import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2910Tests {
    private final Solution2910 solution2910 = new Solution2910();

    @Test
    public void example1() {
        int[] nums = {3, 2, 3, 2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution2910.minGroupsForValidAssignment(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, 10, 10, 3, 1, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution2910.minGroupsForValidAssignment(nums));
    }
}