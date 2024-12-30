import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1275Tests {
    private final Solution1275 solution1275 = new Solution1275();

    @Test
    public void example1() {
        int[][] moves = UtUtils.stringToInts2("[[0,0],[2,0],[1,1],[2,1],[2,2]]");
        String expected = "A";
        Assertions.assertEquals(expected, solution1275.tictactoe(moves));
    }

    @Test
    public void example2() {
        int[][] moves = UtUtils.stringToInts2("[[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]");
        String expected = "B";
        Assertions.assertEquals(expected, solution1275.tictactoe(moves));
    }

    @Test
    public void example3() {
        int[][] moves = UtUtils.stringToInts2("[[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]");
        String expected = "Draw";
        Assertions.assertEquals(expected, solution1275.tictactoe(moves));
    }

    @Test
    public void example4() {
        int[][] moves = UtUtils.stringToInts2("[[0,0],[1,1]]");
        String expected = "Pending";
        Assertions.assertEquals(expected, solution1275.tictactoe(moves));
    }
}