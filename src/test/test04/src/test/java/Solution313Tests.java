import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution313Tests {
    private final Solution313 solution313 = new Solution313();

    @Test
    public void example1() {
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        int expected = 32;
        Assertions.assertEquals(expected, solution313.nthSuperUglyNumber(n, primes));
    }

    @Test
    public void example2() {
        int n = 1;
        int[] primes = {2, 3, 5};
        int expected = 1;
        Assertions.assertEquals(expected, solution313.nthSuperUglyNumber(n, primes));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/super-ugly-number/submissions/518991622/
        int n = 5911;
        int[] primes = {2, 3, 5, 7};
        int expected = 2144153025;
        Assertions.assertEquals(expected, solution313.nthSuperUglyNumber(n, primes));
    }
}