import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2551Tests {
    private final Solution2551 solution2551 = new Solution2551();

    @Test
    public void example1() {
        int[] weights = {1, 3, 5, 1};
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution2551.putMarbles(weights, k));
    }

    @Test
    public void example2() {
        int[] weights = {1, 3};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution2551.putMarbles(weights, k));
    }
}