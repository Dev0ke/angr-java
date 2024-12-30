import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3203Tests {
    private final Solution3203 solution3203 = new Solution3203();

    @Test
    public void example1() {
        int[][] edges1 = UtUtils.stringToInts2("[[0,1],[0,2],[0,3]]");
        int[][] edges2 = UtUtils.stringToInts2("[[0,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3203.minimumDiameterAfterMerge(edges1, edges2));
    }

    @Test
    public void example2() {
        int[][] edges1 = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]");
        int[][] edges2 = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution3203.minimumDiameterAfterMerge(edges1, edges2));
    }
}