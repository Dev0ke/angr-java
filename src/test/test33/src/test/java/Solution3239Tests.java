import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3239Tests {
    private final Solution3239 solution3239 = new Solution3239();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0],[0,0,0],[0,0,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3239.minFlips(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,1],[0,1],[0,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3239.minFlips(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1],[0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution3239.minFlips(grid));
    }
}