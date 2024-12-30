import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1266Tests {
    private final Solution1266 solution1266 = new Solution1266();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[3,4],[-1,0]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution1266.minTimeToVisitAllPoints(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[3,2],[-2,2]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution1266.minTimeToVisitAllPoints(points));
    }
}