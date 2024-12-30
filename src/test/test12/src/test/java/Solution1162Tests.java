import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1162Tests {
    private final Solution1162 solution1162 = new Solution1162();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,1],[0,0,0],[1,0,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1162.maxDistance(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0],[0,0,0],[0,0,0]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1162.maxDistance(grid));
    }
}
