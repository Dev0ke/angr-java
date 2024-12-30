import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution773Tests {
    private final Solution773 solution773 = new Solution773();

    @Test
    public void example1() {
        int[][] board = UtUtils.stringToInts2("[[1,2,3],[4,0,5]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution773.slidingPuzzle(board));
    }

    @Test
    public void example2() {
        int[][] board = UtUtils.stringToInts2("[[1,2,3],[5,4,0]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution773.slidingPuzzle(board));
    }

    @Test
    public void example3() {
        int[][] board = UtUtils.stringToInts2("[[4,1,2],[5,0,3]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution773.slidingPuzzle(board));
    }
}