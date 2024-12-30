import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3275Tests {
    private final Solution3275 solution3275 = new Solution3275();

    @Test
    public void example1() {
        int[][] queries = UtUtils.stringToInts2("[[1,2],[3,4],[2,3],[-3,0]]");
        int k = 2;
        int[] expected = {-1, 7, 5, 3};
        Assertions.assertArrayEquals(expected, solution3275.resultsArray(queries, k));
    }

    @Test
    public void example2() {
        int[][] queries = UtUtils.stringToInts2("[[5,5],[4,4],[3,3]]");
        int k = 1;
        int[] expected = {10, 8, 6};
        Assertions.assertArrayEquals(expected, solution3275.resultsArray(queries, k));
    }
}