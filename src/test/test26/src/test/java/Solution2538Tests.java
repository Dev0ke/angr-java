import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2538Tests {
    private final Solution2538 solution2538 = new Solution2538();

    @Test
    public void example1() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[1,3],[3,4],[3,5]]");
        int[] price = {9, 8, 7, 6, 10, 5};
        long expected = 24;
        Assertions.assertEquals(expected, solution2538.maxOutput(n, edges, price));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[] price = {1, 1, 1};
        long expected = 2;
        Assertions.assertEquals(expected, solution2538.maxOutput(n, edges, price));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/395388632/
        // BFS O(n^2) TLE
        String fileName = "solution2538-example3-input.txt";
        int n = UtUtils.loadingInt(fileName, 0);
        int[][] edges = UtUtils.loadingInts2(fileName, 1);
        int[] price = UtUtils.loadingInts(fileName, 2);
        long expected = 46183;
        Assertions.assertEquals(expected, solution2538.maxOutput(n, edges, price));
    }
}
