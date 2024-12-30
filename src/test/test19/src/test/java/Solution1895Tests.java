import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1895Tests {
    private final Solution1895 solution1895 = new Solution1895();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1895.largestMagicSquare(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[5,1,3,1],[9,3,3,1],[1,3,3,8]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1895.largestMagicSquare(grid));
    }
}