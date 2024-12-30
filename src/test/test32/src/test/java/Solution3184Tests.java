import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3184Tests {
    private final Solution3184 solution3184 = new Solution3184();

    @Test
    public void example1() {
        int[] hours = {12, 12, 30, 24, 24};
        int expected = 2;
        Assertions.assertEquals(expected, solution3184.countCompleteDayPairs(hours));
    }

    @Test
    public void example2() {
        int[] hours = {72, 48, 24, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution3184.countCompleteDayPairs(hours));
    }
}