import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution64Tests {
    private final Solution64 solution64 = new Solution64();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,3,1],[1,5,1],[4,2,1]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution64.minPathSum(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,3],[4,5,6]]");
        int expected = 12;
        Assertions.assertEquals(expected, solution64.minPathSum(grid));
    }
}
