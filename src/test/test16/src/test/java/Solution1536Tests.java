import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1536Tests {
    private final Solution1536 solution1536 = new Solution1536();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,1],[1,1,0],[1,0,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1536.minSwaps(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution1536.minSwaps(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0],[1,1,0],[1,1,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1536.minSwaps(grid));
    }
}
