import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution496Tests {
    private final Solution496 solution496 = new Solution496();

    @Test
    public void example1() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] expected = {-1, 3, -1};
        Assertions.assertArrayEquals(expected, solution496.nextGreaterElement(nums1, nums2));
        Assertions.assertArrayEquals(expected, solution496.nextGreaterElement2(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] expected = {3, -1};
        Assertions.assertArrayEquals(expected, solution496.nextGreaterElement(nums1, nums2));
        Assertions.assertArrayEquals(expected, solution496.nextGreaterElement2(nums1, nums2));
    }
}
