import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2132Tests {
    private final Solution2132 solution2132 = new Solution2132();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0,0],[1,0,0,0],[1,0,0,0],[1,0,0,0],[1,0,0,0]]");
        int stampHeight = 4;
        int stampWidth = 3;
        Assertions.assertTrue(solution2132.possibleToStamp(grid, stampHeight, stampWidth));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0,0],[0,1,0,0],[0,0,1,0],[0,0,0,1]]");
        int stampHeight = 2;
        int stampWidth = 2;
        Assertions.assertFalse(solution2132.possibleToStamp(grid, stampHeight, stampWidth));
    }
}
