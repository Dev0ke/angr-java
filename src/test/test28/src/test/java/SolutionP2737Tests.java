import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP2737Tests {
    private final SolutionP2737 solutionP2737 = new SolutionP2737();

    @Test
    public void example1() {
        int n = 4;
        List<List<Integer>> edges = UtUtils.stringToIntegerList2("[[0,1,1],[1,2,3],[2,3,2],[0,3,4]]");
        int s = 0;
        int[] marked = {2, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP2737.minimumDistance(n, edges, s, marked));
    }

    @Test
    public void example2() {
        int n = 5;
        List<List<Integer>> edges = UtUtils.stringToIntegerList2("[[0,1,2],[0,2,4],[1,3,1],[2,3,3],[3,4,2]]");
        int s = 1;
        int[] marked = {0, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2737.minimumDistance(n, edges, s, marked));
    }

    @Test
    public void example3() {
        int n = 4;
        List<List<Integer>> edges = UtUtils.stringToIntegerList2("[[0,1,1],[1,2,3],[2,3,2]]");
        int s = 3;
        int[] marked = {0, 1};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP2737.minimumDistance(n, edges, s, marked));
    }
}