import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2768Tests {
    private final Solution2768 solution2768 = new Solution2768();

    @Test
    public void example1() {
        int m = 3;
        int n = 3;
        int[][] coordinates = UtUtils.stringToInts2("[[0,0]]");
        long[] expected = {3, 1, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solution2768.countBlackBlocks(m, n, coordinates));
    }

    @Test
    public void example2() {
        int m = 3;
        int n = 3;
        int[][] coordinates = UtUtils.stringToInts2("[[0,0],[1,1],[0,2]]");
        long[] expected = {0, 2, 2, 0, 0};
        Assertions.assertArrayEquals(expected, solution2768.countBlackBlocks(m, n, coordinates));
    }
}