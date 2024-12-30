import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1210Tests {
    private final Solution1210 solution1210 = new Solution1210();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("""
                [[0,0,0,0,0,1],
                 [1,1,0,0,1,0],
                 [0,0,0,0,1,1],
                 [0,0,1,0,1,0],
                 [0,1,1,0,0,0],
                 [0,1,1,0,0,0]]
                """);
        int expected = 11;
        Assertions.assertEquals(expected, solution1210.minimumMoves(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("""
                [[0,0,1,1,1,1],
                 [0,0,0,0,1,1],
                 [1,1,0,0,0,1],
                 [1,1,1,0,0,1],
                 [1,1,1,0,0,1],
                 [1,1,1,0,0,0]]
                """);
        int expected = 9;
        Assertions.assertEquals(expected, solution1210.minimumMoves(grid));
    }
}
