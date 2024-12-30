import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution518Tests {
    private final Solution518 solution518 = new Solution518();

    @Test
    public void example1() {
        int amount = 5;
        int[] coins = {1, 2, 5};
        int expected = 4;
        Assertions.assertEquals(expected, solution518.change(amount, coins));
    }

    @Test
    public void example2() {
        int amount = 3;
        int[] coins = {2};
        int expected = 0;
        Assertions.assertEquals(expected, solution518.change(amount, coins));
    }

    @Test
    public void example3() {
        int amount = 10;
        int[] coins = {10};
        int expected = 1;
        Assertions.assertEquals(expected, solution518.change(amount, coins));
    }
}
