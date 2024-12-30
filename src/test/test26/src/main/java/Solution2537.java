import java.util.HashMap;
import java.util.Map;

public class Solution2537 {
    public long countGood(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        long ans = 0;
        int pairs = 0;
        while (r < n) {
            pairs += cntMap.merge(nums[r], 1, Integer::sum) - 1;
            while (pairs - (cntMap.get(nums[l]) - 1) >= k) {
                pairs -= cntMap.merge(nums[l], -1, Integer::sum);
                l++;
            }
            if (pairs >= k) ans += l + 1;
            r++;
        }
        return ans;
    }
}
/*
2537. 统计好子数组的数目
https://leetcode.cn/problems/count-the-number-of-good-subarrays/

第 328 场周赛 T3。

给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
子数组 是原数组中一段连续 非空 的元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i], k <= 10^9

双指针（滑动窗口）
时间复杂度 O(n)
 */