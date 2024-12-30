import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1035Tests {
    private final Solution1035 solution1035 = new Solution1035();

    @Test
    public void example1() {
        int[] nums1 = {1, 4, 2};
        int[] nums2 = {1, 2, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution1035.maxUncrossedLines(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {2, 5, 1, 2, 5};
        int[] nums2 = {10, 5, 2, 1, 5, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution1035.maxUncrossedLines(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {1, 3, 7, 1, 7, 5};
        int[] nums2 = {1, 9, 2, 5, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution1035.maxUncrossedLines(nums1, nums2));
    }
}
