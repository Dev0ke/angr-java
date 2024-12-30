import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution338Tests {
    private final Solution338 solution338 = new Solution338();

    @Test
    public void example1() {
        int n = 2;
        int[] expected = {0, 1, 1};
        Assertions.assertArrayEquals(expected, solution338.countBits(n));
    }

    @Test
    public void example2() {
        int n = 5;
        int[] expected = {0, 1, 1, 2, 1, 2};
        Assertions.assertArrayEquals(expected, solution338.countBits(n));
    }
}
