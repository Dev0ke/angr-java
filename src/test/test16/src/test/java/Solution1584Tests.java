import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1584Tests {
    private final Solution1584 solution1584 = new Solution1584();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[0,0],[2,2],[3,10],[5,2],[7,0]]");
        int expected = 20;
        Assertions.assertEquals(expected, solution1584.minCostConnectPoints(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[3,12],[-2,5],[-4,1]]");
        int expected = 18;
        Assertions.assertEquals(expected, solution1584.minCostConnectPoints(points));
    }

    @Test
    public void example3() {
        int[][] points = UtUtils.stringToInts2("[[0,0],[1,1],[1,0],[-1,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1584.minCostConnectPoints(points));
    }

    @Test
    public void example4() {
        int[][] points = UtUtils.stringToInts2("[[-1000000,-1000000],[1000000,1000000]]");
        int expected = 4000000;
        Assertions.assertEquals(expected, solution1584.minCostConnectPoints(points));
    }

    @Test
    public void example5() {
        int[][] points = UtUtils.stringToInts2("[[0,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1584.minCostConnectPoints(points));
    }
}
