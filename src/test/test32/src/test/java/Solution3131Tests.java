import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3131Tests {
    private final Solution3131 solution3131 = new Solution3131();

    @Test
    public void example1() {
        int[] nums1 = {2, 6, 4};
        int[] nums2 = {9, 7, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution3131.addedInteger(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {10};
        int[] nums2 = {5};
        int expected = -5;
        Assertions.assertEquals(expected, solution3131.addedInteger(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {1, 1, 1, 1};
        int[] nums2 = {1, 1, 1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution3131.addedInteger(nums1, nums2));
    }
}