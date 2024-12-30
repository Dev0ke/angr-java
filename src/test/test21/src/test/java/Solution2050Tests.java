import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2050Tests {
    private final Solution2050 solution2050 = new Solution2050();

    @Test
    public void example1() {
        int n = 3;
        int[][] relations = UtUtils.stringToInts2("[[1,3],[2,3]]");
        int[] time = {3, 2, 5};
        int expected = 8;
        Assertions.assertEquals(expected, solution2050.minimumTime(n, relations, time));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] relations = UtUtils.stringToInts2("[[1,5],[2,5],[3,5],[3,4],[4,5]]");
        int[] time = {1, 2, 3, 4, 5};
        int expected = 12;
        Assertions.assertEquals(expected, solution2050.minimumTime(n, relations, time));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/239073738/
        // 10 / 42 个通过测试用例
        int n = 9;
        int[][] relations = UtUtils.stringToInts2("[[2,7],[2,6],[3,6],[4,6],[7,6],[2,1],[3,1],[4,1],[6,1],[7,1],[3,8],[5,8],[7,8],[1,9],[2,9],[6,9],[7,9]]");
        int[] time = {9, 5, 9, 5, 8, 7, 7, 8, 4};
        int expected = 32;
        Assertions.assertEquals(expected, solution2050.minimumTime(n, relations, time));
    }
}
