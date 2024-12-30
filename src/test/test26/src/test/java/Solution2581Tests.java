import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2581Tests {
    private final Solution2581 solution2581 = new Solution2581();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[1,3],[4,2]]");
        int[][] guesses = UtUtils.stringToInts2("[[1,3],[0,1],[1,0],[2,4]]");
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution2581.rootCount(edges, guesses, k));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[3,4]]");
        int[][] guesses = UtUtils.stringToInts2("[[1,0],[3,4],[2,1],[3,2]]");
        int k = 1;
        int expected = 5;
        Assertions.assertEquals(expected, solution2581.rootCount(edges, guesses, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/409074771/
        // 换根 DP 细节出错
        int[][] edges = UtUtils.stringToInts2("[[0,1],[2,0],[0,3],[4,2],[3,5],[6,0],[1,7],[2,8],[2,9],[4,10],[9,11],[3,12],[13,8],[14,9],[15,9],[10,16]]");
        int[][] guesses = UtUtils.stringToInts2("[[8,2],[12,3],[0,1],[16,10]]");
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution2581.rootCount(edges, guesses, k));
    }
}
