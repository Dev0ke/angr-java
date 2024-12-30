import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3128Tests {
    private final Solution3128 solution3128 = new Solution3128();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,0],[0,1,1],[0,1,0]]");
        long expected = 2;
        Assertions.assertEquals(expected, solution3128.numberOfRightTriangles(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0,0],[0,1,0,1],[1,0,0,0]]");
        long expected = 0;
        Assertions.assertEquals(expected, solution3128.numberOfRightTriangles(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,1],[1,0,0],[1,0,0]]");
        long expected = 2;
        Assertions.assertEquals(expected, solution3128.numberOfRightTriangles(grid));
    }
}