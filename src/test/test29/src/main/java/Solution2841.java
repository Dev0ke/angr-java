import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();
        int[] a = nums.stream().mapToInt(Integer::intValue).toArray();

        int cnt_unique = 0; // 去重后的个数
        long sum = 0, maxSum = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sum += a[i];
            if (cntMap.merge(a[i], 1, Integer::sum) == 1) cnt_unique++;
        }
        if (cnt_unique >= m) maxSum = Math.max(maxSum, sum);

        for (int i = k; i < n; i++) {
            sum -= a[i - k];
            sum += a[i];
            if (cntMap.merge(a[i - k], -1, Integer::sum) == 0) cnt_unique--;
            if (cntMap.merge(a[i], 1, Integer::sum) == 1) cnt_unique++;
            if (cnt_unique >= m) maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
/*
2841. 几乎唯一子数组的最大和
https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/

第 112 场双周赛 T3。

给你一个整数数组 nums 和两个正整数 m 和 k 。
请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。
如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
子数组指的是一个数组中一段连续 非空 的元素序列。
提示：
1 <= nums.length <= 2 * 10^4
1 <= m <= k <= nums.length
1 <= nums[i] <= 10^9

定长滑动窗口。
时间复杂度 O(n)
相似题目: 2461. 长度为 K 子数组中的最大和
https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/
 */