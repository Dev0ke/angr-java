import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution685Tests {
    private final Solution685 solution685 = new Solution685();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[1,2],[1,3],[2,3]]");
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, solution685.findRedundantDirectedConnection(edges));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[1,2],[2,3],[3,4],[4,1],[1,5]]");
        int[] expected = {4, 1};
        Assertions.assertArrayEquals(expected, solution685.findRedundantDirectedConnection(edges));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/289590342/
        int[][] edges = UtUtils.stringToInts2("[[2,1],[3,1],[4,2],[1,4]]");
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution685.findRedundantDirectedConnection(edges));
    }
}
