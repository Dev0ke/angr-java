import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1976Tests {
    private final Solution1976 solution1976 = new Solution1976();

    @Test
    public void example1() {
        int n = 7;
        int[][] roads = UtUtils.stringToInts2("[[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1976.countPaths(n, roads));
        Assertions.assertEquals(expected, solution1976.countPaths2(n, roads));
    }

    @Test
    public void example2() {
        int n = 2;
        int[][] roads = UtUtils.stringToInts2("[[1,0,10]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1976.countPaths(n, roads));
        Assertions.assertEquals(expected, solution1976.countPaths2(n, roads));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/361463695/
        int n = UtUtils.loadingInt("solution1976-example3-input.txt", 0);
        int[][] roads = UtUtils.loadingInts2("solution1976-example3-input.txt", 1);
        int expected = 113150546;
        Assertions.assertEquals(expected, solution1976.countPaths(n, roads));
        Assertions.assertEquals(expected, solution1976.countPaths2(n, roads));
    }
}
