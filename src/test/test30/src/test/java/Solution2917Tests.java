import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2917Tests {
    private final Solution2917 solution2917 = new Solution2917();

    @Test
    public void example1() {
        int[] nums = {7, 12, 9, 8, 9, 15};
        int k = 4;
        int expected = 9;
        Assertions.assertEquals(expected, solution2917.findKOr(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 12, 1, 11, 4, 5};
        int k = 6;
        int expected = 0;
        Assertions.assertEquals(expected, solution2917.findKOr(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {10, 8, 5, 9, 11, 6, 8};
        int k = 1;
        int expected = 15;
        Assertions.assertEquals(expected, solution2917.findKOr(nums, k));
    }
}