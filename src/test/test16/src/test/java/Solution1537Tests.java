import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1537Tests {
    private final Solution1537 solution1537 = new Solution1537();

    @Test
    public void example1() {
        // 2, 4, 5, 8, 10
        // ---4, 6, 8, 9
        int[] nums1 = {2, 4, 5, 8, 10};
        int[] nums2 = {4, 6, 8, 9};
        int expected = 30;
        Assertions.assertEquals(expected, solution1537.maxSum(nums1, nums2));
    }

    @Test
    public void example2() {
        // 1, 3, 5, 7, 9
        // ---3, 5, 100
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {3, 5, 100};
        int expected = 109;
        Assertions.assertEquals(expected, solution1537.maxSum(nums1, nums2));
    }

    @Test
    public void example3() {
        // 1, 2, 3, 4, 5
        // --------------6, 7, 8, 9, 10
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10};
        int expected = 40;
        Assertions.assertEquals(expected, solution1537.maxSum(nums1, nums2));
    }

    @Test
    public void example4() {
        // 1,    4, 5, 8, 9, 11, 19
        // 2, 3, 4-----------11, 12
        int[] nums1 = {1, 4, 5, 8, 9, 11, 19};
        int[] nums2 = {2, 3, 4, 11, 12};
        int expected = 61;
        Assertions.assertEquals(expected, solution1537.maxSum(nums1, nums2));
    }
}
