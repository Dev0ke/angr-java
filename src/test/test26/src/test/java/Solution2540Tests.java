import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2540Tests {
    private final Solution2540 solution2540 = new Solution2540();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution2540.getCommon(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 2, 3, 6};
        int[] nums2 = {2, 3, 4, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution2540.getCommon(nums1, nums2));
    }
}