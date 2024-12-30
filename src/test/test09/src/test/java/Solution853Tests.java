import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution853Tests {
    private final Solution853 solution853 = new Solution853();

    @Test
    public void example1() {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution853.carFleet(target, position, speed));
    }

    @Test
    public void example2() {
        int target = 10;
        int[] position = {3};
        int[] speed = {3};
        int expected = 1;
        Assertions.assertEquals(expected, solution853.carFleet(target, position, speed));
    }

    @Test
    public void example3() {
        int target = 100;
        int[] position = {0, 2, 4};
        int[] speed = {4, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution853.carFleet(target, position, speed));
    }
}
