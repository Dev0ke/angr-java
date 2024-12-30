import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1802Tests {
    private final Solution1802 solution1802 = new Solution1802();

    @Test
    public void example1() {
        int n = 4;
        int index = 2;
        int maxSum = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution1802.maxValue(n, index, maxSum));
    }

    @Test
    public void example2() {
        int n = 6;
        int index = 1;
        int maxSum = 10;
        int expected = 3;
        Assertions.assertEquals(expected, solution1802.maxValue(n, index, maxSum));
    }

    // 补充用例
    @Test
    public void example3() {
        int n = 3;
        int index = 2;
        int maxSum = 18;
        int expected = 7;
        Assertions.assertEquals(expected, solution1802.maxValue(n, index, maxSum));
    }

    @Test
    public void example4() {
        // 负数
        int n = 8;
        int index = 7;
        int maxSum = 14;
        int expected = 4;
        Assertions.assertEquals(expected, solution1802.maxValue(n, index, maxSum));
    }

    @Test
    public void example5() {
        int n = 4;
        int index = 0;
        int maxSum = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution1802.maxValue(n, index, maxSum));
    }
}
