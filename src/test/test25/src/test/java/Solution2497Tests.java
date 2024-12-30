import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2497Tests {
    private final Solution2497 solution2497 = new Solution2497();

    @Test
    public void example1() {
        int[] vals = {1, 2, 3, 4, 10, -10, -20};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[1,3],[3,4],[3,5],[3,6]]");
        int k = 2;
        int expected = 16;
        Assertions.assertEquals(expected, solution2497.maxStarSum(vals, edges, k));
    }

    @Test
    public void example2() {
        int[] vals = {-5};
        int[][] edges = UtUtils.stringToInts2("[]");
        int k = 0;
        int expected = -5;
        Assertions.assertEquals(expected, solution2497.maxStarSum(vals, edges, k));
    }
}
