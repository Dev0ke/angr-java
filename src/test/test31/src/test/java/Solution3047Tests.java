import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3047Tests {
    private final Solution3047 solution3047 = new Solution3047();

    @Test
    public void example1() {
        int[][] bottomLeft = UtUtils.stringToInts2("[[1,1],[2,2],[3,1]]");
        int[][] topRight = UtUtils.stringToInts2("[[3,3],[4,4],[6,6]]");
        long expected = 1;
        Assertions.assertEquals(expected, solution3047.largestSquareArea(bottomLeft, topRight));
    }

    @Test
    public void example2() {
        int[][] bottomLeft = UtUtils.stringToInts2("[[1,1],[2,2],[1,2]]");
        int[][] topRight = UtUtils.stringToInts2("[[3,3],[4,4],[3,4]]");
        long expected = 1;
        Assertions.assertEquals(expected, solution3047.largestSquareArea(bottomLeft, topRight));
    }

    @Test
    public void example3() {
        int[][] bottomLeft = UtUtils.stringToInts2("[[1,1],[3,3],[3,1]]");
        int[][] topRight = UtUtils.stringToInts2("[[2,2],[4,4],[4,2]]");
        long expected = 0;
        Assertions.assertEquals(expected, solution3047.largestSquareArea(bottomLeft, topRight));
    }
}