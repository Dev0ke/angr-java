import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution909Tests {
    private final Solution909 solution909 = new Solution909();

    @Test
    public void example1() {
        int[][] board = UtUtils.stringToInts2("[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution909.snakesAndLadders(board));
    }

    @Test
    public void example2() {
        int[][] board = UtUtils.stringToInts2("[[-1,-1],[-1,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution909.snakesAndLadders(board));
    }
}
