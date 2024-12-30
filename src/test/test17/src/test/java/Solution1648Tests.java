import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1648Tests {
    private final Solution1648.V2 solution1648_v2 = new Solution1648.V2();
    private final Solution1648 solution1648 = new Solution1648();

    @Test
    public void example1() {
        int[] inventory = {2, 5};
        int orders = 4;
        int expected = 14;
        Assertions.assertEquals(expected, solution1648_v2.maxProfit(inventory, orders));
        Assertions.assertEquals(expected, solution1648.maxProfit(inventory, orders));
    }

    @Test
    public void example2() {
        int[] inventory = {3, 5};
        int orders = 6;
        int expected = 19;
        Assertions.assertEquals(expected, solution1648_v2.maxProfit(inventory, orders));
        Assertions.assertEquals(expected, solution1648.maxProfit(inventory, orders));
    }

    @Test
    public void example3() {
        int[] inventory = {2, 8, 4, 10, 6};
        int orders = 20;
        int expected = 110;
        Assertions.assertEquals(expected, solution1648_v2.maxProfit(inventory, orders));
        Assertions.assertEquals(expected, solution1648.maxProfit(inventory, orders));
    }

    @Test
    public void example4() {
        int[] inventory = {1000000000};
        int orders = 1000000000;
        int expected = 21;
        Assertions.assertEquals(expected, solution1648_v2.maxProfit(inventory, orders));
        Assertions.assertEquals(expected, solution1648.maxProfit(inventory, orders));
    }
}
