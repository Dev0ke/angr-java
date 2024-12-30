import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1870Tests {
    private final Solution1870 solution1870 = new Solution1870();

    @Test
    public void example1() {
        int[] dist = {1, 3, 2};
        double hour = 6;
        int expected = 1;
        Assertions.assertEquals(expected, solution1870.minSpeedOnTime(dist, hour));
    }

    @Test
    public void example2() {
        int[] dist = {1, 3, 2};
        double hour = 2.7;
        int expected = 3;
        Assertions.assertEquals(expected, solution1870.minSpeedOnTime(dist, hour));
    }

    @Test
    public void example3() {
        int[] dist = {1, 3, 2};
        double hour = 1.9;
        int expected = -1;
        Assertions.assertEquals(expected, solution1870.minSpeedOnTime(dist, hour));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/314448904/
        int[] dist = {4, 2, 3};
        double hour = 2.03;
        int expected = 100;
        Assertions.assertEquals(expected, solution1870.minSpeedOnTime(dist, hour));
    }
}
