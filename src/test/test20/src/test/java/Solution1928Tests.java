import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1928Tests {
    private final Solution1928 solution1928 = new Solution1928();

    @Test
    public void example1() {
        int maxTime = 30;
        int[][] edges = UtUtils.stringToInts2("[[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]]");
        int[] passingFees = {5, 1, 2, 20, 20, 3};
        int expected = 11;
        Assertions.assertEquals(expected, solution1928.minCost(maxTime, edges, passingFees));
    }

    @Test
    public void example2() {
        int maxTime = 29;
        int[][] edges = UtUtils.stringToInts2("[[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]]");
        int[] passingFees = {5, 1, 2, 20, 20, 3};
        int expected = 48;
        Assertions.assertEquals(expected, solution1928.minCost(maxTime, edges, passingFees));
    }

    @Test
    public void example3() {
        int maxTime = 25;
        int[][] edges = UtUtils.stringToInts2("[[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]]");
        int[] passingFees = {5, 1, 2, 20, 20, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution1928.minCost(maxTime, edges, passingFees));
    }
}
