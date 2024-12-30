import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2242Tests {
    private final Solution2242 solution2242 = new Solution2242();

    @Test
    public void example1() {
        int[] scores = {5, 2, 9, 8, 4};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]");
        int expected = 24;
        Assertions.assertEquals(expected, solution2242.maximumScore(scores, edges));
    }

    @Test
    public void example2() {
        int[] scores = {9, 20, 6, 4, 11, 12};
        int[][] edges = UtUtils.stringToInts2("[[0,3],[5,3],[2,4],[1,3]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution2242.maximumScore(scores, edges));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/309073214/
        // 51 / 74 个通过测试用例
        // 不剪枝会 TLE
        int[] scores = UtUtils.loadingInts("solution2242-example3-input.txt", 0);
        int[][] edges = UtUtils.loadingInts2("solution2242-example3-input.txt", 1);
        int expected = 20;
        Assertions.assertEquals(expected, solution2242.maximumScore(scores, edges));
    }
}
