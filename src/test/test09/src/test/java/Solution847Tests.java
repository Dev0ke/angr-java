import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution847Tests {
    private final Solution847 solution847 = new Solution847();

    @Test
    public void example1() {
        int[][] graph = UtUtils.stringToInts2("[[1,2,3],[0],[0],[0]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution847.shortestPathLength(graph));
    }

    @Test
    public void example2() {
        int[][] graph = UtUtils.stringToInts2("[[1],[0,2,4],[1,3,4],[2],[1,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution847.shortestPathLength(graph));
    }
}
