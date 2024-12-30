import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution463Tests {
    private final Solution463 solution463 = new Solution463();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]");
        int expected = 16;
        Assertions.assertEquals(expected, solution463.islandPerimeter(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution463.islandPerimeter(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,0]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution463.islandPerimeter(grid));
    }
}
