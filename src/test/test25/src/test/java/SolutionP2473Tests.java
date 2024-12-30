import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2473Tests {
    private final SolutionP2473 solutionP2473 = new SolutionP2473();

    @Test
    public void example1() {
        int n = 4;
        int[][] roads = UtUtils.stringToInts2("[[1,2,4],[2,3,2],[2,4,5],[3,4,1],[1,3,4]]");
        int[] appleCost = {56, 42, 102, 301};
        int k = 2;
        long[] expected = {54, 42, 48, 51};
        Assertions.assertArrayEquals(expected, solutionP2473.minCost(n, roads, appleCost, k));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] roads = UtUtils.stringToInts2("[[1,2,5],[2,3,1],[3,1,2]]");
        int[] appleCost = {2, 3, 1};
        int k = 3;
        long[] expected = {2, 3, 1};
        Assertions.assertArrayEquals(expected, solutionP2473.minCost(n, roads, appleCost, k));
    }
}