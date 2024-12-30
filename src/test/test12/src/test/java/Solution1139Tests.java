import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1139Tests {
    private final Solution1139 solution1139 = new Solution1139();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,0,1],[1,1,1]]");
        int expected = 9;
        Assertions.assertEquals(expected, solution1139.largest1BorderedSquare(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1139.largest1BorderedSquare(grid));
    }
}