import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3197Tests {
    private final Solution3197 solution3197 = new Solution3197();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,1],[1,1,1]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution3197.minimumSum(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,1,0],[0,1,0,1]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution3197.minimumSum(grid));
    }
}