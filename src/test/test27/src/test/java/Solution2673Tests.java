import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2673Tests {
    private final Solution2673 solution2673 = new Solution2673();

    @Test
    public void example1() {
        int n = 7;
        int[] cost = {1, 5, 2, 2, 3, 3, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solution2673.minIncrements(n, cost));
    }

    @Test
    public void example2() {
        int n = 3;
        int[] cost = {5, 3, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution2673.minIncrements(n, cost));
    }
}