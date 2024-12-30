import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2425Tests {
    private final Solution2425 solution2425 = new Solution2425();

    @Test
    public void example1() {
        int[] nums1 = {2, 1, 3};
        int[] nums2 = {10, 2, 5, 0};
        int expected = 13;
        Assertions.assertEquals(expected, solution2425.xorAllNums(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution2425.xorAllNums(nums1, nums2));
    }
}
