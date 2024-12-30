import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3372Tests {
    private final Solution3372 solution3372 = new Solution3372();

    @Test
    public void example1() {
        int[][] edges1 = UtUtils.stringToInts2("[[0,1],[0,2],[2,3],[2,4]]");
        int[][] edges2 = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]");
        int k = 2;
        int[] expected = {9, 7, 9, 8, 8};
        Assertions.assertArrayEquals(expected, solution3372.maxTargetNodes(edges1, edges2, k));
    }

    @Test
    public void example2() {
        int[][] edges1 = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[0,4]]");
        int[][] edges2 = UtUtils.stringToInts2("[[0,1],[1,2],[2,3]]");
        int k = 1;
        int[] expected = {6, 3, 3, 3, 3};
        Assertions.assertArrayEquals(expected, solution3372.maxTargetNodes(edges1, edges2, k));
    }
}