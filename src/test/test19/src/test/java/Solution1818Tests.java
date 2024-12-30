import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1818Tests {
    private final Solution1818 solution1818 = new Solution1818();

    @Test
    public void example1() {
        int[] nums1 = {1, 7, 5};
        int[] nums2 = {2, 3, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution1818.minAbsoluteSumDiff(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {2, 4, 6, 8, 10};
        int[] nums2 = {2, 4, 6, 8, 10};
        int expected = 0;
        Assertions.assertEquals(expected, solution1818.minAbsoluteSumDiff(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {1, 10, 4, 4, 2, 7};
        int[] nums2 = {9, 3, 5, 1, 7, 4};
        int expected = 20;
        Assertions.assertEquals(expected, solution1818.minAbsoluteSumDiff(nums1, nums2));
    }
}
