import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1617Tests {
    private final Solution1617 solution1617 = new Solution1617();

    @Test
    public void example1() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[2,3],[2,4]]");
        int[] expected = {3, 4, 0};
        Assertions.assertArrayEquals(expected, solution1617.countSubgraphsForEachDiameter(n, edges));
    }

    @Test
    public void example2() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[1,2]]");
        int[] expected = {1};
        Assertions.assertArrayEquals(expected, solution1617.countSubgraphsForEachDiameter(n, edges));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[2,3]]");
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution1617.countSubgraphsForEachDiameter(n, edges));
    }
}