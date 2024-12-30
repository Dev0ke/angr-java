import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2192Tests {
    private final Solution2192 solution2192 = new Solution2192();

    @Test
    public void example1() {
        int n = 8;
        int[][] edges = UtUtils.stringToInts2("[[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]");
        Assertions.assertEquals(expected, solution2192.getAncestors(n, edges));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[],[0],[0,1],[0,1,2],[0,1,2,3]]");
        Assertions.assertEquals(expected, solution2192.getAncestors(n, edges));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/277929011/
        // 40 / 80 个通过测试用例
        int n = UtUtils.loadingInt("solution2192-example3-input.txt", 0);
        int[][] edges = UtUtils.loadingInts2("solution2192-example3-input.txt", 1);
        List<List<Integer>> expected = UtUtils.loadingIntegerList2("solution2192-example3-output.txt", 0);
        Assertions.assertEquals(expected, solution2192.getAncestors(n, edges));
    }
}
