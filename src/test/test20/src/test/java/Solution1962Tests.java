import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1962Tests {
    private final Solution1962 solution1962 = new Solution1962();

    @Test
    public void example1() {
        int[] piles = {5, 4, 9};
        int k = 2;
        int expected = 12;
        Assertions.assertEquals(expected, solution1962.minStoneSum(piles, k));
    }

    @Test
    public void example2() {
        int[] piles = {4, 3, 6, 7};
        int k = 3;
        int expected = 12;
        Assertions.assertEquals(expected, solution1962.minStoneSum(piles, k));
    }
}
