import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2939Tests {
    private final Solution2939 solution2939 = new Solution2939();

    @Test
    public void example1() {
        long a = 12;
        long b = 5;
        int n = 4;
        int expected = 98;
        Assertions.assertEquals(expected, solution2939.maximumXorProduct(a, b, n));
        Assertions.assertEquals(expected, solution2939.maximumXorProduct2(a, b, n));
    }

    @Test
    public void example2() {
        long a = 6;
        long b = 7;
        int n = 5;
        int expected = 930;
        Assertions.assertEquals(expected, solution2939.maximumXorProduct(a, b, n));
        Assertions.assertEquals(expected, solution2939.maximumXorProduct2(a, b, n));
    }

    @Test
    public void example3() {
        long a = 1;
        long b = 6;
        int n = 3;
        int expected = 12;
        Assertions.assertEquals(expected, solution2939.maximumXorProduct(a, b, n));
        Assertions.assertEquals(expected, solution2939.maximumXorProduct2(a, b, n));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/maximum-xor-product/submissions/483221784/
        long a = 0;
        long b = 7;
        int n = 2;
        int expected = 12;
        Assertions.assertEquals(expected, solution2939.maximumXorProduct(a, b, n));
        Assertions.assertEquals(expected, solution2939.maximumXorProduct2(a, b, n));
    }
}