import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1360Tests {
    private final Solution1360 solution1360 = new Solution1360();

    @Test
    public void example1() {
        String date1 = "2019-06-29";
        String date2 = "2019-06-30";
        int expected = 1;
        Assertions.assertEquals(expected, solution1360.daysBetweenDates(date1, date2));
    }

    @Test
    public void example2() {
        String date1 = "2020-01-15";
        String date2 = "2019-12-31";
        int expected = 15;
        Assertions.assertEquals(expected, solution1360.daysBetweenDates(date1, date2));
    }
}