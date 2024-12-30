import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution947Tests {
    private final Solution947 solution947 = new Solution947();

    @Test
    public void example1() {
        int[][] stones = UtUtils.stringToInts2("[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution947.removeStones(stones));
    }

    @Test
    public void example2() {
        int[][] stones = UtUtils.stringToInts2("[[0,0],[0,2],[1,1],[2,0],[2,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution947.removeStones(stones));
    }

    @Test
    public void example3() {
        int[][] stones = UtUtils.stringToInts2("[[0,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution947.removeStones(stones));
    }
}
