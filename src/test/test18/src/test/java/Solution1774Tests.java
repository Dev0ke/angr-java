import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1774Tests {
    private final Solution1774 solution1774 = new Solution1774();

    @Test
    public void example1() {
        int[] baseCosts = {1, 7};
        int[] toppingCosts = {3, 4};
        int target = 10;
        int expected = 10;
        Assertions.assertEquals(expected, solution1774.closestCost(baseCosts, toppingCosts, target));
    }

    @Test
    public void example2() {
        int[] baseCosts = {2, 3};
        int[] toppingCosts = {4, 5, 100};
        int target = 18;
        int expected = 17;
        Assertions.assertEquals(expected, solution1774.closestCost(baseCosts, toppingCosts, target));
    }

    @Test
    public void example3() {
        int[] baseCosts = {3, 10};
        int[] toppingCosts = {2, 5};
        int target = 9;
        int expected = 8;
        Assertions.assertEquals(expected, solution1774.closestCost(baseCosts, toppingCosts, target));
    }

    @Test
    public void example4() {
        int[] baseCosts = {10};
        int[] toppingCosts = {1};
        int target = 1;
        int expected = 10;
        Assertions.assertEquals(expected, solution1774.closestCost(baseCosts, toppingCosts, target));
    }
}
