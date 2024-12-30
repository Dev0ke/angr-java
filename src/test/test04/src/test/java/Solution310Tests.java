import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution310Tests {
    private final Solution310.V1 solution310_v1 = new Solution310.V1();
    private final Solution310.V2 solution310_v2 = new Solution310.V2();

    @Test
    public void example1() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[1,0],[1,2],[1,3]]");
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution310_v1.findMinHeightTrees(n, edges));
        Assertions.assertEquals(expected, solution310_v2.findMinHeightTrees(n, edges));
    }

    @Test
    public void example2() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[3,0],[3,1],[3,2],[3,4],[5,4]]");
        List<Integer> expected = List.of(3, 4);
        Assertions.assertEquals(expected, solution310_v1.findMinHeightTrees(n, edges));
        Assertions.assertEquals(expected, solution310_v2.findMinHeightTrees(n, edges));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/239597589/
        int n = 1;
        int[][] edges = UtUtils.stringToInts2("[]");
        List<Integer> expected = List.of(0);
        Assertions.assertEquals(expected, solution310_v1.findMinHeightTrees(n, edges));
        Assertions.assertEquals(expected, solution310_v2.findMinHeightTrees(n, edges));
    }

    @Test
    public void example4() {
        int n = 2;
        int[][] edges = {{0, 1}};
        List<Integer> expected = List.of(0, 1);
        Assertions.assertEquals(expected, solution310_v1.findMinHeightTrees(n, edges));
        Assertions.assertEquals(expected, solution310_v2.findMinHeightTrees(n, edges));
    }
}
