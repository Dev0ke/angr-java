import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2290Tests {
    private final Solution2290 solution2290 = new Solution2290();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,1],[1,1,0],[1,1,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2290.minimumObstacles(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution2290.minimumObstacles(grid));
    }
}
