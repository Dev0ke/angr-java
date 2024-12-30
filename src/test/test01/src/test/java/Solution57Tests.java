import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution57Tests {
    private final Solution57 solution57 = new Solution57();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[1,3],[6,9]]");
        int[] newInterval = {2, 5};
        int[][] expected = UtUtils.stringToInts2("[[1,5],[6,9]]");
        Assertions.assertArrayEquals(expected, solution57.insert(intervals, newInterval));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[[1,2],[3,5],[6,7],[8,10],[12,16]]");
        int[] newInterval = {4, 8};
        int[][] expected = UtUtils.stringToInts2("[[1,2],[3,10],[12,16]]");
        Assertions.assertArrayEquals(expected, solution57.insert(intervals, newInterval));
    }

    @Test
    public void example3() {
        int[][] intervals = UtUtils.stringToInts2("[]");
        int[] newInterval = {5, 7};
        int[][] expected = UtUtils.stringToInts2("[[5,7]]");
        Assertions.assertArrayEquals(expected, solution57.insert(intervals, newInterval));
    }

    @Test
    public void example4() {
        int[][] intervals = UtUtils.stringToInts2("[[1,5]]");
        int[] newInterval = {2, 3};
        int[][] expected = UtUtils.stringToInts2("[[1,5]]");
        Assertions.assertArrayEquals(expected, solution57.insert(intervals, newInterval));
    }

    @Test
    public void example5() {
        int[][] intervals = UtUtils.stringToInts2("[[1,5]]");
        int[] newInterval = {2, 7};
        int[][] expected = UtUtils.stringToInts2("[[1,7]]");
        Assertions.assertArrayEquals(expected, solution57.insert(intervals, newInterval));
    }
}
