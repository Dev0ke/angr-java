import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3164Tests {
    private final Solution3164 solution3164 = new Solution3164();

    @Test
    public void example1() {
        int[] nums1 = {1, 3, 4};
        int[] nums2 = {1, 3, 4};
        int k = 1;
        long expected = 5;
        Assertions.assertEquals(expected, solution3164.numberOfPairs(nums1, nums2, k));
        Assertions.assertEquals(expected, solution3164.numberOfPairs2(nums1, nums2, k));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 2, 4, 12};
        int[] nums2 = {2, 4};
        int k = 3;
        long expected = 2;
        Assertions.assertEquals(expected, solution3164.numberOfPairs(nums1, nums2, k));
        Assertions.assertEquals(expected, solution3164.numberOfPairs2(nums1, nums2, k));
    }
}