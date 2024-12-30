import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4Tests {
    private final Solution4 solution4 = new Solution4();

    @Test
    public void example1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.00000;
        Assertions.assertEquals(expected, solution4.findMedianSortedArrays(nums1, nums2));
        Assertions.assertEquals(expected, solution4.findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.50000;
        Assertions.assertEquals(expected, solution4.findMedianSortedArrays(nums1, nums2));
        Assertions.assertEquals(expected, solution4.findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};
        double expected = 0.00000;
        Assertions.assertEquals(expected, solution4.findMedianSortedArrays(nums1, nums2));
        Assertions.assertEquals(expected, solution4.findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    public void example4() {
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.00000;
        Assertions.assertEquals(expected, solution4.findMedianSortedArrays(nums1, nums2));
        Assertions.assertEquals(expected, solution4.findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    public void example5() {
        int[] nums1 = {2};
        int[] nums2 = {};
        double expected = 2.00000;
        Assertions.assertEquals(expected, solution4.findMedianSortedArrays(nums1, nums2));
        Assertions.assertEquals(expected, solution4.findMedianSortedArrays2(nums1, nums2));
    }
}
