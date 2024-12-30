import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1463Tests {
    private final Solution1463 solution1463 = new Solution1463();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[3,1,1],[2,5,1],[1,5,5],[2,1,1]]");
        int expected = 24;
        Assertions.assertEquals(expected, solution1463.cherryPickup(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]");
        int expected = 28;
        Assertions.assertEquals(expected, solution1463.cherryPickup(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]");
        int expected = 22;
        Assertions.assertEquals(expected, solution1463.cherryPickup(grid));
    }

    @Test
    public void example4() {
        int[][] grid = UtUtils.stringToInts2("[[1,1],[1,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1463.cherryPickup(grid));
    }
}
