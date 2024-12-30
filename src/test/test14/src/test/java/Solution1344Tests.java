import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1344Tests {
    private final Solution1344 solution1344 = new Solution1344();

    @Test
    public void example1() {
        int hour = 12;
        int minutes = 30;
        double expected = 165;
        Assertions.assertEquals(expected, solution1344.angleClock(hour, minutes));
    }

    @Test
    public void example2() {
        int hour = 3;
        int minutes = 30;
        double expected = 75;
        Assertions.assertEquals(expected, solution1344.angleClock(hour, minutes));
    }

    @Test
    public void example3() {
        int hour = 3;
        int minutes = 15;
        double expected = 7.5;
        Assertions.assertEquals(expected, solution1344.angleClock(hour, minutes));
    }

    @Test
    public void example4() {
        int hour = 4;
        int minutes = 50;
        double expected = 155;
        Assertions.assertEquals(expected, solution1344.angleClock(hour, minutes));
    }

    @Test
    public void example5() {
        int hour = 12;
        int minutes = 0;
        double expected = 0;
        Assertions.assertEquals(expected, solution1344.angleClock(hour, minutes));
    }
}