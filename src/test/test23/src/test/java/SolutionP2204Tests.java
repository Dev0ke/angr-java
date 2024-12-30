import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2204Tests {
    private final SolutionP2204 solutionP2204 = new SolutionP2204();

    @Test
    public void example1() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[2,4],[4,3],[3,1],[0,1],[5,2],[6,5]]");
        int[] expected = {1, 0, 0, 0, 0, 1, 2};
        Assertions.assertArrayEquals(expected, solutionP2204.distanceToCycle(n, edges));
    }

    @Test
    public void example2() {
        int n = 9;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[0,2],[2,6],[6,7],[6,8],[0,3],[3,4],[3,5]]");
        int[] expected = {0, 0, 0, 1, 2, 2, 1, 2, 2};
        Assertions.assertArrayEquals(expected, solutionP2204.distanceToCycle(n, edges));
    }
}