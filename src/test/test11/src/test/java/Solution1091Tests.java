import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1091Tests {
    private final Solution1091 solution1091 = new Solution1091();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1],[1,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1091.shortestPathBinaryMatrix(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,0],[1,1,0],[1,1,0]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1091.shortestPathBinaryMatrix(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0],[1,1,0],[1,1,0]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution1091.shortestPathBinaryMatrix(grid));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/227590936/
        // 87 / 88 个通过测试用例
        int[][] grid = UtUtils.stringToInts2("[[0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1091.shortestPathBinaryMatrix(grid));
    }
}
