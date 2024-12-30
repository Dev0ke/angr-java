import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2643Tests {
    private final Solution2643 solution2643 = new Solution2643();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[0,1],[1,0]]");
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution2643.rowAndMaximumOnes(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[0,0,0],[0,1,1]]");
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution2643.rowAndMaximumOnes(mat));
    }

    @Test
    public void example3() {
        int[][] mat = UtUtils.stringToInts2("[[0,0],[1,1],[0,0]]");
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution2643.rowAndMaximumOnes(mat));
    }
}