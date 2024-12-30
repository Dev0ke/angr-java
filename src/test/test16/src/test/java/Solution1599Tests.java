import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1599Tests {
    private final Solution1599 solution1599 = new Solution1599();

    @Test
    public void example1() {
        int[] customers = {8, 3};
        int boardingCost = 5;
        int runningCost = 6;
        int expected = 3;
        Assertions.assertEquals(expected, solution1599.minOperationsMaxProfit(customers, boardingCost, runningCost));
    }

    @Test
    public void example2() {
        int[] customers = {10, 9, 6};
        int boardingCost = 6;
        int runningCost = 4;
        int expected = 7;
        Assertions.assertEquals(expected, solution1599.minOperationsMaxProfit(customers, boardingCost, runningCost));
    }

    @Test
    public void example3() {
        int[] customers = {3, 4, 0, 5, 1};
        int boardingCost = 1;
        int runningCost = 92;
        int expected = -1;
        Assertions.assertEquals(expected, solution1599.minOperationsMaxProfit(customers, boardingCost, runningCost));
    }
}