import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution885Tests {
    private final Solution885 solution885 = new Solution885();

    @Test
    public void example1() {
        int rows = 1;
        int cols = 4;
        int rStart = 0;
        int cStart = 0;
        int[][] expected = UtUtils.stringToInts2("[[0,0],[0,1],[0,2],[0,3]]");
        Assertions.assertArrayEquals(expected, solution885.spiralMatrixIII(rows, cols, rStart, cStart));
    }

    @Test
    public void example2() {
        int rows = 5;
        int cols = 6;
        int rStart = 1;
        int cStart = 4;
        int[][] expected = UtUtils.stringToInts2("[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]");
        Assertions.assertArrayEquals(expected, solution885.spiralMatrixIII(rows, cols, rStart, cStart));
    }
}
