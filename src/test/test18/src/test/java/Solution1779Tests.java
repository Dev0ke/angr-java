import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1779Tests {
    private final Solution1779 solution1779 = new Solution1779();

    @Test
    public void example1() {
        int x = 3;
        int y = 4;
        int[][] points = UtUtils.stringToInts2("[[1,2],[3,1],[2,4],[2,3],[4,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1779.nearestValidPoint(x, y, points));
    }

    @Test
    public void example2() {
        int x = 3;
        int y = 4;
        int[][] points = UtUtils.stringToInts2("[[3,4]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1779.nearestValidPoint(x, y, points));
    }

    @Test
    public void example3() {
        int x = 3;
        int y = 4;
        int[][] points = UtUtils.stringToInts2("[[2,3]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution1779.nearestValidPoint(x, y, points));
    }
}
