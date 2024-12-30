import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2536Tests {
    private final Solution2536 solution2536 = new Solution2536();

    @Test
    public void example1() {
        int n = 3;
        int[][] queries = UtUtils.stringToInts2("[[1,1,2,2],[0,0,1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[1,1,0],[1,2,1],[0,1,1]]");
        Assertions.assertArrayEquals(expected, solution2536.rangeAddQueries(n, queries));
    }

    @Test
    public void example2() {
        int n = 2;
        int[][] queries = UtUtils.stringToInts2("[[0,0,1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[1,1],[1,1]]");
        Assertions.assertArrayEquals(expected, solution2536.rangeAddQueries(n, queries));
    }
}
