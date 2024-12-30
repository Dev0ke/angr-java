import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution874Tests {
    private final Solution874 solution874 = new Solution874();

    @Test
    public void example1() {
        int[] commands = {4, -1, 3};
        int[][] obstacles = UtUtils.stringToInts2("[]");
        int expected = 25;
        Assertions.assertEquals(expected, solution874.robotSim(commands, obstacles));
    }

    @Test
    public void example2() {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = UtUtils.stringToInts2("[[2,4]]");
        int expected = 65;
        Assertions.assertEquals(expected, solution874.robotSim(commands, obstacles));
    }
}
