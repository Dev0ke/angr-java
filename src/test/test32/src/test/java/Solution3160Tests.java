import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3160Tests {
    private final Solution3160 solution3160 = new Solution3160();

    @Test
    public void example1() {
        int limit = 4;
        int[][] queries = UtUtils.stringToInts2("[[1,4],[2,5],[1,3],[3,4]]");
        int[] expected = {1, 2, 2, 3};
        Assertions.assertArrayEquals(expected, solution3160.queryResults(limit, queries));
    }

    @Test
    public void example2() {
        int limit = 4;
        int[][] queries = UtUtils.stringToInts2("[[0,1],[1,2],[2,2],[3,4],[4,5]]");
        int[] expected = {1, 2, 2, 3, 4};
        Assertions.assertArrayEquals(expected, solution3160.queryResults(limit, queries));
    }
}