import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution739Tests {
    private final Solution739 solution739 = new Solution739();

    @Test
    public void example1() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
        Assertions.assertArrayEquals(expected, solution739.dailyTemperatures(temperatures));
    }

    @Test
    public void example2() {
        int[] temperatures = {30, 40, 50, 60};
        int[] expected = {1, 1, 1, 0};
        Assertions.assertArrayEquals(expected, solution739.dailyTemperatures(temperatures));
    }

    @Test
    public void example3() {
        int[] temperatures = {30, 60, 90};
        int[] expected = {1, 1, 0};
        Assertions.assertArrayEquals(expected, solution739.dailyTemperatures(temperatures));
    }
}
