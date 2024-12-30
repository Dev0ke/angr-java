import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1020Tests {
    private final Solution1020 solution1020 = new Solution1020();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1020.numEnclaves(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1020.numEnclaves(grid));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/266351793/
        // 51 / 57 个通过测试用例
        int[][] grid = UtUtils.loadingInts2("solution1020-example3-input.txt", 0);
        int expected = 17041;
        Assertions.assertEquals(expected, solution1020.numEnclaves(grid));
    }
}
