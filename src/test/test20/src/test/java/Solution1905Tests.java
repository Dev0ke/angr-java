import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1905Tests {
    private final Solution1905 solution1905 = new Solution1905();

    @Test
    public void example1() {
        int[][] grid1 = UtUtils.stringToInts2("[[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]");
        int[][] grid2 = UtUtils.stringToInts2("[[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1905.countSubIslands(grid1, grid2));
    }

    @Test
    public void example2() {
        int[][] grid1 = UtUtils.stringToInts2("[[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]");
        int[][] grid2 = UtUtils.stringToInts2("[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1905.countSubIslands(grid1, grid2));
    }
}
