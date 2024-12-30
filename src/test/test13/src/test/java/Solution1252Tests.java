import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1252Tests {
    private final Solution1252 solution1252 = new Solution1252();

    @Test
    public void example1() {
        int m = 2;
        int n = 3;
        int[][] indices = UtUtils.stringToInts2("[[0,1],[1,1]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution1252.oddCells(m, n, indices));
        Assertions.assertEquals(expected, solution1252.oddCells2(m, n, indices));
    }

    @Test
    public void example2() {
        int m = 2;
        int n = 2;
        int[][] indices = UtUtils.stringToInts2("[[1,1],[0,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1252.oddCells(m, n, indices));
        Assertions.assertEquals(expected, solution1252.oddCells2(m, n, indices));
    }
}