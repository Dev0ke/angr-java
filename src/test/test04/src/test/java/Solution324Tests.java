import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution324Tests {
    private final Solution324 solution324 = new Solution324();

    @Test
    public void example1() {
        int[] nums = {1, 5, 1, 1, 6, 4};
        solution324.wiggleSort(nums);
        Assertions.assertTrue(check(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 2, 2, 3, 1};
        solution324.wiggleSort(nums);
        Assertions.assertTrue(check(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/368622829/
        // 不能用 280 题方法
        int[] nums = {5, 5, 5, 4, 4, 4, 4};
        solution324.wiggleSort(nums);
        Assertions.assertTrue(check(nums));
    }

    private boolean check(int[] nums) {
        boolean less = true;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (less) {
                if (nums[i] >= nums[i + 1]) {
                    return false;
                }
            } else {
                if (nums[i] <= nums[i + 1]) {
                    return false;
                }
            }
            less = !less;
        }
        return true;
    }
}
