import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2017Tests {
    private final Solution2017 solution2017 = new Solution2017();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[2,5,4],[1,5,1]]");
        long expected = 4;
        Assertions.assertEquals(expected, solution2017.gridGame(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[3,3,1],[8,5,2]]");
        long expected = 4;
        Assertions.assertEquals(expected, solution2017.gridGame(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,3,1,15],[1,3,3,1]]");
        long expected = 7;
        Assertions.assertEquals(expected, solution2017.gridGame(grid));
    }
}
