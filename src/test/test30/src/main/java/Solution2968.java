import java.util.Arrays;

public class Solution2968 {
    public int maxFrequencyScore(int[] nums, long k) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        int l = 0, r = 0;
        int ans = 0;
        while (r < n) {
            while (getCost(nums, l, r, ps) > k) {
                l++;
            }
            // 代价 <= k
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    private long getCost(int[] nums, int l, int r, long[] ps) {
        int m = (l + r) / 2;
        long median = nums[m];
        // [l, m-1] [m, r]
        long l_len = m - 1 - l + 1;
        long l_sum = ps[m] - ps[l];
        long r_len = r - m + 1;
        long r_sum = ps[r + 1] - ps[m];
        return r_sum - r_len * median + l_len * median - l_sum;
    }
}
/*
2968. 执行操作使频率分数最大
https://leetcode.cn/problems/apply-operations-to-maximize-frequency-score/description/

第 376 场周赛 T4。

给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
你可以对数组执行 至多 k 次操作：
- 从数组中选择一个下标 i ，将 nums[i] 增加 或者 减少 1 。
最终数组的频率分数定义为数组中众数的 频率 。
请你返回你可以得到的 最大 频率分数。
众数指的是数组中出现次数最多的数。一个元素的频率指的是数组中这个元素的出现次数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= k <= 10^14

HPC 初赛题目。
双指针 / 滑动窗口 + 中位数 贪心。
窗口内操作次数最小是变为中位数，当操作次数大于 k 时，收缩窗口（左指针右移），答案即为窗口最大长度。
时间复杂度 O(nlogn)
 */