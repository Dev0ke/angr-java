import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2368Tests {
    private final Solution2368 solution2368 = new Solution2368();

    @Test
    public void example1() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]]");
        int[] restricted = {4, 5};
        int expected = 4;
        Assertions.assertEquals(expected, solution2368.reachableNodes(n, edges, restricted));
    }

    @Test
    public void example2() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]]");
        int[] restricted = {4, 2, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution2368.reachableNodes(n, edges, restricted));
    }
}
