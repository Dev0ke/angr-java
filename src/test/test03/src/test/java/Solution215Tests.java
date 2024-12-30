import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution215Tests {
    private final Solution215 solution215 = new Solution215();

    @Test
    public void example1() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution215.findKthLargest(nums, k));
    }

    @Test
    public void example1_2() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution215.findKthLargest2(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solution215.findKthLargest(nums, k));
    }

    @Test
    public void example2_2() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solution215.findKthLargest2(nums, k));
    }
}
