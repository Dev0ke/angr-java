import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution452Tests {
    private final Solution452 solution452 = new Solution452();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[10,16],[2,8],[1,6],[7,12]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution452.findMinArrowShots(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[1,2],[3,4],[5,6],[7,8]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution452.findMinArrowShots(points));
    }

    @Test
    public void example3() {
        int[][] points = UtUtils.stringToInts2("[[1,2],[2,3],[3,4],[4,5]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution452.findMinArrowShots(points));
    }

    @Test
    public void example4() {
        int[][] points = {{1, 2}};
        int expected = 1;
        Assertions.assertEquals(expected, solution452.findMinArrowShots(points));
    }

    @Test
    public void example5() {
        int[][] points = {{2, 3}, {2, 3}};
        int expected = 1;
        Assertions.assertEquals(expected, solution452.findMinArrowShots(points));
    }

    // 补充用例
    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/243982002/
        int[][] points = UtUtils.stringToInts2("[[-2147483646,-2147483645],[2147483646,2147483647]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution452.findMinArrowShots(points));
    }
}