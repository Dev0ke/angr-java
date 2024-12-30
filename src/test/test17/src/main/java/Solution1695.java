import java.util.HashMap;
import java.util.Map;

public class Solution1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length, l = 0, r = 0, ans = 0;
        int cnt_unique = 0; // 去重后的个数
        Map<Integer, Integer> cntMap = new HashMap<>();
        int sum = 0;
        while (r < n) {
            if (cntMap.merge(nums[r], 1, Integer::sum) == 1) cnt_unique++;
            sum += nums[r];
            while (cnt_unique < r - l + 1) { // 元素去重后的个数 小于 元素个数 => 有重复元素
                if (cntMap.merge(nums[l], -1, Integer::sum) == 0) cnt_unique--;
                sum -= nums[l];
                l++;
            }
            ans = Math.max(ans, sum);
            r++;
        }
        return ans;
    }
}
/*
1695. 删除子数组的最大得分
https://leetcode.cn/problems/maximum-erasure-value/description/

给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
返回 只删除一个 子数组可获得的 最大得分 。
如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4

不定长滑动窗口（求最长/最大）
时间复杂度 O(n)
 */