import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution63Tests {
    private final Solution63 solution63 = new Solution63();

    @Test
    public void example1() {
        int[][] obstacleGrid = UtUtils.stringToInts2("[[0,0,0],[0,1,0],[0,0,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution63.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    public void example2() {
        int[][] obstacleGrid = UtUtils.stringToInts2("[[0,1],[0,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution63.uniquePathsWithObstacles(obstacleGrid));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/236468959/
        int[][] obstacleGrid = UtUtils.stringToInts2("[[1,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution63.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/236469271/
        int[][] obstacleGrid = UtUtils.stringToInts2("[[0,0],[1,1],[0,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution63.uniquePathsWithObstacles(obstacleGrid));
    }
}
