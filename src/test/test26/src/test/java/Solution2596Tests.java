import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2596Tests {
    private final Solution2596 solution2596 = new Solution2596();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]");
        Assertions.assertTrue(solution2596.checkValidGrid(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,3,6],[5,8,1],[2,7,4]]");
        Assertions.assertFalse(solution2596.checkValidGrid(grid));
    }
}