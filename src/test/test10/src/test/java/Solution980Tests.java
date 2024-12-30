import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution980Tests {
    private final Solution980 solution980 = new Solution980();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution980.uniquePathsIII(grid));
        Assertions.assertEquals(expected, solution980.uniquePathsIII2(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0,0],[0,0,0,0],[0,0,0,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution980.uniquePathsIII(grid));
        Assertions.assertEquals(expected, solution980.uniquePathsIII2(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[0,1],[2,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution980.uniquePathsIII(grid));
        Assertions.assertEquals(expected, solution980.uniquePathsIII2(grid));
    }
}
