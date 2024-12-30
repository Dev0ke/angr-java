import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1775Tests {
    private final Solution1775 solution1775 = new Solution1775();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {1, 1, 2, 2, 2, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution1775.minOperations(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 1, 1, 1, 1, 1, 1};
        int[] nums2 = {6};
        int expected = -1;
        Assertions.assertEquals(expected, solution1775.minOperations(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {6, 6};
        int[] nums2 = {1};
        int expected = 3;
        Assertions.assertEquals(expected, solution1775.minOperations(nums1, nums2));
    }
}
