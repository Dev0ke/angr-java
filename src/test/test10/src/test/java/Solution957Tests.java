import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution957Tests {
    private final Solution957 solution957 = new Solution957();

    @Test
    public void example1() {
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int n = 7;
        int[] expected = {0, 0, 1, 1, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solution957.prisonAfterNDays(cells, n));
    }

    @Test
    public void example2() {
        int[] cells = {1, 0, 0, 1, 0, 0, 1, 0};
        int n = 1000000000;
        int[] expected = {0, 0, 1, 1, 1, 1, 1, 0};
        Assertions.assertArrayEquals(expected, solution957.prisonAfterNDays(cells, n));
    }
}
