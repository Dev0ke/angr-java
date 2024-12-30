import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2033Tests {
    private final Solution2033 solution2033 = new Solution2033();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[2,4],[6,8]]");
        int x = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution2033.minOperations(grid, x));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,5],[2,3]]");
        int x = 1;
        int expected = 5;
        Assertions.assertEquals(expected, solution2033.minOperations(grid, x));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int x = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution2033.minOperations(grid, x));
    }
}
