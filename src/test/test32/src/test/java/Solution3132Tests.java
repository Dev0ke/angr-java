import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3132Tests {
    private final Solution3132 solution3132 = new Solution3132();

    @Test
    public void example1() {
        int[] nums1 = {4, 20, 16, 12, 8};
        int[] nums2 = {14, 18, 10};
        int expected = -2;
        Assertions.assertEquals(expected, solution3132.minimumAddedInteger(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {3, 5, 5, 3};
        int[] nums2 = {7, 7};
        int expected = 2;
        Assertions.assertEquals(expected, solution3132.minimumAddedInteger(nums1, nums2));
    }
}