import java.util.ArrayList;
import java.util.List;

public class Solution3349 {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
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
        if (mx >= k * 2) return true;
        int sz = lens.size();

        for (int j = 1; j < sz; j++) {
            if (lens.get(j - 1) >= k && lens.get(j) >= k) {
                return true;
            }
        }
        return false;
    }
}
/*
3349. 检测相邻递增子数组 I
https://leetcode.cn/problems/adjacent-increasing-subarrays-detection-i/description/

第 423 场周赛 T1。

给你一个由 n 个整数组成的数组 nums 和一个整数 k，请你确定是否存在 两个 相邻 且长度为 k 的 严格递增 子数组。具体来说，需要检查是否存在从下标 a 和 b (a < b) 开始的 两个 子数组，并满足下述全部条件：
- 这两个子数组 nums[a..a + k - 1] 和 nums[b..b + k - 1] 都是 严格递增 的。
- 这两个子数组必须是 相邻的，即 b = a + k。
如果可以找到这样的 两个 子数组，请返回 true；否则返回 false。
子数组 是数组中的一个连续 非空 的元素序列。
提示：
2 <= nums.length <= 100
1 <= 2 * k <= nums.length
-1000 <= nums[i] <= 1000

分组循环。
时间复杂度 O(n)。
 */