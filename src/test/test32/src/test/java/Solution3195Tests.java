import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3195Tests {
    private final Solution3195 solution3195 = new Solution3195();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,0],[1,0,1]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution3195.minimumArea(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,0],[1,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3195.minimumArea(grid));
    }
}