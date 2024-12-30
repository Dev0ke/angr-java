import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1798Tests {
    private final Solution1798 solution1798 = new Solution1798();

    @Test
    public void example1() {
        int[] coins = {1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution1798.getMaximumConsecutive(coins));
    }

    @Test
    public void example2() {
        int[] coins = {1, 1, 1, 4};
        int expected = 8;
        Assertions.assertEquals(expected, solution1798.getMaximumConsecutive(coins));
    }

    @Test
    public void example3() {
        int[] coins = {1, 4, 10, 3, 1};
        int expected = 20;
        Assertions.assertEquals(expected, solution1798.getMaximumConsecutive(coins));
    }
}
