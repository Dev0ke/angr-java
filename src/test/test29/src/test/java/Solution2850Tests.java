import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2850Tests {
    private final Solution2850.V1 solution2850_v1 = new Solution2850.V1();
    private final Solution2850.V2 solution2850_v2 = new Solution2850.V2();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0],[1,1,1],[1,2,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2850_v1.minimumMoves(grid));
        Assertions.assertEquals(expected, solution2850_v2.minimumMoves(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,3,0],[1,0,0],[1,0,3]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution2850_v1.minimumMoves(grid));
        Assertions.assertEquals(expected, solution2850_v2.minimumMoves(grid));
    }
}