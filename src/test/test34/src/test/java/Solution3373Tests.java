import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3373Tests {
    private final Solution3373 solution3373 = new Solution3373();

    @Test
    public void example1() {
        int[][] edges1 = UtUtils.stringToInts2("[[0,1],[0,2],[2,3],[2,4]]");
        int[][] edges2 = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]");
        int[] expected = {8, 7, 7, 8, 8};
        Assertions.assertArrayEquals(expected, solution3373.maxTargetNodes(edges1, edges2));
    }

    @Test
    public void example2() {
        int[][] edges1 = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[0,4]]");
        int[][] edges2 = UtUtils.stringToInts2("[[0,1],[1,2],[2,3]]");
        int[] expected = {3, 6, 6, 6, 6};
        Assertions.assertArrayEquals(expected, solution3373.maxTargetNodes(edges1, edges2));
    }
}