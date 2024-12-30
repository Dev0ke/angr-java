import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1011Tests {
    private final Solution1011 solution1011 = new Solution1011();

    @Test
    public void example1() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int expected = 15;
        Assertions.assertEquals(expected, solution1011.shipWithinDays(weights, days));
    }

    @Test
    public void example2() {
        int[] weights = {3, 2, 2, 4, 1, 4};
        int days = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution1011.shipWithinDays(weights, days));
    }

    @Test
    public void example3() {
        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution1011.shipWithinDays(weights, days));
    }
}
