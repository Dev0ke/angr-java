import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2672Tests {
    private final Solution2672 solution2672 = new Solution2672();

    @Test
    public void example1() {
        int n = 4;
        int[][] queries = UtUtils.stringToInts2("[[0,2],[1,2],[3,1],[1,1],[2,1]]");
        int[] expected = {0, 1, 1, 0, 2};
        Assertions.assertArrayEquals(expected, solution2672.colorTheArray(n, queries));
    }

    @Test
    public void example2() {
        int n = 1;
        int[][] queries = UtUtils.stringToInts2("[[0,100000]]");
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution2672.colorTheArray(n, queries));
    }
}