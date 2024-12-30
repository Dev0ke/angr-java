import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1267Tests {
    private final Solution1267 solution1267 = new Solution1267();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0],[0,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1267.countServers(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0],[1,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1267.countServers(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1267.countServers(grid));
    }
}
