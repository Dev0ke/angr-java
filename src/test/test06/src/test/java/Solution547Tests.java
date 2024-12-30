import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution547Tests {
    private final Solution547 solution547 = new Solution547();

    @Test
    public void example1() {
        int[][] isConnected = UtUtils.stringToInts2("[[1,1,0],[1,1,0],[0,0,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution547.findCircleNum(isConnected));
    }

    @Test
    public void example2() {
        int[][] isConnected = UtUtils.stringToInts2("[[1,0,0],[0,1,0],[0,0,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution547.findCircleNum(isConnected));
    }
}
