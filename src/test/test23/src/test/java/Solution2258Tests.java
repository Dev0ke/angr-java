import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2258Tests {
    private final Solution2258 solution2258 = new Solution2258();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2258.maximumMinutes(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,0,0],[0,1,2,0],[0,2,0,0]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution2258.maximumMinutes(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,0],[2,2,0],[1,2,0]]");
        int expected = 1000000000;
        Assertions.assertEquals(expected, solution2258.maximumMinutes(grid));
    }

}
