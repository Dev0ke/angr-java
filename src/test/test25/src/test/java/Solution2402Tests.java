import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2402Tests {
    private final Solution2402 solution2402 = new Solution2402();

    @Test
    public void example1() {
        int n = 2;
        int[][] meetings = UtUtils.stringToInts2("[[0,10],[1,5],[2,7],[3,4]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution2402.mostBooked(n, meetings));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] meetings = UtUtils.stringToInts2("[[1,20],[2,10],[3,5],[4,9],[6,8]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2402.mostBooked(n, meetings));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/359011452/
        // 爆 int
        int n = UtUtils.loadingInt("solution2402-example3-input.txt", 0);
        int[][] meetings = UtUtils.loadingInts2("solution2402-example3-input.txt", 1);
        int expected = 1;
        Assertions.assertEquals(expected, solution2402.mostBooked(n, meetings));
    }
}
