import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1727Tests {
    private final Solution1727 solution1727 = new Solution1727();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[0,0,1],[1,1,1],[1,0,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1727.largestSubmatrix(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,0,1,0,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1727.largestSubmatrix(matrix));
    }

    @Test
    public void example3() {
        int[][] matrix = UtUtils.stringToInts2("[[1,1,0],[1,0,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1727.largestSubmatrix(matrix));
    }

    @Test
    public void example4() {
        int[][] matrix = UtUtils.stringToInts2("[[0,0],[0,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1727.largestSubmatrix(matrix));
    }
}