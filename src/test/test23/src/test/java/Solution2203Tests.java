import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2203Tests {
    private final Solution2203 solution2203 = new Solution2203();

    @Test
    public void example1() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[0,2,2],[0,5,6],[1,0,3],[1,4,5],[2,1,1],[2,3,3],[2,3,4],[3,4,2],[4,5,1]]");
        int src1 = 0;
        int src2 = 1;
        int dest = 5;
        long expected = 9;
        Assertions.assertEquals(expected, solution2203.minimumWeight(n, edges, src1, src2, dest));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[2,1,1]]");
        int src1 = 0;
        int src2 = 1;
        int dest = 2;
        long expected = -1;
        Assertions.assertEquals(expected, solution2203.minimumWeight(n, edges, src1, src2, dest));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/282218886/
        // 19 / 86 个通过测试用例
        int n = 8;
        int[][] edges = UtUtils.stringToInts2("[[4,7,24],[1,3,30],[4,0,31],[1,2,31],[1,5,18],[1,6,19],[4,6,25],[5,6,32],[0,6,50]]");
        int src1 = 4;
        int src2 = 1;
        int dest = 6;
        long expected = 44;
        Assertions.assertEquals(expected, solution2203.minimumWeight(n, edges, src1, src2, dest));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/282381119/
        // 77 / 78 个通过测试用例
        String fileName = "solution2203-example4-input.txt";
        int n = UtUtils.loadingInt(fileName, 0);
        int[][] edges = UtUtils.loadingInts2(fileName, 1);
        int src1 = UtUtils.loadingInt(fileName, 2);
        int src2 = UtUtils.loadingInt(fileName, 3);
        int dest = UtUtils.loadingInt(fileName, 4);
        long expected = 9999900000L;
        Assertions.assertEquals(expected, solution2203.minimumWeight(n, edges, src1, src2, dest));
    }
}