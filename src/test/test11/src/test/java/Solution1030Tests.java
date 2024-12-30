import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1030Tests {
    private final Solution1030 solution1030 = new Solution1030();

    @Test
    public void example1() {
        int rows = 1;
        int cols = 2;
        int rCenter = 0;
        int cCenter = 0;
        int[][] expected = UtUtils.stringToInts2("[[0,0],[0,1]]");
        Assertions.assertArrayEquals(expected, solution1030.allCellsDistOrder(rows, cols, rCenter, cCenter));
    }

    @Test
    public void example2() {
        int rows = 2;
        int cols = 2;
        int rCenter = 0;
        int cCenter = 1;
        int[][] expected = UtUtils.stringToInts2("[[0,1],[0,0],[1,1],[1,0]]");
        Assertions.assertArrayEquals(expected, solution1030.allCellsDistOrder(rows, cols, rCenter, cCenter));
    }

    @Test
    public void example3() {
        int rows = 2;
        int cols = 3;
        int rCenter = 1;
        int cCenter = 2;
        int[][] expected = UtUtils.stringToInts2("[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]");
        Assertions.assertArrayEquals(expected, solution1030.allCellsDistOrder(rows, cols, rCenter, cCenter));
    }
}