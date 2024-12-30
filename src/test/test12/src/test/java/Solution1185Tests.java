import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1185Tests {
    private final Solution1185 solution1185 = new Solution1185();

    @Test
    public void example1() {
        int day = 31;
        int month = 8;
        int year = 2019;
        String expected = "Saturday";
        Assertions.assertEquals(expected, solution1185.dayOfTheWeek(day, month, year));
        Assertions.assertEquals(expected, solution1185.dayOfTheWeek2(day, month, year));
    }

    @Test
    public void example2() {
        int day = 18;
        int month = 7;
        int year = 1999;
        String expected = "Sunday";
        Assertions.assertEquals(expected, solution1185.dayOfTheWeek(day, month, year));
        Assertions.assertEquals(expected, solution1185.dayOfTheWeek2(day, month, year));
    }

    @Test
    public void example3() {
        int day = 15;
        int month = 8;
        int year = 1993;
        String expected = "Sunday";
        Assertions.assertEquals(expected, solution1185.dayOfTheWeek(day, month, year));
        Assertions.assertEquals(expected, solution1185.dayOfTheWeek2(day, month, year));
    }
}
