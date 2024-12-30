import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3185Tests {
    private final Solution3185 solution3185 = new Solution3185();

    @Test
    public void example1() {
        int[] hours = {12, 12, 30, 24, 24};
        long expected = 2;
        Assertions.assertEquals(expected, solution3185.countCompleteDayPairs(hours));
    }

    @Test
    public void example2() {
        int[] hours = {72, 48, 24, 3};
        long expected = 3;
        Assertions.assertEquals(expected, solution3185.countCompleteDayPairs(hours));
    }
}