import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution797Tests {
    private final Solution797 solution797 = new Solution797();

    @Test
    public void example1() {
        int[][] graph = UtUtils.stringToInts2("[[1,2],[3],[3],[]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,1,3],[0,2,3]]");
        Assertions.assertEquals(expected, solution797.allPathsSourceTarget(graph));
    }

    @Test
    public void example2() {
        int[][] graph = UtUtils.stringToInts2("[[4,3,1],[3,2,4],[3],[4],[]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]");
        Assertions.assertEquals(expected, solution797.allPathsSourceTarget(graph));
    }

    @Test
    public void example3() {
        int[][] graph = {{1}, {}};
        List<List<Integer>> expected = List.of(List.of(0, 1));
        Assertions.assertEquals(expected, solution797.allPathsSourceTarget(graph));
    }

    @Test
    public void example4() {
        int[][] graph = {{1, 2, 3}, {2}, {3}, {}};
        List<List<Integer>> expected = List.of(List.of(0, 1, 2, 3), List.of(0, 2, 3), List.of(0, 3));
        Assertions.assertEquals(expected, solution797.allPathsSourceTarget(graph));
    }

    @Test
    public void example5() {
        int[][] graph = {{1, 3}, {2}, {3}, {}};
        List<List<Integer>> expected = List.of(List.of(0, 1, 2, 3), List.of(0, 3));
        Assertions.assertEquals(expected, solution797.allPathsSourceTarget(graph));
    }
}
