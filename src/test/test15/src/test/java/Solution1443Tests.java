import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1443Tests {
    private final Solution1443 solution1443 = new Solution1443();

    @Test
    public void example1() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]");
        List<Boolean> hasApple = List.of(false, false, true, false, true, true, false);
        int expected = 8;
        Assertions.assertEquals(expected, solution1443.minTime(n, edges, hasApple));
    }

    @Test
    public void example2() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]");
        List<Boolean> hasApple = List.of(false, false, true, false, false, true, false);
        int expected = 6;
        Assertions.assertEquals(expected, solution1443.minTime(n, edges, hasApple));
    }

    @Test
    public void example3() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]");
        List<Boolean> hasApple = List.of(false, false, false, false, false, false, false);
        int expected = 0;
        Assertions.assertEquals(expected, solution1443.minTime(n, edges, hasApple));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/391659803/
        // TLE
        String fileName = "solution1443-example4-input.txt";
        int n = UtUtils.loadingInt(fileName, 0);
        int[][] edges = UtUtils.loadingInts2(fileName, 1);
        List<Boolean> hasApple = UtUtils.loadingBooleanList(fileName, 2);
        int expected = 137956;
        Assertions.assertEquals(expected, solution1443.minTime(n, edges, hasApple));
    }
}
