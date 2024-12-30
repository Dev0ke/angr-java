import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution629Tests {
    private final Solution629.V1 solution629_v1 = new Solution629.V1();
    private final Solution629.V2 solution629_v2 = new Solution629.V2();
    private final Solution629.V3 solution629_v3 = new Solution629.V3();

    @Test
    public void example1() {
        int n = 3;
        int k = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution629_v1.kInversePairs(n, k));
        Assertions.assertEquals(expected, solution629_v2.kInversePairs(n, k));
        Assertions.assertEquals(expected, solution629_v3.kInversePairs(n, k));
    }

    @Test
    public void example2() {
        int n = 3;
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution629_v1.kInversePairs(n, k));
        Assertions.assertEquals(expected, solution629_v2.kInversePairs(n, k));
        Assertions.assertEquals(expected, solution629_v3.kInversePairs(n, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/k-inverse-pairs-array/submissions/541315544
        int n = 1000;
        int k = 1000;
        int expected = 663677020;
        Assertions.assertEquals(expected, solution629_v1.kInversePairs(n, k));
        Assertions.assertEquals(expected, solution629_v2.kInversePairs(n, k));
        Assertions.assertEquals(expected, solution629_v3.kInversePairs(n, k));
    }
}