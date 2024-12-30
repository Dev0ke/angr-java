import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution289Tests {
    private final Solution289 solution289 = new Solution289();

    @Test
    public void example1() {
        int[][] board = UtUtils.stringToInts2("[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]");
        int[][] expected = UtUtils.stringToInts2("[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]");
        solution289.gameOfLife(board);
        Assertions.assertArrayEquals(expected, board);
    }

    @Test
    public void example2() {
        int[][] board = UtUtils.stringToInts2("[[1,1],[1,0]]");
        int[][] expected = UtUtils.stringToInts2("[[1,1],[1,1]]");
        solution289.gameOfLife(board);
        Assertions.assertArrayEquals(expected, board);
    }
}
