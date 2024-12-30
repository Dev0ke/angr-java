import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1102Tests {
    private final SolutionP1102 solutionP1102 = new SolutionP1102();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[5,4,5],[1,2,6],[7,4,6]]");
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1102.maximumMinimumPath(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[2,2,1,2,2,2],[1,2,2,2,1,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1102.maximumMinimumPath(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1102.maximumMinimumPath(grid));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/245181706/
        // 76 / 85 个通过测试用例
        int[][] grid = UtUtils.loadingInts2("solution1102-example4-input.txt", 0);
        int expected = 3838890;
        Assertions.assertEquals(expected, solutionP1102.maximumMinimumPath(grid));
    }
}
