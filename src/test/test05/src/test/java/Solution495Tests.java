import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution495Tests {
    private final Solution495 solution495 = new Solution495();

    @Test
    public void example1() {
        int[] timeSeries = {1, 4};
        int duration = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution495.findPoisonedDuration(timeSeries, duration));
    }

    @Test
    public void example2() {
        int[] timeSeries = {1, 2};
        int duration = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution495.findPoisonedDuration(timeSeries, duration));
    }
}
