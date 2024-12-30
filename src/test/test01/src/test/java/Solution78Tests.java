import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution78Tests {
    private final Solution78.V1 solution78_v1 = new Solution78.V1();
    private final Solution78.V2 solution78_v2 = new Solution78.V2();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]");
        List<List<Integer>> actual = solution78_v1.subsets(nums);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example1_2() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]");
        List<List<Integer>> actual = solution78_v2.subsets(nums);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {0};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[],[0]]");
        List<List<Integer>> actual = solution78_v1.subsets(nums);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2_2() {
        int[] nums = {0};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[],[0]]");
        List<List<Integer>> actual = solution78_v2.subsets(nums);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
