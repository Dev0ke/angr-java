import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3148Tests {
    private final Solution3148 solution3148 = new Solution3148();

    @Test
    public void example1() {
        List<List<Integer>> grid = UtUtils.stringToIntegerList2("[[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]");
        int expected = 9;
        Assertions.assertEquals(expected, solution3148.maxScore(grid));
    }

    @Test
    public void example2() {
        List<List<Integer>> grid = UtUtils.stringToIntegerList2("[[4,3,2],[3,2,1]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution3148.maxScore(grid));
    }
}