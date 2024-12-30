import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2435Tests {
    private final Solution2435 solution2435 = new Solution2435();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[5,2,4],[3,0,5],[0,7,2]]");
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution2435.numberOfPaths(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,0]]");
        int k = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution2435.numberOfPaths(grid, k));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[7,3,4,9],[2,3,6,2],[2,3,7,0]]");
        int k = 1;
        int expected = 10;
        Assertions.assertEquals(expected, solution2435.numberOfPaths(grid, k));
    }
}
