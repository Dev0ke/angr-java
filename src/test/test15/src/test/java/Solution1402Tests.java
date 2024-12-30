import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1402Tests {
    private final Solution1402 solution1402 = new Solution1402();

    @Test
    public void example1() {
        int[] satisfaction = {-1, -8, 0, 5, -9};
        int expected = 14;
        Assertions.assertEquals(expected, solution1402.maxSatisfaction(satisfaction));
    }

    @Test
    public void example2() {
        int[] satisfaction = {4, 3, 2};
        int expected = 20;
        Assertions.assertEquals(expected, solution1402.maxSatisfaction(satisfaction));
    }

    @Test
    public void example3() {
        int[] satisfaction = {-1, -4, -5};
        int expected = 0;
        Assertions.assertEquals(expected, solution1402.maxSatisfaction(satisfaction));
    }
}