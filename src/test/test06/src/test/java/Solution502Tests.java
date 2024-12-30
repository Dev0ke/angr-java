import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution502Tests {
    private final Solution502 solution502 = new Solution502();

    @Test
    public void example1() {
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution502.findMaximizedCapital(k, w, profits, capital));
    }

    @Test
    public void example2() {
        int k = 3;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 2};
        int expected = 6;
        Assertions.assertEquals(expected, solution502.findMaximizedCapital(k, w, profits, capital));
    }
}
