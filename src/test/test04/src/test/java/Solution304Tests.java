import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution304Tests {
    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]");
        Solution304.NumMatrix numMatrix = new Solution304.NumMatrix(matrix);
        // return 8 (红色矩形框的元素总和)
        Assertions.assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
        // return 11 (绿色矩形框的元素总和)
        Assertions.assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2));
        // return 12 (蓝色矩形框的元素总和)
        Assertions.assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4));
    }
}
