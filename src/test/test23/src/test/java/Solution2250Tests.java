import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2250Tests {
    private final Solution2250 solution2250 = new Solution2250();

    @Test
    public void example1() {
        int[][] rectangles = UtUtils.stringToInts2("[[1,2],[2,3],[2,5]]");
        int[][] points = UtUtils.stringToInts2("[[2,1],[1,4]]");
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution2250.countRectangles(rectangles, points));
    }

    @Test
    public void example2() {
        int[][] rectangles = UtUtils.stringToInts2("[[1,1],[2,2],[3,3]]");
        int[][] points = UtUtils.stringToInts2("[[1,3],[1,1]]");
        int[] expected = {1, 3};
        Assertions.assertArrayEquals(expected, solution2250.countRectangles(rectangles, points));
    }
}
