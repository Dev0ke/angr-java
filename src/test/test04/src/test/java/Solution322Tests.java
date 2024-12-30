import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution322Tests {
    private final Solution322 solution322 = new Solution322();

    @Test
    public void example1() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int expected = 3;
        Assertions.assertEquals(expected, solution322.coinChange(coins, amount));
    }

    @Test
    public void example2() {
        int[] coins = {2};
        int amount = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solution322.coinChange(coins, amount));
    }

    @Test
    public void example3() {
        int[] coins = {1};
        int amount = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution322.coinChange(coins, amount));
    }

    @Test
    public void example4() {
        int[] coins = {1};
        int amount = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution322.coinChange(coins, amount));
    }

    @Test
    public void example5() {
        int[] coins = {1};
        int amount = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution322.coinChange(coins, amount));
    }
}
