import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1219Tests {
    private final Solution1219 solution1219 = new Solution1219();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,6,0],[5,8,7],[0,9,0]]");
        int expected = 24;
        Assertions.assertEquals(expected, solution1219.getMaximumGold(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]");
        int expected = 28;
        Assertions.assertEquals(expected, solution1219.getMaximumGold(grid));
    }
}
