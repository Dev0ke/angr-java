import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1453Tests {
    private final Solution1453 solution1453 = new Solution1453();

    @Test
    public void example1() {
        int[][] darts = UtUtils.stringToInts2("[[-2,0],[2,0],[0,2],[0,-2]]");
        int r = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution1453.numPoints(darts, r));
    }

    @Test
    public void example2() {
        int[][] darts = UtUtils.stringToInts2("[[-3,0],[3,0],[2,6],[5,4],[0,9],[7,8]]");
        int r = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solution1453.numPoints(darts, r));
    }
}