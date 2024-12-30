import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2277Tests {
    private final SolutionP2277 solutionP2277 = new SolutionP2277();

    @Test
    public void example1() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[1,4],[2,5],[2,6]]");
        int[][] query = UtUtils.stringToInts2("[[5,3,4],[5,3,6]]");
        int[] expected = {0, 2};
        Assertions.assertArrayEquals(expected, solutionP2277.closestNode(n, edges, query));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[][] query = UtUtils.stringToInts2("[[0,1,2]]");
        int[] expected = {1};
        Assertions.assertArrayEquals(expected, solutionP2277.closestNode(n, edges, query));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[][] query = UtUtils.stringToInts2("[[0,0,0]]");
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solutionP2277.closestNode(n, edges, query));
    }
}