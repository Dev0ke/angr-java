import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution46Tests {
    private final Solution46 solution46 = new Solution46();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> actual = solution46.permute(nums);
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]");
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {0, 1};
        List<List<Integer>> actual = solution46.permute(nums);
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,1],[1,0]]");
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] nums = {1};
        List<List<Integer>> actual = solution46.permute(nums);
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1]]");
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
