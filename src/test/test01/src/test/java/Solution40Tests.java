import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution40Tests {
    private final Solution40 solution40 = new Solution40();

    @Test
    public void example1() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [
                [1,1,6],
                [1,2,5],
                [1,7],
                [2,6]
                ]
                """);
        List<List<Integer>> actual = solution40.combinationSum2(candidates, target);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [
                [1,2,2],
                [5]
                ]
                """);
        List<List<Integer>> actual = solution40.combinationSum2(candidates, target);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
