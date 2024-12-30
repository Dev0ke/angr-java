import java.util.Arrays;

public class Solution2567 {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int res1 = nums[n - 3] - nums[0];
        int res2 = nums[n - 2] - nums[1];
        int res3 = nums[n - 1] - nums[2];
        return Math.min(res1, Math.min(res2, res3));
    }
}
/*
2567. 修改两个元素的最小分数
https://leetcode.cn/problems/minimum-score-by-changing-two-elements/

第 98 场双周赛 T2。

给你一个下标从 0 开始的整数数组 nums 。
- nums 的 最小 得分是满足 0 <= i < j < nums.length 的 |nums[i] - nums[j]| 的最小值。
- nums的 最大 得分是满足 0 <= i < j < nums.length 的 |nums[i] - nums[j]| 的最大值。
- nums 的分数是 最大 得分与 最小 得分的和。
我们的目标是最小化 nums 的分数。你 最多 可以修改 nums 中 2 个元素的值。
请你返回修改 nums 中 至多两个 元素的值后，可以得到的 最小分数 。
|x| 表示 x 的绝对值。
提示：
3 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

脑筋急转弯，只需考虑三种情况。
 */