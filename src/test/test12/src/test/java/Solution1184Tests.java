import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1184Tests {
    private final Solution1184 solution1184 = new Solution1184();

    @Test
    public void example1() {
        int[] distance = {1, 2, 3, 4};
        int start = 0;
        int destination = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1184.distanceBetweenBusStops(distance, start, destination));
    }

    @Test
    public void example2() {
        int[] distance = {1, 2, 3, 4};
        int start = 0;
        int destination = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution1184.distanceBetweenBusStops(distance, start, destination));
    }

    @Test
    public void example3() {
        int[] distance = {1, 2, 3, 4};
        int start = 0;
        int destination = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution1184.distanceBetweenBusStops(distance, start, destination));
    }
}
