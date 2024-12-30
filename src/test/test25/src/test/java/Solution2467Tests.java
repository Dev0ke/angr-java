import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2467Tests {
    private final Solution2467 solution2467 = new Solution2467();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[1,3],[3,4]]");
        int bob = 3;
        int[] amount = {-2, 4, 2, -4, 6};
        int expected = 6;
        Assertions.assertEquals(expected, solution2467.mostProfitablePath(edges, bob, amount));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1]]");
        int bob = 1;
        int[] amount = {-7280, 2350};
        int expected = -7280;
        Assertions.assertEquals(expected, solution2467.mostProfitablePath(edges, bob, amount));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/381535335/
        // 叶子节点不包括根节点
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3]]");
        int bob = 3;
        int[] amount = {-5644, -6018, 1188, -8502};
        int expected = -11662;
        Assertions.assertEquals(expected, solution2467.mostProfitablePath(edges, bob, amount));
    }
}