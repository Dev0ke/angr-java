import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1359Tests {
    private final Solution1359 solution1359 = new Solution1359();

    @Test
    public void example1() {
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1359.countOrders(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution1359.countOrders(n));
    }

    @Test
    public void example3() {
        int n = 3;
        int expected = 90;
        Assertions.assertEquals(expected, solution1359.countOrders(n));
    }
}