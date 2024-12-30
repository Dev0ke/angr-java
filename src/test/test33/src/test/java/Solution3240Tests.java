import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3240Tests {
    private final Solution3240 solution3240 = new Solution3240();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0],[0,1,0],[0,0,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3240.minFlips(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,1],[0,1],[0,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3240.minFlips(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1],[1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3240.minFlips(grid));
    }
}