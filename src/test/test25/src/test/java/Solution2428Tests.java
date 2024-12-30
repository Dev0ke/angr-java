import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2428Tests {
    private final Solution2428 solution2428 = new Solution2428();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]");
        int expected = 30;
        Assertions.assertEquals(expected, solution2428.maxSum(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int expected = 35;
        Assertions.assertEquals(expected, solution2428.maxSum(grid));
    }
}
