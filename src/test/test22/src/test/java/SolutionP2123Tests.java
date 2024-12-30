import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2123Tests {
    private final SolutionP2123.V1 solutionP2123_v1 = new SolutionP2123.V1();
    private final SolutionP2123.V2 solutionP2123_v2 = new SolutionP2123.V2();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0],[0,1,1],[1,1,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2123_v1.minimumOperations(grid));
        Assertions.assertEquals(expected, solutionP2123_v2.minimumOperations(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,0],[0,0,0],[0,0,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2123_v1.minimumOperations(grid));
        Assertions.assertEquals(expected, solutionP2123_v2.minimumOperations(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[0,1],[1,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2123_v1.minimumOperations(grid));
        Assertions.assertEquals(expected, solutionP2123_v2.minimumOperations(grid));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/minimum-operations-to-remove-adjacent-ones-in-matrix/submissions/536064591/
        // 74 / 90 个通过的测试用例 MLE
        int[][] grid = UtUtils.loadingInts2("solution2123-example4-input.txt", 0);
        int expected = 18762;
//        Assertions.assertEquals(expected, solutionP2123_v1.minimumOperations(grid));
        Assertions.assertEquals(expected, solutionP2123_v2.minimumOperations(grid));
    }
}