import java.util.ArrayList;
import java.util.List;

public class Solution3350 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int[] a = nums.stream().mapToInt(Integer::intValue).toArray();
        int n = a.length;
        int i = 0;
        List<Integer> lens = new ArrayList<>();
        int mx = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && a[i - 1] < a[i]; i++) {
            }
            lens.add(i - st);
            mx = Math.max(mx, i - st);
        }
        int ans = mx / 2;
        int sz = lens.size();
        for (int j = 1; j < sz; j++) {
            ans = Math.max(ans, Math.min(lens.get(j - 1), lens.get(j)));
        }
        return ans;
    }
}
/*
3350. 检测相邻递增子数组 II
https://leetcode.cn/problems/adjacent-increasing-subarrays-detection-ii/description/

第 423 场周赛 T2。

给你一个由 n 个整数组成的数组 nums ，请你找出 k 的 最大值，使得存在 两个 相邻 且长度为 k 的 严格递增 子数组。具体来说，需要检查是否存在从下标 a 和 b (a < b) 开始的 两个 子数组，并满足下述全部条件：
- 这两个子数组 nums[a..a + k - 1] 和 nums[b..b + k - 1] 都是 严格递增 的。
- 这两个子数组必须是 相邻的，即 b = a + k。
返回 k 的 最大可能 值。
子数组 是数组中的一个连续 非空 的元素序列。
提示：
2 <= nums.length <= 2 * 10^5
-10^9 <= nums[i] <= 10^9

分组循环。
时间复杂度 O(n)。
 */