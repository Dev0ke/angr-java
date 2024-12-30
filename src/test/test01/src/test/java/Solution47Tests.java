import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution47Tests {
    private final Solution47 solution47 = new Solution47();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> actual = solution47.permuteUnique(nums);
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [[1,1,2],
                 [1,2,1],
                 [2,1,1]]
                """);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> actual = solution47.permuteUnique(nums);
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
                """);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
