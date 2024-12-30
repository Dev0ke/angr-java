import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3002Tests {
    private final Solution3002 solution3002 = new Solution3002();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 1, 2};
        int[] nums2 = {1, 1, 1, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution3002.maximumSetSize(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {2, 3, 2, 3, 2, 3};
        int expected = 5;
        Assertions.assertEquals(expected, solution3002.maximumSetSize(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {1, 1, 2, 2, 3, 3};
        int[] nums2 = {4, 4, 5, 5, 6, 6};
        int expected = 6;
        Assertions.assertEquals(expected, solution3002.maximumSetSize(nums1, nums2));
    }
}