import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2225Tests {
    private final Solution2225 solution2225 = new Solution2225();

    @Test
    public void example1() {
        int[][] matches = UtUtils.stringToInts2("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2,10],[4,5,7,8]]");
        Assertions.assertEquals(expected, solution2225.findWinners(matches));
    }

    @Test
    public void example2() {
        int[][] matches = UtUtils.stringToInts2("[[2,3],[1,3],[5,4],[6,4]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2,5,6],[]]");
        Assertions.assertEquals(expected, solution2225.findWinners(matches));
    }
}
