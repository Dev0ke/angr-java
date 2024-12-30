import java.util.HashMap;
import java.util.Map;

public class Solution2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, ans = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        int cnt_freqGtK = 0; // 频次超过 k 的数目
        while (r < n) {
            if (cntMap.merge(nums[r], 1, Integer::sum) == k + 1) cnt_freqGtK++;
            while (cnt_freqGtK > 0) {
                if (cntMap.merge(nums[l], -1, Integer::sum) == k) cnt_freqGtK--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
2958. 最多 K 个重复元素的最长子数组
https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/description/

第 119 场双周赛 T3。

给你一个整数数组 nums 和一个整数 k 。
一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
请你返回 nums 中 最长好 子数组的长度。
子数组 指的是一个数组中一段连续非空的元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= nums.length

不定长滑动窗口（求最长/最大）
时间复杂度 O(n)
 */