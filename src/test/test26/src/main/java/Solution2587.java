import java.util.Arrays;

public class Solution2587 {
    public int maxScore(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int res = 0;
        long preSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            preSum += nums[i];
            if (preSum > 0) {
                res++;
            }
        }
        return res;
    }
}
/*
2587. 重排数组以得到最大前缀分数
https://leetcode.cn/problems/rearrange-array-to-maximize-prefix-score/

第 336 场周赛 T2。

给你一个下标从 0 开始的整数数组 nums 。你可以将 nums 中的元素按 任意顺序 重排（包括给定顺序）。
令 prefix 为一个数组，它包含了 nums 重新排列后的前缀和。换句话说，prefix[i] 是 nums 重新排列后下标从 0 到 i 的元素之和。nums 的 分数 是 prefix 数组中正整数的个数。
返回可以得到的最大分数。
提示：
1 <= nums.length <= 10^5
-10^6 <= nums[i] <= 10^6

贪心。
排序后 + 前缀和 + 计数
时间复杂度 O(n)
 */