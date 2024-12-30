import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2032Tests {
    private final Solution2032 solution2032 = new Solution2032();

    @Test
    public void example1() {
        int[] nums1 = {1, 1, 3, 2};
        int[] nums2 = {2, 3};
        int[] nums3 = {3};
        List<Integer> expected = Arrays.asList(3, 2);
        List<Integer> actual = solution2032.twoOutOfThree(nums1, nums2, nums3);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums1 = {3, 1};
        int[] nums2 = {2, 3};
        int[] nums3 = {1, 2};
        List<Integer> expected = Arrays.asList(2, 3, 1);
        List<Integer> actual = solution2032.twoOutOfThree(nums1, nums2, nums3);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {4, 3, 3};
        int[] nums3 = {5};
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = solution2032.twoOutOfThree(nums1, nums2, nums3);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
