import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution930Tests {
    private final Solution930 solution930 = new Solution930();

    @Test
    public void example1() {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution930.numSubarraysWithSum(nums, goal));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 0, 0, 0};
        int goal = 0;
        int expected = 15;
        Assertions.assertEquals(expected, solution930.numSubarraysWithSum(nums, goal));
    }
}
