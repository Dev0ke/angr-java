import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1072Tests {
    private final Solution1072 solution1072 = new Solution1072();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[0,1],[1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1072.maxEqualRowsAfterFlips(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[0,1],[1,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1072.maxEqualRowsAfterFlips(matrix));
    }

    @Test
    public void example3() {
        int[][] matrix = UtUtils.stringToInts2("[[0,0,0],[0,0,1],[1,1,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1072.maxEqualRowsAfterFlips(matrix));
    }
}