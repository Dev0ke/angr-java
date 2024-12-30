import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1414Tests {
    private final Solution1414 solution1414 = new Solution1414();

    @Test
    public void example1() {
        int k = 7;
        int expected = 2;
        Assertions.assertEquals(expected, solution1414.findMinFibonacciNumbers(k));
    }

    @Test
    public void example2() {
        int k = 10;
        int expected = 2;
        Assertions.assertEquals(expected, solution1414.findMinFibonacciNumbers(k));
    }

    @Test
    public void example3() {
        int k = 19;
        int expected = 3;
        Assertions.assertEquals(expected, solution1414.findMinFibonacciNumbers(k));
    }
}
