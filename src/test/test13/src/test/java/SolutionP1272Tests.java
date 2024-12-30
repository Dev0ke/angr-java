import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1272Tests {
    private final SolutionP1272 solutionP1272 = new SolutionP1272();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[0,2],[3,4],[5,7]]");
        int[] toBeRemoved = {1, 6};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,1],[6,7]]");
        Assertions.assertEquals(expected, solutionP1272.removeInterval(intervals, toBeRemoved));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[[0,5]]");
        int[] toBeRemoved = {2, 3};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,2],[3,5]]");
        Assertions.assertEquals(expected, solutionP1272.removeInterval(intervals, toBeRemoved));
    }

    @Test
    public void example3() {
        int[][] intervals = UtUtils.stringToInts2("[[-5,-4],[-3,-2],[1,2],[3,5],[8,9]]");
        int[] toBeRemoved = {-1, 4};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[-5,-4],[-3,-2],[4,5],[8,9]]");
        Assertions.assertEquals(expected, solutionP1272.removeInterval(intervals, toBeRemoved));
    }
}