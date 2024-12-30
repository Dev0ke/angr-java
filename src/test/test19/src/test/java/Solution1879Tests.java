import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1879Tests {
    private final Solution1879 solution1879 = new Solution1879();

    @Test
    public void example1() {
        int[] nums1 = {1, 2};
        int[] nums2 = {2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution1879.minimumXORSum(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 0, 3};
        int[] nums2 = {5, 3, 4};
        int expected = 8;
        Assertions.assertEquals(expected, solution1879.minimumXORSum(nums1, nums2));
    }
}
