import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2172Tests {
    private final Solution2172 solution2172 = new Solution2172();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int numSlots = 3;
        int expected = 9;
        Assertions.assertEquals(expected, solution2172.maximumANDSum(nums, numSlots));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 10, 4, 7, 1};
        int numSlots = 9;
        int expected = 24;
        Assertions.assertEquals(expected, solution2172.maximumANDSum(nums, numSlots));
    }

    @Test
    public void example3() {
        int[] nums = {14, 7, 9, 8, 2, 4, 11, 1, 9};
        int numSlots = 8;
        int expected = 40;
        Assertions.assertEquals(expected, solution2172.maximumANDSum(nums, numSlots));
    }
}