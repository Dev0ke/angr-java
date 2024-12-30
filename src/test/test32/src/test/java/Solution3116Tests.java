import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3116Tests {
    private final Solution3116 solution3116 = new Solution3116();

    @Test
    public void example1() {
        int[] coins = {3, 6, 9};
        int k = 3;
        long expected = 9;
        Assertions.assertEquals(expected, solution3116.findKthSmallest(coins, k));
    }

    @Test
    public void example2() {
        int[] coins = {5, 2};
        int k = 7;
        long expected = 12;
        Assertions.assertEquals(expected, solution3116.findKthSmallest(coins, k));
    }
}