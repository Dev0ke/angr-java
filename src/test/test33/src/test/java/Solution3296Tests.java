import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3296Tests {
    private final Solution3296 solution3296 = new Solution3296();

    @Test
    public void example1() {
        int mountainHeight = 4;
        int[] workerTimes = {2, 1, 1};
        long expected = 3;
        Assertions.assertEquals(expected, solution3296.minNumberOfSeconds(mountainHeight, workerTimes));
    }

    @Test
    public void example2() {
        int mountainHeight = 10;
        int[] workerTimes = {3, 2, 2, 4};
        long expected = 12;
        Assertions.assertEquals(expected, solution3296.minNumberOfSeconds(mountainHeight, workerTimes));
    }

    @Test
    public void example3() {
        int mountainHeight = 5;
        int[] workerTimes = {1};
        long expected = 15;
        Assertions.assertEquals(expected, solution3296.minNumberOfSeconds(mountainHeight, workerTimes));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/minimum-number-of-seconds-to-make-mountain-height-zero/submissions/566917501/
        int mountainHeight = 100000;
        int[] workerTimes = {1};
        long expected = 5000050000L;
        Assertions.assertEquals(expected, solution3296.minNumberOfSeconds(mountainHeight, workerTimes));
    }
}