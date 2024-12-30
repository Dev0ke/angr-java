import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2771Tests {
    private final Solution2771 solution2771 = new Solution2771();

    @Test
    public void example1() {
        int[] nums1 = {2, 3, 1};
        int[] nums2 = {1, 2, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution2771.maxNonDecreasingLength(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 3, 2, 1};
        int[] nums2 = {2, 2, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution2771.maxNonDecreasingLength(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {1, 1};
        int[] nums2 = {2, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution2771.maxNonDecreasingLength(nums1, nums2));
    }
}