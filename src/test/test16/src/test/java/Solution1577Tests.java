import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1577Tests {
    private final Solution1577 solution1577 = new Solution1577();

    @Test
    public void example1() {
        int[] nums1 = {7, 4};
        int[] nums2 = {5, 2, 8, 9};
        int expected = 1;
        Assertions.assertEquals(expected, solution1577.numTriplets(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 1};
        int[] nums2 = {1, 1, 1};
        int expected = 9;
        Assertions.assertEquals(expected, solution1577.numTriplets(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {7, 7, 8, 3};
        int[] nums2 = {1, 2, 9, 7};
        int expected = 2;
        Assertions.assertEquals(expected, solution1577.numTriplets(nums1, nums2));
    }

    @Test
    public void example4() {
        int[] nums1 = {4, 7, 9, 11, 23};
        int[] nums2 = {3, 5, 1024, 12, 18};
        int expected = 0;
        Assertions.assertEquals(expected, solution1577.numTriplets(nums1, nums2));
    }
}