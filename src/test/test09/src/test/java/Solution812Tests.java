import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution812Tests {
    private final Solution812 solution812 = new Solution812();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[0,0],[0,1],[1,0],[0,2],[2,0]]");
        double expected = 2;
        Assertions.assertEquals(expected, solution812.largestTriangleArea(points));
    }
}
