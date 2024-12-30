import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2215Tests {
    private final Solution2215 solution2215 = new Solution2215();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,3],[4,6]]");
        List<List<Integer>> actual = solution2215.findDifference(nums1, nums2);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 1, 2, 2};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[3],[]]");
        List<List<Integer>> actual = solution2215.findDifference(nums1, nums2);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
