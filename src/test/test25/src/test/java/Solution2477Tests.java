import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2477Tests {
    private final Solution2477 solution2477 = new Solution2477();

    @Test
    public void example1() {
        int[][] roads = UtUtils.stringToInts2("[[0,1],[0,2],[0,3]]");
        int seats = 5;
        long expected = 3;
        Assertions.assertEquals(expected, solution2477.minimumFuelCost(roads, seats));
    }

    @Test
    public void example2() {
        int[][] roads = UtUtils.stringToInts2("[[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]]");
        int seats = 2;
        long expected = 7;
        Assertions.assertEquals(expected, solution2477.minimumFuelCost(roads, seats));
    }

    @Test
    public void example3() {
        int[][] roads = UtUtils.stringToInts2("[]");
        int seats = 1;
        long expected = 0;
        Assertions.assertEquals(expected, solution2477.minimumFuelCost(roads, seats));
    }
}
