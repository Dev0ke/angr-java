import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1579Tests {
    private final Solution1579 solution1579 = new Solution1579();

    @Test
    public void example1() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1579.maxNumEdgesToRemove(n, edges));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[3,1,2],[3,2,3],[1,1,4],[2,1,4]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1579.maxNumEdgesToRemove(n, edges));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[3,2,3],[1,1,2],[2,3,4]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution1579.maxNumEdgesToRemove(n, edges));
    }
}
