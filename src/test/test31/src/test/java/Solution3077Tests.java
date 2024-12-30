import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3077Tests {
    private final Solution3077 solution3077 = new Solution3077();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, -1, 2};
        int k = 3;
        long expected = 22;
        Assertions.assertEquals(expected, solution3077.maximumStrength(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {12, -2, -2, -2, -2};
        int k = 5;
        long expected = 64;
        Assertions.assertEquals(expected, solution3077.maximumStrength(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {-1, -2, -3};
        int k = 1;
        long expected = -1;
        Assertions.assertEquals(expected, solution3077.maximumStrength(nums, k));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/maximum-strength-of-k-disjoint-subarrays/submissions/512769482/
        // TLE
        String fileName = "solution3077-example4-input.txt";
        int[] nums = UtUtils.loadingInts(fileName, 0);
        int k = UtUtils.loadingInt(fileName, 1);
        long expected = 487431075057098L;
        Assertions.assertEquals(expected, solution3077.maximumStrength(nums, k));
    }
}