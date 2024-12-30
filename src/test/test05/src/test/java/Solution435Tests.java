import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution435Tests {
    private final Solution435 solution435 = new Solution435();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[1,2],[2,3],[3,4],[1,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution435.eraseOverlapIntervals(intervals));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[ [1,2], [1,2], [1,2] ]");
        int expected = 2;
        Assertions.assertEquals(expected, solution435.eraseOverlapIntervals(intervals));
    }

    @Test
    public void example3() {
        int[][] intervals = UtUtils.stringToInts2("[ [1,2], [2,3] ]");
        int expected = 0;
        Assertions.assertEquals(expected, solution435.eraseOverlapIntervals(intervals));
    }
}
