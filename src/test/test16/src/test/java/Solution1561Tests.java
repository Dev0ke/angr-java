import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1561Tests {
    private final Solution1561 solution1561 = new Solution1561();

    @Test
    public void example1() {
        int[] piles = {2, 4, 1, 2, 7, 8};
        int expected = 9;
        Assertions.assertEquals(expected, solution1561.maxCoins(piles));
    }

    @Test
    public void example2() {
        int[] piles = {2, 4, 5};
        int expected = 4;
        Assertions.assertEquals(expected, solution1561.maxCoins(piles));
    }

    @Test
    public void example3() {
        int[] piles = {9, 8, 7, 6, 5, 1, 2, 3, 4};
        int expected = 18;
        Assertions.assertEquals(expected, solution1561.maxCoins(piles));
    }
}