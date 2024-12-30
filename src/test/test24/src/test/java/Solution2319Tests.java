import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2319Tests {
    private final Solution2319 solution2319 = new Solution2319();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]");
        Assertions.assertTrue(solution2319.checkXMatrix(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[5,7,0],[0,3,1],[0,5,0]]");
        Assertions.assertFalse(solution2319.checkXMatrix(grid));
    }
}
