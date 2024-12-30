import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2541Tests {
    private final Solution2541 solution2541 = new Solution2541();

    @Test
    public void example1() {
        int[] nums1 = {4, 3, 1, 4};
        int[] nums2 = {1, 3, 7, 1};
        int k = 3;
        long expected = 2;
        Assertions.assertEquals(expected, solution2541.minOperations(nums1, nums2, k));
    }

    @Test
    public void example2() {
        int[] nums1 = {3, 8, 5, 2};
        int[] nums2 = {2, 4, 1, 6};
        int k = 1;
        long expected = -1;
        Assertions.assertEquals(expected, solution2541.minOperations(nums1, nums2, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/397340535/
        // RE java.lang.ArithmeticException: / by zero
        int[] nums1 = {10, 5, 15, 20};
        int[] nums2 = {20, 10, 15, 5};
        int k = 0;
        long expected = -1;
        Assertions.assertEquals(expected, solution2541.minOperations(nums1, nums2, k));
    }
}
