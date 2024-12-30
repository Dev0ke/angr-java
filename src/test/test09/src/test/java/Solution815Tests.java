import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution815Tests {
    private final Solution815 solution815 = new Solution815();

    @Test
    public void example1() {
        int[][] routes = UtUtils.stringToInts2("[[1,2,7],[3,6,7]]");
        int source = 1;
        int target = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution815.numBusesToDestination(routes, source, target));
    }

    @Test
    public void example2() {
        int[][] routes = UtUtils.stringToInts2("[[7,12],[4,5,15],[6],[15,19],[9,12,13]]");
        int source = 15;
        int target = 12;
        int expected = -1;
        Assertions.assertEquals(expected, solution815.numBusesToDestination(routes, source, target));
    }
}
