import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1686Tests {
    private final Solution1686 solution1686 = new Solution1686();

    @Test
    public void example1() {
        int[] aliceValues = {1, 3};
        int[] bobValues = {2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1686.stoneGameVI(aliceValues, bobValues));
    }

    @Test
    public void example2() {
        int[] aliceValues = {1, 2};
        int[] bobValues = {3, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution1686.stoneGameVI(aliceValues, bobValues));
    }

    @Test
    public void example3() {
        int[] aliceValues = {2, 4, 3};
        int[] bobValues = {1, 6, 7};
        int expected = -1;
        Assertions.assertEquals(expected, solution1686.stoneGameVI(aliceValues, bobValues));
    }
}