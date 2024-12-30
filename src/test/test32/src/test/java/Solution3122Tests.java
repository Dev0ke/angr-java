import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3122Tests {
    private final Solution3122 solution3122 = new Solution3122();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,2],[1,0,2]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution3122.minimumOperations(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[0,0,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3122.minimumOperations(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1],[2],[3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3122.minimumOperations(grid));
    }
}