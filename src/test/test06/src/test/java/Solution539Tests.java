import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution539Tests {
    private final Solution539 solution539 = new Solution539();

    @Test
    public void example1() {
        List<String> timePoints = List.of("23:59", "00:00");
        int expected = 1;
        Assertions.assertEquals(expected, solution539.findMinDifference(timePoints));
    }

    @Test
    public void example2() {
        List<String> timePoints = List.of("00:00", "23:59", "00:00");
        int expected = 0;
        Assertions.assertEquals(expected, solution539.findMinDifference(timePoints));
    }

    @Test
    public void example3() {
        List<String> timePoints = List.of("12:12", "00:13");
        int expected = 719;
        Assertions.assertEquals(expected, solution539.findMinDifference(timePoints));
    }
}
