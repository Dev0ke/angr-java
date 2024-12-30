import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2925Tests {
    private final Solution2925 solution2925 = new Solution2925();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[2,4],[4,5]]");
        int[] values = {5, 2, 5, 2, 1, 1};
        long expected = 11;
        Assertions.assertEquals(expected, solution2925.maximumScoreAfterOperations(edges, values));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]");
        int[] values = {20, 10, 9, 7, 4, 3, 5};
        long expected = 40;
        Assertions.assertEquals(expected, solution2925.maximumScoreAfterOperations(edges, values));
    }
}