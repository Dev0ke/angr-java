import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2595Tests {
    private final Solution2595 solution2595 = new Solution2595();

    @Test
    public void example1() {
        int n = 17;
        int[] expected = {2, 0};
        Assertions.assertArrayEquals(expected, solution2595.evenOddBit(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution2595.evenOddBit(n));
    }
}