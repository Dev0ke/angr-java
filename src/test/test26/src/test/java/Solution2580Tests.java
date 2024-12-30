import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2580Tests {
    private final Solution2580 solution2580 = new Solution2580();

    @Test
    public void example1() {
        int[][] ranges = UtUtils.stringToInts2("[[6,10],[5,15]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2580.countWays(ranges));
    }

    @Test
    public void example2() {
        int[][] ranges = UtUtils.stringToInts2("[[1,3],[10,20],[2,5],[4,8]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution2580.countWays(ranges));
    }
}