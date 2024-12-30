import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3143Tests {
    private final Solution3143 solution3143 = new Solution3143();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]]");
        String s = "abdca";
        int expected = 2;
        Assertions.assertEquals(expected, solution3143.maxPointsInsideSquare(points, s));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[-2,-2],[-2,2]]");
        String s = "abb";
        int expected = 1;
        Assertions.assertEquals(expected, solution3143.maxPointsInsideSquare(points, s));
    }

    @Test
    public void example3() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[-1,-1],[2,-2]]");
        String s = "ccd";
        int expected = 0;
        Assertions.assertEquals(expected, solution3143.maxPointsInsideSquare(points, s));
    }
}