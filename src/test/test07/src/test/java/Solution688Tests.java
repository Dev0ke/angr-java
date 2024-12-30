import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution688Tests {
    private final Solution688 solution688 = new Solution688();

    @Test
    public void example1() {
        int n = 3;
        int k = 2;
        int row = 0;
        int column = 0;
        double expected = 0.0625;
        Assertions.assertEquals(expected, solution688.knightProbability(n, k, row, column));
    }

    @Test
    public void example2() {
        int n = 1;
        int k = 0;
        int row = 0;
        int column = 0;
        double expected = 1.00000;
        Assertions.assertEquals(expected, solution688.knightProbability(n, k, row, column));
    }
}
