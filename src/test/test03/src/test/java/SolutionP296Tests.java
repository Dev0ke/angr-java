import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP296Tests {
    private final SolutionP296 solutionP296 = new SolutionP296();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]");
        int expected = 6;
        Assertions.assertEquals(expected, solutionP296.minTotalDistance(grid));
        Assertions.assertEquals(expected, solutionP296.minTotalDistance2(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP296.minTotalDistance(grid));
        Assertions.assertEquals(expected, solutionP296.minTotalDistance2(grid));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/322203322/
        // 57 / 58 个通过测试用例 TLE
        int[][] grid = UtUtils.loadingInts2("solution296-example3-input.txt", 0);
        int expected = 4000000;
        Assertions.assertEquals(expected, solutionP296.minTotalDistance(grid));
    }
}
