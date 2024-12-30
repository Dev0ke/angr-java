import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2352Tests {
    private final Solution2352 solution2352 = new Solution2352();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[3,2,1],[1,7,6],[2,7,7]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2352.equalPairs(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2352.equalPairs(grid));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/340880077/
        // 没正确统计 重复行
        int[][] grid = UtUtils.stringToInts2("[[3,1,2,2],[1,4,4,4],[2,4,2,2],[2,5,2,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2352.equalPairs(grid));
    }
}
