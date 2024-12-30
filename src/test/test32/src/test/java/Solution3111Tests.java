import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3111Tests {
    private final Solution3111 solution3111 = new Solution3111();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[2,1],[1,0],[1,4],[1,8],[3,5],[4,6]]");
        int w = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3111.minRectanglesToCoverPoints(points, w));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[0,0],[1,1],[2,2],[3,3],[4,4],[5,5],[6,6]]");
        int w = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution3111.minRectanglesToCoverPoints(points, w));
    }

    @Test
    public void example3() {
        int[][] points = UtUtils.stringToInts2("[[2,3],[1,2]]");
        int w = 0;
        int expected = 2;
        Assertions.assertEquals(expected, solution3111.minRectanglesToCoverPoints(points, w));
    }
}