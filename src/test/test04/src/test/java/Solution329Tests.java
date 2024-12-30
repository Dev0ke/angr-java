import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution329Tests {
    private final Solution329 solution329 = new Solution329();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[9,9,4],[6,6,8],[2,1,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution329.longestIncreasingPath(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[3,4,5],[3,2,6],[2,2,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution329.longestIncreasingPath(matrix));
    }

    @Test
    public void example3() {
        int[][] matrix = UtUtils.stringToInts2("[[1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution329.longestIncreasingPath(matrix));
    }
}
