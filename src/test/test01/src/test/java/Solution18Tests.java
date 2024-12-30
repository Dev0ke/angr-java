import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution18Tests {
    private final Solution18 solution18 = new Solution18();

    @Test
    public void example1() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]");
        List<List<Integer>> actual = solution18.fourSum(nums, target);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,2,2,2]]");
        List<List<Integer>> actual = solution18.fourSum(nums, target);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000};
        int target = 1000000000;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,0,0,1000000000]]");
        List<List<Integer>> actual = solution18.fourSum(nums, target);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}

