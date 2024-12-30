import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2918Tests {
    private final Solution2918 solution2918 = new Solution2918();

    @Test
    public void example1() {
        int[] nums1 = {3, 2, 0, 1, 0};
        int[] nums2 = {6, 5, 0};
        long expected = 12;
        Assertions.assertEquals(expected, solution2918.minSum(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {2, 0, 2, 0};
        int[] nums2 = {1, 4};
        long expected = -1;
        Assertions.assertEquals(expected, solution2918.minSum(nums1, nums2));
    }
}