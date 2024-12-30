import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2087Tests {
    private final Solution2087 solution2087 = new Solution2087();

    @Test
    public void example1() {
        int[] startPos = {1, 0};
        int[] homePos = {2, 3};
        int[] rowCosts = {5, 4, 3};
        int[] colCosts = {8, 2, 6, 7};
        int expected = 18;
        Assertions.assertEquals(expected, solution2087.minCost(startPos, homePos, rowCosts, colCosts));
    }

    @Test
    public void example2() {
        int[] startPos = {0, 0};
        int[] homePos = {0, 0};
        int[] rowCosts = {5};
        int[] colCosts = {26};
        int expected = 0;
        Assertions.assertEquals(expected, solution2087.minCost(startPos, homePos, rowCosts, colCosts));
    }
}
