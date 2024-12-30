import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2956Tests {
    private final Solution2956 solution2956 = new Solution2956();

    @Test
    public void example1() {
        int[] nums1 = {4, 3, 2, 3, 1};
        int[] nums2 = {2, 2, 5, 2, 3, 6};
        int[] expected = {3, 4};
        Assertions.assertArrayEquals(expected, solution2956.findIntersectionValues(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {3, 4, 2, 3};
        int[] nums2 = {1, 5};
        int[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, solution2956.findIntersectionValues(nums1, nums2));
    }
}