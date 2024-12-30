import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution849Tests {
    private final Solution849 solution849 = new Solution849();

    @Test
    public void example1() {
        int[] seats = {1, 0, 0, 0, 1, 0, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution849.maxDistToClosest(seats));
    }

    @Test
    public void example2() {
        int[] seats = {1, 0, 0, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solution849.maxDistToClosest(seats));
    }

    @Test
    public void example3() {
        int[] seats = {0, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution849.maxDistToClosest(seats));
    }
}
