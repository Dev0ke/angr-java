import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1855Tests {
    private final Solution1855 solution1855 = new Solution1855();

    @Test
    public void example1() {
        int[] nums1 = {55, 30, 5, 4, 2};
        int[] nums2 = {100, 20, 10, 10, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution1855.maxDistance(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {10, 10, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1855.maxDistance(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {30, 29, 19, 5};
        int[] nums2 = {25, 25, 25, 25, 25};
        int expected = 2;
        Assertions.assertEquals(expected, solution1855.maxDistance(nums1, nums2));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] nums1 = {5, 4};
        int[] nums2 = {3, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution1855.maxDistance(nums1, nums2));
    }
}
