import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1568Tests {
    private final Solution1568 solution1568 = new Solution1568();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,1,0],[0,1,1,0],[0,0,0,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1568.minDays(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1568.minDays(grid));
    }
}