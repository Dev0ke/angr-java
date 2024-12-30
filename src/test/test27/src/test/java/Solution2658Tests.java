import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2658Tests {
    private final Solution2658 solution2658 = new Solution2658();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution2658.findMaxFish(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2658.findMaxFish(grid));
    }
}