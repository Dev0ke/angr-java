import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2333Tests {
    private final Solution2333 solution2333 = new Solution2333();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 10, 20, 19};
        int k1 = 0;
        int k2 = 0;
        long expected = 579;
        Assertions.assertEquals(expected, solution2333.minSumSquareDiff(nums1, nums2, k1, k2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 4, 10, 12};
        int[] nums2 = {5, 8, 6, 9};
        int k1 = 1;
        int k2 = 1;
        long expected = 43;
        Assertions.assertEquals(expected, solution2333.minSumSquareDiff(nums1, nums2, k1, k2));
    }
}
