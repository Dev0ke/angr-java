import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2120Tests {
    private final Solution2120 solution2120 = new Solution2120();

    @Test
    public void example1() {
        int n = 3;
        int[] startPos = {0, 1};
        String s = "RRDDLU";
        int[] expected = {1, 5, 4, 3, 1, 0};
        Assertions.assertArrayEquals(expected, solution2120.executeInstructions(n, startPos, s));
    }

    @Test
    public void example2() {
        int n = 2;
        int[] startPos = {1, 1};
        String s = "LURD";
        int[] expected = {4, 1, 0, 0};
        Assertions.assertArrayEquals(expected, solution2120.executeInstructions(n, startPos, s));
    }

    @Test
    public void example3() {
        int n = 1;
        int[] startPos = {0, 0};
        String s = "LRUD";
        int[] expected = {0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solution2120.executeInstructions(n, startPos, s));
    }
}
