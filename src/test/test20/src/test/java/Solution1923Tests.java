import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1923Tests {
    private final Solution1923 solution1923 = new Solution1923();

    @Test
    public void example1() {
        int n = 5;
        int[][] paths = UtUtils.stringToInts2("""
                [[0,1,2,3,4],
                [2,3,4],
                [4,0,1,2,3]]
                """);
        int expected = 2;
        Assertions.assertEquals(expected, solution1923.longestCommonSubpath(n, paths));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] paths = UtUtils.stringToInts2("[[0],[1],[2]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1923.longestCommonSubpath(n, paths));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] paths = UtUtils.stringToInts2("""
                [[0,1,2,3,4],
                [4,3,2,1,0]]
                """);
        int expected = 1;
        Assertions.assertEquals(expected, solution1923.longestCommonSubpath(n, paths));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/392726813/
        // 不能直接判定相邻数组的 最长公共子路径 长度
        int n = 3;
        int[][] paths = UtUtils.stringToInts2("[[1,2,0,1],[2,0],[2,0],[1,2],[0,1,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1923.longestCommonSubpath(n, paths));
    }
}