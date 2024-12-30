import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2499Tests {
    private final Solution2499 solution2499 = new Solution2499();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 4, 5};
        long expected = 10;
        Assertions.assertEquals(expected, solution2499.minimumTotalCost(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {2, 2, 2, 1, 3};
        int[] nums2 = {1, 2, 2, 3, 3};
        long expected = 10;
        Assertions.assertEquals(expected, solution2499.minimumTotalCost(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {1, 2, 2};
        long expected = -1;
        Assertions.assertEquals(expected, solution2499.minimumTotalCost(nums1, nums2));
    }
}
