import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2482Tests {
    private final Solution2482 solution2482 = new Solution2482();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,1],[1,0,1],[0,0,1]]");
        int[][] expected = UtUtils.stringToInts2("[[0,0,4],[0,0,4],[-2,-2,2]]");
        Assertions.assertArrayEquals(expected, solution2482.onesMinusZeros(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[5,5,5],[5,5,5]]");
        Assertions.assertArrayEquals(expected, solution2482.onesMinusZeros(grid));
    }
}
