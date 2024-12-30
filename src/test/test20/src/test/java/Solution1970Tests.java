import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1970Tests {
    private final Solution1970 solution1970 = new Solution1970();

    @Test
    public void example1() {
        int row = 2;
        int col = 2;
        int[][] cells = UtUtils.stringToInts2("[[1,1],[2,1],[1,2],[2,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1970.latestDayToCross(row, col, cells));
    }

    @Test
    public void example2() {
        int row = 2;
        int col = 2;
        int[][] cells = UtUtils.stringToInts2("[[1,1],[1,2],[2,1],[2,2]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1970.latestDayToCross(row, col, cells));
    }

    @Test
    public void example3() {
        int row = 3;
        int col = 3;
        int[][] cells = UtUtils.stringToInts2("[[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1970.latestDayToCross(row, col, cells));
    }
}
