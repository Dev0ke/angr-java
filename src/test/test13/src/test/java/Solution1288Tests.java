import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1288Tests {
    private final Solution1288 solution1288 = new Solution1288();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[1,4],[3,6],[2,8]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1288.removeCoveredIntervals(intervals));
    }
}