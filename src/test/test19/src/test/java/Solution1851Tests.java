import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1851Tests {
    private final Solution1851 solution1851 = new Solution1851();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[1,4],[2,4],[3,6],[4,4]]");
        int[] queries = {2, 3, 4, 5};
        int[] expected = {3, 3, 1, 4};
        Assertions.assertArrayEquals(expected, solution1851.minInterval(intervals, queries));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[[2,3],[2,5],[1,8],[20,25]]");
        int[] queries = {2, 19, 5, 22};
        int[] expected = {2, -1, 4, 6};
        Assertions.assertArrayEquals(expected, solution1851.minInterval(intervals, queries));
    }
}