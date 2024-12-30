import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1514Tests {
    private final Solution1514 solution1514 = new Solution1514();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[0,2]]");
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;
        double expected = 0.25000;
        Assertions.assertEquals(expected, solution1514.maxProbability(n, edges, succProb, start, end));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[0,2]]");
        double[] succProb = {0.5, 0.5, 0.3};
        int start = 0;
        int end = 2;
        double expected = 0.30000;
        Assertions.assertEquals(expected, solution1514.maxProbability(n, edges, succProb, start, end));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1]]");
        double[] succProb = {0.5};
        int start = 0;
        int end = 2;
        double expected = 0.00000;
        Assertions.assertEquals(expected, solution1514.maxProbability(n, edges, succProb, start, end));
    }
}
