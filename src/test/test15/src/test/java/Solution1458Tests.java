import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1458Tests {
    private final Solution1458 solution1458 = new Solution1458();

    @Test
    public void example1() {
        int[] nums1 = {2, 1, -2, 5};
        int[] nums2 = {3, 0, -6};
        int expected = 18;
        Assertions.assertEquals(expected, solution1458.maxDotProduct(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {3, -2};
        int[] nums2 = {2, -6, 7};
        int expected = 21;
        Assertions.assertEquals(expected, solution1458.maxDotProduct(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {-1, -1};
        int[] nums2 = {1, 1};
        int expected = -1;
        Assertions.assertEquals(expected, solution1458.maxDotProduct(nums1, nums2));
    }
}