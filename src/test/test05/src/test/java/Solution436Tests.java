import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution436Tests {
    private final Solution436 solution436 = new Solution436();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[1,2]]");
        int[] expected = {-1};
        Assertions.assertArrayEquals(expected, solution436.findRightInterval(intervals));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[[3,4],[2,3],[1,2]]");
        int[] expected = {-1, 0, 1};
        Assertions.assertArrayEquals(expected, solution436.findRightInterval(intervals));
    }

    @Test
    public void example3() {
        int[][] intervals = UtUtils.stringToInts2("[[1,4],[2,3],[3,4]]");
        int[] expected = {-1, 2, -1};
        Assertions.assertArrayEquals(expected, solution436.findRightInterval(intervals));
    }
}
