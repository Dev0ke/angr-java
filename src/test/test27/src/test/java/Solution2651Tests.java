import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2651Tests {
    private final Solution2651 solution2651 = new Solution2651();

    @Test
    public void example1() {
        int arrivalTime = 15;
        int delayedTime = 5;
        int expected = 20;
        Assertions.assertEquals(expected, solution2651.findDelayedArrivalTime(arrivalTime, delayedTime));
    }

    @Test
    public void example2() {
        int arrivalTime = 13;
        int delayedTime = 11;
        int expected = 0;
        Assertions.assertEquals(expected, solution2651.findDelayedArrivalTime(arrivalTime, delayedTime));
    }
}