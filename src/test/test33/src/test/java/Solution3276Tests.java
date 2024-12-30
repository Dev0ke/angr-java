import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3276Tests {
    private final Solution3276 solution3276 = new Solution3276();

    @Test
    public void example1() {
        List<List<Integer>> grid = UtUtils.stringToIntegerList2("[[1,2,3],[4,3,2],[1,1,1]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution3276.maxScore(grid));
    }

    @Test
    public void example2() {
        List<List<Integer>> grid = UtUtils.stringToIntegerList2("[[8,7,6],[8,3,2]]");
        int expected = 15;
        Assertions.assertEquals(expected, solution3276.maxScore(grid));
    }
}