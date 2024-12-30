import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2556Tests {
    private final Solution2556 solution2556 = new Solution2556();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,0,0],[1,1,1]]");
        Assertions.assertTrue(solution2556.isPossibleToCutPath(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,0,1],[1,1,1]]");
        Assertions.assertFalse(solution2556.isPossibleToCutPath(grid));
    }
}