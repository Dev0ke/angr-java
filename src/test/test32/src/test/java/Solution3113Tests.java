import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3113Tests {
    private final Solution3113 solution3113 = new Solution3113();

    @Test
    public void example1() {
        int[] nums = {1, 4, 3, 3, 2};
        long expected = 6;
        Assertions.assertEquals(expected, solution3113.numberOfSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3, 3};
        long expected = 6;
        Assertions.assertEquals(expected, solution3113.numberOfSubarrays(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        long expected = 1;
        Assertions.assertEquals(expected, solution3113.numberOfSubarrays(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/find-the-number-of-subarrays-where-boundary-elements-are-maximum/submissions/523406299/
        // Deque<int[]> st 不能单独抽出 num 和 cnt
        int[] nums = {145, 145, 147, 148, 145, 149, 147, 147, 145, 147};
        long expected = 14;
        Assertions.assertEquals(expected, solution3113.numberOfSubarrays(nums));
    }
}