import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution218Tests {
    private final Solution218.V1 solution218 = new Solution218.V1();
    private final Solution218.V2 solution218_v2 = new Solution218.V2();

    @Test
    public void example1() {
        int[][] buildings = UtUtils.stringToInts2("[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]");
        Assertions.assertEquals(expected, solution218.getSkyline(buildings));
        Assertions.assertEquals(expected, solution218_v2.getSkyline(buildings));
    }

    @Test
    public void example2() {
        int[][] buildings = UtUtils.stringToInts2("[[0,2,3],[2,5,3]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,3],[5,0]]");
        Assertions.assertEquals(expected, solution218.getSkyline(buildings));
        Assertions.assertEquals(expected, solution218_v2.getSkyline(buildings));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/321603987/
        // 21 / 40 个通过测试用例
        // 要先做升序排序
        int[][] buildings = UtUtils.stringToInts2("[[2,13,10],[10,17,25],[12,20,14]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,10],[10,25],[17,14],[20,0]]");
        Assertions.assertEquals(expected, solution218.getSkyline(buildings));
        Assertions.assertEquals(expected, solution218_v2.getSkyline(buildings));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/327704423/
        // 爆 int
        int[][] buildings = UtUtils.stringToInts2("[[0,2147483647,2147483647]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,2147483647],[2147483647,0]]");
        Assertions.assertEquals(expected, solution218.getSkyline(buildings));
        Assertions.assertEquals(expected, solution218_v2.getSkyline(buildings));
    }
}