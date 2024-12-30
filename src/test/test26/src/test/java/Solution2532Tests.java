import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2532Tests {
    private final Solution2532 solution2532 = new Solution2532();

    @Test
    public void example1() {
        int n = 1;
        int k = 3;
        int[][] time = UtUtils.stringToInts2("[[1,1,2,1],[1,1,3,1],[1,1,4,1]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution2532.findCrossingTime(n, k, time));
    }

    @Test
    public void example2() {
        int n = 3;
        int k = 2;
        int[][] time = UtUtils.stringToInts2("[[1,9,1,8],[10,10,10,10]]");
        int expected = 50;
        Assertions.assertEquals(expected, solution2532.findCrossingTime(n, k, time));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/393795381/
        int n = 8;
        int k = 5;
        int[][] time = UtUtils.stringToInts2("[[10,8,4,7],[10,6,9,10],[3,7,4,6],[7,3,9,10],[10,6,3,5]]");
        int expected = 133;
        Assertions.assertEquals(expected, solution2532.findCrossingTime(n, k, time));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/393814894/
        int n = 6;
        int k = 8;
        int[][] time = UtUtils.stringToInts2("[[3,3,4,3],[6,2,8,3],[9,4,5,7],[9,8,9,10],[3,10,5,10],[3,3,8,4],[6,8,8,5],[5,7,10,4]]");
        int expected = 94;
        Assertions.assertEquals(expected, solution2532.findCrossingTime(n, k, time));
    }
}
