import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution517Tests {
    private final Solution517 solution517 = new Solution517();

    @Test
    public void example1() {
        int[] machines = {1, 0, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution517.findMinMoves(machines));
    }

    @Test
    public void example2() {
        int[] machines = {0, 3, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution517.findMinMoves(machines));
    }

    @Test
    public void example3() {
        int[] machines = {0, 2, 0};
        int expected = -1;
        Assertions.assertEquals(expected, solution517.findMinMoves(machines));
    }
}