import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1475Tests {
    private final Solution1475 solution1475 = new Solution1475();

    @Test
    public void example1() {
        int[] prices = {8, 4, 6, 2, 3};
        int[] expected = {4, 2, 4, 2, 3};
        Assertions.assertArrayEquals(expected, solution1475.finalPrices(prices));
    }

    @Test
    public void example2() {
        int[] prices = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(expected, solution1475.finalPrices(prices));
    }

    @Test
    public void example3() {
        int[] prices = {10, 1, 1, 6};
        int[] expected = {9, 0, 1, 6};
        Assertions.assertArrayEquals(expected, solution1475.finalPrices(prices));
    }
}
