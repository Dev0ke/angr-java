import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP308Tests {
    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]");
        SolutionP308.NumMatrix numMatrix = new SolutionP308.NumMatrix(matrix);

        // 返回 8 (即, 左侧红色矩形的和)
        Assertions.assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));

        // 矩阵从左图变为右图
        numMatrix.update(3, 2, 2);

        // 返回 10 (即，右侧红色矩形的和)
        Assertions.assertEquals(10, numMatrix.sumRegion(2, 1, 4, 3));
    }
}
