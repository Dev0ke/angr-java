import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution350Tests {
    private final Solution350 solution350 = new Solution350();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] expected = {2, 2};
        Assertions.assertArrayEquals(expected, solution350.intersect(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] expected = {4, 9};
        Assertions.assertArrayEquals(expected, solution350.intersect(nums1, nums2));
    }
}
