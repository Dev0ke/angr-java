import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2598Tests {
    private final Solution2598 solution2598 = new Solution2598();

    @Test
    public void example1() {
        int[] nums = {1, -10, 7, 13, 6, 8};
        int value = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution2598.findSmallestInteger(nums, value));
    }

    @Test
    public void example2() {
        int[] nums = {1, -10, 7, 13, 6, 8};
        int value = 7;
        int expected = 2;
        Assertions.assertEquals(expected, solution2598.findSmallestInteger(nums, value));
    }
}