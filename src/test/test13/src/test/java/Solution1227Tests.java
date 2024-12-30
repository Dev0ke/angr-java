import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1227Tests {
    private final Solution1227 solution1227 = new Solution1227();

    @Test
    public void example1() {
        int n = 1;
        double expected = 1.00000;
        Assertions.assertEquals(expected, solution1227.nthPersonGetsNthSeat(n));
    }

    @Test
    public void example2() {
        int n = 2;
        double expected = 0.50000;
        Assertions.assertEquals(expected, solution1227.nthPersonGetsNthSeat(n));
    }
}