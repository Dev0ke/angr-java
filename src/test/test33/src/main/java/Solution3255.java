import java.util.Arrays;

public class Solution3255 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ps = new int[n];
        for (int i = 1; i < n; i++) {
            ps[i] += ps[i - 1];
            if (nums[i - 1] + 1 == nums[i]) ps[i] += 1;
        }

        int[] ans = new int[n - k + 1];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n - k + 1; i++) {
            int sum = ps[i + k - 1] - ps[i];
            if (sum == k - 1) ans[i] = nums[i + k - 1];
        }
        return ans;
    }
}
/*
3255. 长度为 K 的子数组的能量值 II
https://leetcode.cn/problems/find-the-power-of-k-size-subarrays-ii/description/

第 137 场双周赛 T2。

给你一个长度为 n 的整数数组 nums 和一个正整数 k 。
一个数组的 能量值 定义为：
- 如果 所有 元素都是依次 连续 且 上升 的，那么能量值为 最大 的元素。
- 否则为 -1 。
你需要求出 nums 中所有长度为 k 的 子数组  的能量值。
请你返回一个长度为 n - k + 1 的整数数组 results ，其中 results[i] 是子数组 nums[i..(i + k - 1)] 的能量值。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^6
1 <= k <= n

前缀和。
时间复杂度 O(n)。
 */