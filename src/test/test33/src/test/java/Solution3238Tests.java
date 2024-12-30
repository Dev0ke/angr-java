import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3238Tests {
    private final Solution3238 solution3238 = new Solution3238();

    @Test
    public void example1() {
        int n = 4;
        int[][] pick = UtUtils.stringToInts2("[[0,0],[1,0],[1,0],[2,1],[2,1],[2,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3238.winningPlayerCount(n, pick));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] pick = UtUtils.stringToInts2("[[1,1],[1,2],[1,3],[1,4]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution3238.winningPlayerCount(n, pick));
    }

    @Test
    public void example3() {
        int n = 5;
        int[][] pick = UtUtils.stringToInts2("[[1,1],[2,4],[2,4],[2,4]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3238.winningPlayerCount(n, pick));
    }
}