import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution216Tests {
    private final Solution216 solution216 = new Solution216();

    @Test
    public void example1() {
        int k = 3;
        int n = 7;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2,4]]");
        Assertions.assertEquals(expected, solution216.combinationSum3(k, n));
    }

    @Test
    public void example2() {
        int k = 3;
        int n = 9;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2,6], [1,3,5], [2,3,4]]");
        List<List<Integer>> actual = solution216.combinationSum3(k, n);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int k = 4;
        int n = 1;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solution216.combinationSum3(k, n));
    }
}