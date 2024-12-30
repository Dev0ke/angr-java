import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1808Tests {
    private final Solution1808 solution1808 = new Solution1808();

    @Test
    public void example1() {
        int primeFactors = 5;
        int expected = 6;
        Assertions.assertEquals(expected, solution1808.maxNiceDivisors(primeFactors));
    }

    @Test
    public void example2() {
        int primeFactors = 8;
        int expected = 18;
        Assertions.assertEquals(expected, solution1808.maxNiceDivisors(primeFactors));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/maximize-number-of-nice-divisors/submissions/548082845/
        int primeFactors = 98;
        int expected = 351761402;
        Assertions.assertEquals(expected, solution1808.maxNiceDivisors(primeFactors));
    }

    @Test
    public void example4() {
        int primeFactors = 545918790;
        int expected = 421090465;
        Assertions.assertEquals(expected, solution1808.maxNiceDivisors(primeFactors));
    }
}