import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution321Tests {
    private final Solution321 solution321 = new Solution321();

    @Test
    public void example1() {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        int[] expected = {9, 8, 6, 5, 3};
        Assertions.assertArrayEquals(expected, solution321.maxNumber(nums1, nums2, k));
    }

    @Test
    public void example2() {
        int[] nums1 = {6, 7};
        int[] nums2 = {6, 0, 4};
        int k = 5;
        int[] expected = {6, 7, 6, 0, 4};
        Assertions.assertArrayEquals(expected, solution321.maxNumber(nums1, nums2, k));
    }

    @Test
    public void example3() {
        int[] nums1 = {3, 9};
        int[] nums2 = {8, 9};
        int k = 3;
        int[] expected = {9, 8, 9};
        Assertions.assertArrayEquals(expected, solution321.maxNumber(nums1, nums2, k));
    }
}