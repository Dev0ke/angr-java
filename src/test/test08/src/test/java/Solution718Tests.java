import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution718Tests {
    private final Solution718 solution718 = new Solution718();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        int expected = 3;
        Assertions.assertEquals(expected, solution718.findLength(nums1, nums2));
        Assertions.assertEquals(expected, solution718.findLength2(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {0, 0, 0, 0, 0};
        int[] nums2 = {0, 0, 0, 0, 0};
        int expected = 5;
        Assertions.assertEquals(expected, solution718.findLength(nums1, nums2));
        Assertions.assertEquals(expected, solution718.findLength2(nums1, nums2));
    }
}
