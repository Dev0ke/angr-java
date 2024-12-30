import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1292Tests {
    private final Solution1292 solution1292 = new Solution1292();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]]");
        int threshold = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution1292.maxSideLength(mat, threshold));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]]");
        int threshold = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution1292.maxSideLength(mat, threshold));
    }

    @Test
    public void example3() {
        int[][] mat = {{1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        int threshold = 6;
        int expected = 3;
        Assertions.assertEquals(expected, solution1292.maxSideLength(mat, threshold));
    }

    @Test
    public void example4() {
        int[][] mat = {{18, 70}, {61, 1}, {25, 85}, {14, 40}, {11, 96}, {97, 96}, {63, 45}};
        int threshold = 40184;
        int expected = 2;
        Assertions.assertEquals(expected, solution1292.maxSideLength(mat, threshold));
    }
}
