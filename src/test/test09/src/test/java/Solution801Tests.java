import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution801Tests {
    private final Solution801 solution801 = new Solution801();

    @Test
    public void example1() {
        int[] nums1 = {1, 3, 5, 4};
        int[] nums2 = {1, 2, 3, 7};
        int expected = 1;
        Assertions.assertEquals(expected, solution801.minSwap(nums1, nums2));
    }

    // 补充用例
    @Test
    public void example2() {
        int[] nums1 = {0, 7, 8, 10, 10, 11, 12, 13, 19, 18};
        int[] nums2 = {4, 4, 5, 7, 11, 14, 15, 16, 17, 20};
        int expected = 4;
        Assertions.assertEquals(expected, solution801.minSwap(nums1, nums2));
    }
}