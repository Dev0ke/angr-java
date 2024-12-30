import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution491Tests {
    private final Solution491 solution491 = new Solution491();

    @Test
    public void example1() {
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]");
        List<List<Integer>> actual = solution491.findSubsequences(nums);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {4, 4, 3, 2, 1};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[4,4]]");
        List<List<Integer>> actual = solution491.findSubsequences(nums);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}