import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution892Tests {
    private final Solution892 solution892 = new Solution892();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int expected = 34;
        Assertions.assertEquals(expected, solution892.surfaceArea(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,0,1],[1,1,1]]");
        int expected = 32;
        Assertions.assertEquals(expected, solution892.surfaceArea(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[2,2,2],[2,1,2],[2,2,2]]");
        int expected = 46;
        Assertions.assertEquals(expected, solution892.surfaceArea(grid));
    }
}