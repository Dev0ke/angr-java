import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1203Tests {
    private final Solution1203 solution1203 = new Solution1203();

    @Test
    public void example1() {
        int n = 8;
        int m = 2;
        int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
        List<List<Integer>> beforeItems = UtUtils.stringToIntegerList2("[[],[6],[5],[6],[3,6],[],[],[]]");
        // 如果存在多个解决方案，只需要返回其中任意一个即可
//        int[] expected = {6, 3, 4, 1, 5, 2, 0, 7};
        int[] expected = {6, 3, 4, 5, 2, 0, 7, 1};
        Assertions.assertArrayEquals(expected, solution1203.sortItems(n, m, group, beforeItems));
    }

    @Test
    public void example2() {
        int n = 8;
        int m = 2;
        int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
        List<List<Integer>> beforeItems = UtUtils.stringToIntegerList2("[[],[6],[5],[6],[3],[],[4],[]]");
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution1203.sortItems(n, m, group, beforeItems));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/298431373/
        // 若使用 Map<Integer, Set<Integer>> graph 会 WA
        int n = 5;
        int m = 3;
        int[] group = {0, 0, 2, 1, 0};
        List<List<Integer>> beforeItems = UtUtils.stringToIntegerList2("[[3],[],[],[],[1,3,2]]");
        int[] expected = {3, 2, 1, 0, 4};
        Assertions.assertArrayEquals(expected, solution1203.sortItems(n, m, group, beforeItems));
    }
}