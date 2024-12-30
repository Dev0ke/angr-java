import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2605Tests {
    private final Solution2605 solution2605 = new Solution2605();

    @Test
    public void example1() {
        int[] nums1 = {4, 1, 3};
        int[] nums2 = {5, 7};
        int expected = 15;
        Assertions.assertEquals(expected, solution2605.minNumber(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {3, 5, 2, 6};
        int[] nums2 = {3, 1, 7};
        int expected = 3;
        Assertions.assertEquals(expected, solution2605.minNumber(nums1, nums2));
    }
}