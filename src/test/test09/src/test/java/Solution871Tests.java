import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution871Tests {
    private final Solution871 solution871 = new Solution871();

    @Test
    public void example1() {
        int target = 1;
        int startFuel = 1;
        int[][] stations = UtUtils.stringToInts2("[]");
        int expected = 0;
        Assertions.assertEquals(expected, solution871.minRefuelStops(target, startFuel, stations));
    }

    @Test
    public void example2() {
        int target = 100;
        int startFuel = 1;
        int[][] stations = UtUtils.stringToInts2("[[10,100]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution871.minRefuelStops(target, startFuel, stations));
    }

    @Test
    public void example3() {
        int target = 100;
        int startFuel = 10;
        int[][] stations = UtUtils.stringToInts2("[[10,60],[20,30],[30,30],[60,40]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution871.minRefuelStops(target, startFuel, stations));
    }
}
