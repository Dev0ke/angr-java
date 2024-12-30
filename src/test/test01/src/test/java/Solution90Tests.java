import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution90Tests {
    private final Solution90 solution90 = new Solution90();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[],[1],[1,2],[1,2,2],[2],[2,2]]");
        List<List<Integer>> actual = solution90.subsetsWithDup(nums);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {0};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[],[0]]");
        List<List<Integer>> actual = solution90.subsetsWithDup(nums);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
