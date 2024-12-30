import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1518Tests {
    private final Solution1518 solution1518 = new Solution1518();

    @Test
    public void example1() {
        int numBottles = 9;
        int numExchange = 3;
        int expected = 13;
        Assertions.assertEquals(expected, solution1518.numWaterBottles(numBottles, numExchange));
    }

    @Test
    public void example2() {
        int numBottles = 15;
        int numExchange = 4;
        int expected = 19;
        Assertions.assertEquals(expected, solution1518.numWaterBottles(numBottles, numExchange));
    }

    @Test
    public void example3() {
        int numBottles = 5;
        int numExchange = 5;
        int expected = 6;
        Assertions.assertEquals(expected, solution1518.numWaterBottles(numBottles, numExchange));
    }

    @Test
    public void example4() {
        int numBottles = 2;
        int numExchange = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1518.numWaterBottles(numBottles, numExchange));
    }
}
