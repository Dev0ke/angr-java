import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution349Tests {
    private final Solution349 solution349 = new Solution349();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] expected = {2};
        int[] actual = solution349.intersection(nums1, nums2);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] expected = {4, 9};
        int[] actual = solution349.intersection(nums1, nums2);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
