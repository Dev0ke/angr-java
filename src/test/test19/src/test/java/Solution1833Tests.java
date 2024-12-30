import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1833Tests {
    private final Solution1833 solution1833 = new Solution1833();

    @Test
    public void example1() {
        int[] costs = {1, 3, 2, 4, 1};
        int coins = 7;
        int expected = 4;
        Assertions.assertEquals(expected, solution1833.maxIceCream(costs, coins));
    }

    @Test
    public void example2() {
        int[] costs = {10, 6, 8, 7, 7, 8};
        int coins = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solution1833.maxIceCream(costs, coins));
    }

    @Test
    public void example3() {
        int[] costs = {1, 6, 3, 1, 2, 5};
        int coins = 20;
        int expected = 6;
        Assertions.assertEquals(expected, solution1833.maxIceCream(costs, coins));
    }
}
