import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2952Tests {
    private final Solution2952 solution2952 = new Solution2952();

    @Test
    public void example1() {
        int[] coins = {1, 4, 10};
        int target = 19;
        int expected = 2;
        Assertions.assertEquals(expected, solution2952.minimumAddedCoins(coins, target));
    }

    @Test
    public void example2() {
        int[] coins = {1, 4, 10, 5, 7, 19};
        int target = 19;
        int expected = 1;
        Assertions.assertEquals(expected, solution2952.minimumAddedCoins(coins, target));
    }

    @Test
    public void example3() {
        int[] coins = {1, 1, 1};
        int target = 20;
        int expected = 3;
        Assertions.assertEquals(expected, solution2952.minimumAddedCoins(coins, target));
    }
}