import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2684Tests {
    private final Solution2684 solution2684 = new Solution2684();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2684.maxMoves(grid));
        Assertions.assertEquals(expected, solution2684.maxMoves2(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[3,2,4],[2,1,9],[1,1,7]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution2684.maxMoves(grid));
        Assertions.assertEquals(expected, solution2684.maxMoves2(grid));
    }
}