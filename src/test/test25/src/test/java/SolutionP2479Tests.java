import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2479Tests {
    private final SolutionP2479 solutionP2479 = new SolutionP2479();

    @Test
    public void example1() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[1,4],[2,5]]");
        int[] values = {2, 8, 3, 6, 2, 5};
        long expected = 24;
        Assertions.assertEquals(expected, solutionP2479.maxXor(n, edges, values));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[] values = {4, 6, 1};
        long expected = 0;
        Assertions.assertEquals(expected, solutionP2479.maxXor(n, edges, values));
    }
}