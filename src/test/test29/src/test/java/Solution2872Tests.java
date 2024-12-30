import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2872Tests {
    private final Solution2872 solution2872 = new Solution2872();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,2],[1,2],[1,3],[2,4]]");
        int[] values = {1, 8, 1, 4, 4};
        int k = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution2872.maxKDivisibleComponents(n, edges, values, k));
    }

    @Test
    public void example2() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]");
        int[] values = {3, 0, 6, 1, 5, 2, 1};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution2872.maxKDivisibleComponents(n, edges, values, k));
    }
}