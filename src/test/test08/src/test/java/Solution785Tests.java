import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution785Tests {
    private final Solution785 solution785 = new Solution785();

    @Test
    public void example1() {
        int[][] graph = UtUtils.stringToInts2("[[1,2,3],[0,2],[0,1,3],[0,2]]");
        Assertions.assertFalse(solution785.isBipartite(graph));
    }

    @Test
    public void example2() {
        int[][] graph = UtUtils.stringToInts2("[[1,3],[0,2],[1,3],[0,2]]");
        Assertions.assertTrue(solution785.isBipartite(graph));
    }
}
