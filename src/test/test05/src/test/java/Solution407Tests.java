import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution407Tests {
    private final Solution407 solution407 = new Solution407();

    @Test
    public void example1() {
        int[][] heightMap = UtUtils.stringToInts2("[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution407.trapRainWater(heightMap));
    }

    @Test
    public void example2() {
        int[][] heightMap = UtUtils.stringToInts2("[[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]");
        int expected = 10;
        Assertions.assertEquals(expected, solution407.trapRainWater(heightMap));
    }
}
