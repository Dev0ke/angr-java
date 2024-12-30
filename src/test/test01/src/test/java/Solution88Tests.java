import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution88Tests {
    private final Solution88 solution88 = new Solution88();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        int[] expected = {1, 2, 2, 3, 5, 6};
        solution88.merge(nums1, m, nums2, n);
        Assertions.assertArrayEquals(expected, nums1);
    }

    @Test
    public void example2() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        int[] expected = {1};
        solution88.merge(nums1, m, nums2, n);
        Assertions.assertArrayEquals(expected, nums1);
    }

    @Test
    public void example3() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        int[] expected = {1};
        solution88.merge(nums1, m, nums2, n);
        Assertions.assertArrayEquals(expected, nums1);
    }
}
