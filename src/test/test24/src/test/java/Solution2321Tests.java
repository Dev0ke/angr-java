import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2321Tests {
    private final Solution2321 solution2321 = new Solution2321();

    @Test
    public void example1() {
        int[] nums1 = {60, 60, 60};
        int[] nums2 = {10, 90, 10};
        int expected = 210;
        Assertions.assertEquals(expected, solution2321.maximumsSplicedArray(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {20, 40, 20, 70, 30};
        int[] nums2 = {50, 20, 50, 40, 20};
        int expected = 220;
        Assertions.assertEquals(expected, solution2321.maximumsSplicedArray(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {7, 11, 13};
        int[] nums2 = {1, 1, 1};
        int expected = 31;
        Assertions.assertEquals(expected, solution2321.maximumsSplicedArray(nums1, nums2));
    }
}
