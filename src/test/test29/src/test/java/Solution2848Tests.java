import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2848Tests {
    private final Solution2848 solution2848 = new Solution2848();

    @Test
    public void example1() {
        List<List<Integer>> nums = UtUtils.stringToIntegerList2("[[3,6],[1,5],[4,7]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution2848.numberOfPoints(nums));
    }

    @Test
    public void example2() {
        List<List<Integer>> nums = UtUtils.stringToIntegerList2("[[1,3],[5,8]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution2848.numberOfPoints(nums));
    }
}