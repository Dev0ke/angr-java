public class Solution1909 {
    public boolean canBeIncreasing(int[] nums) {
        int len = nums.length;

        // 一次删除机会
        boolean choice = false;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] >= nums[i]) {
                if (choice) {
                    return false;
                }
                choice = true;

                // 删除 nums[i-1] 或 nums[i] 都不满足
                boolean case1 = i - 2 >= 0 && nums[i - 2] >= nums[i];
                boolean case2 = i + 1 < len && nums[i - 1] >= nums[i + 1];
                if (case1 && case2) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
1909. 删除一个元素使数组严格递增
https://leetcode.cn/problems/remove-one-element-to-make-the-array-strictly-increasing/

第 55 场双周赛 T1。

给你一个下标从 0 开始的整数数组 nums ，如果 恰好 删除 一个 元素后，数组 严格递增 ，那么请你返回 true ，否则返回 false 。
如果数组本身已经是严格递增的，请你也返回 true 。
数组 nums 是 严格递增 的定义为：对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。
提示：
2 <= nums.length <= 1000
1 <= nums[i] <= 1000

枚举，若 nums[i - 1] >= nums[i]，尝试删除 nums[i-1] 或 nums[i]，判断是否成立。
 */
