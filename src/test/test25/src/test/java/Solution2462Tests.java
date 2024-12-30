import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2462Tests {
    private final Solution2462 solution2462 = new Solution2462();

    @Test
    public void example1() {
        int[] costs = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k = 3;
        int candidates = 4;
        long expected = 11;
        Assertions.assertEquals(expected, solution2462.totalCost(costs, k, candidates));
    }

    @Test
    public void example2() {
        int[] costs = {1, 2, 4, 1};
        int k = 3;
        int candidates = 3;
        long expected = 4;
        Assertions.assertEquals(expected, solution2462.totalCost(costs, k, candidates));
    }
}
