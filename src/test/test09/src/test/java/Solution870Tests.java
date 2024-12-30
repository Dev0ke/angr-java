import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution870Tests {
    private final Solution870 solution870 = new Solution870();

    @Test
    public void example1() {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {1, 10, 4, 11};
        int[] expected = {2, 11, 7, 15};
        Assertions.assertArrayEquals(expected, solution870.advantageCount(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {12, 24, 8, 32};
        int[] nums2 = {13, 25, 32, 11};
        int[] expected = {24, 32, 8, 12};
        Assertions.assertArrayEquals(expected, solution870.advantageCount(nums1, nums2));
    }
}