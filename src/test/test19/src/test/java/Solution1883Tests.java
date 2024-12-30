import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1883Tests {
    private final Solution1883 solution1883 = new Solution1883();

    @Test
    public void example1() {
        int[] dist = {1, 3, 2};
        int speed = 4;
        int hoursBefore = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution1883.minSkips(dist, speed, hoursBefore));
    }

    @Test
    public void example2() {
        int[] dist = {7, 3, 5, 5};
        int speed = 2;
        int hoursBefore = 10;
        int expected = 2;
        Assertions.assertEquals(expected, solution1883.minSkips(dist, speed, hoursBefore));
    }

    @Test
    public void example3() {
        int[] dist = {7, 3, 5, 5};
        int speed = 1;
        int hoursBefore = 10;
        int expected = -1;
        Assertions.assertEquals(expected, solution1883.minSkips(dist, speed, hoursBefore));
    }
}