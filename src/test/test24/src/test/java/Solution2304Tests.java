import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2304Tests {
    private final Solution2304 solution2304 = new Solution2304();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[5,3],[4,0],[2,1]]");
        int[][] moveCost = UtUtils.stringToInts2("[[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]");
        int expected = 17;
        Assertions.assertEquals(expected, solution2304.minPathCost(grid, moveCost));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[5,1,2],[4,0,3]]");
        int[][] moveCost = UtUtils.stringToInts2("[[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution2304.minPathCost(grid, moveCost));
    }
}
