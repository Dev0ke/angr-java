import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2392Tests {
    private final Solution2392 solution2392 = new Solution2392();

    @Test
    public void example1() {
        int k = 3;
        int[][] rowConditions = UtUtils.stringToInts2("[[1,2],[3,2]]");
        int[][] colConditions = UtUtils.stringToInts2("[[2,1],[3,2]]");
        // 答案不唯一
//        int[][] expected = UtUtils.stringToInts2("[[3,0,0],[0,0,1],[0,2,0]]");
        int[][] expected = UtUtils.stringToInts2("[[0,0,1],[3,0,0],[0,2,0]]");
        Assertions.assertArrayEquals(expected, solution2392.buildMatrix(k, rowConditions, colConditions));
    }

    @Test
    public void example2() {
        int k = 3;
        int[][] rowConditions = UtUtils.stringToInts2("[[1,2],[2,3],[3,1],[2,3]]");
        int[][] colConditions = UtUtils.stringToInts2("[[2,1]]");
        int[][] expected = UtUtils.stringToInts2("[]");
        Assertions.assertArrayEquals(expected, solution2392.buildMatrix(k, rowConditions, colConditions));
    }
}
