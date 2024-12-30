import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2934Tests {
    private final Solution2934 solution2934 = new Solution2934();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 7};
        int[] nums2 = {4, 5, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution2934.minOperations(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {2, 3, 4, 5, 9};
        int[] nums2 = {8, 8, 4, 4, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution2934.minOperations(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {1, 5, 4};
        int[] nums2 = {2, 5, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution2934.minOperations(nums1, nums2));
    }
}