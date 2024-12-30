import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        int cnt_unique = 0; // 去重后的个数
        long sum = 0, maxSum = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            if (cntMap.merge(nums[i], 1, Integer::sum) == 1) cnt_unique++;
        }
        if (cnt_unique == k) maxSum = Math.max(maxSum, sum);

        for (int i = k; i < n; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            if (cntMap.merge(nums[i - k], -1, Integer::sum) == 0) cnt_unique--;
            if (cntMap.merge(nums[i], 1, Integer::sum) == 1) cnt_unique++;
            if (cnt_unique == k) maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
/*
2461. 长度为 K 子数组中的最大和
https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/

第 318 场周赛 T2。

给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
- 子数组的长度是 k，且
- 子数组中的所有元素 各不相同 。
返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
子数组 是数组中一段连续非空的元素序列。
提示：
1 <= k <= nums.length <= 10^5
1 <= nums[i] <= 10^5

定长滑动窗口。
时间复杂度 O(n)
相似题目: 2841. 几乎唯一子数组的最大和
https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/
 */