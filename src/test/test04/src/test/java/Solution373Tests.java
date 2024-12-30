import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution373Tests {
    private final Solution373 solution373 = new Solution373();

    @Test
    public void example1() {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2],[1,4],[1,6]]");
        List<List<Integer>> actual = solution373.kSmallestPairs(nums1, nums2, k);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example1_2() {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2],[1,4],[1,6]]");
        List<List<Integer>> actual = solution373.kSmallestPairs2(nums1, nums2, k);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        int k = 2;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,1],[1,1]]");
        List<List<Integer>> actual = solution373.kSmallestPairs(nums1, nums2, k);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2_2() {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        int k = 2;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,1],[1,1]]");
        List<List<Integer>> actual = solution373.kSmallestPairs2(nums1, nums2, k);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        int k = 3;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,3],[2,3]]");
        List<List<Integer>> actual = solution373.kSmallestPairs(nums1, nums2, k);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3_2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        int k = 3;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,3],[2,3]]");
        List<List<Integer>> actual = solution373.kSmallestPairs2(nums1, nums2, k);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
