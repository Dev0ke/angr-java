import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution454Tests {
    private final Solution454 solution454 = new Solution454();

    @Test
    public void example1() {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution454.fourSumCount(nums1, nums2, nums3, nums4));
    }

    @Test
    public void example2() {
        int[] nums1 = {0};
        int[] nums2 = {0};
        int[] nums3 = {0};
        int[] nums4 = {0};
        int expected = 1;
        Assertions.assertEquals(expected, solution454.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
