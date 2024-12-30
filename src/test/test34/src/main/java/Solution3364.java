import java.util.List;
import java.util.TreeMap;

public class Solution3364 {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + l - 1 < n; i++) {
            for (int j = l; j <= r; j++) {
                if (i + j > n) break;
                int sum = ps[i + j] - ps[i];
                if (sum > 0) ans = Math.min(ans, sum);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // O(n) 枚举右 维护左
    public int minimumSumSubarray2(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums.get(i);
        }
        int ans = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int j = 1; j <= n; j++) {
            if (j < l) continue;
            cnt.merge(ps[j - l], 1, Integer::sum);
            Integer lowerKey = cnt.lowerKey(ps[j]);
            if (lowerKey != null) {
                ans = Math.min(ans, ps[j] - lowerKey);
            }
            if (j >= r) {
                int nc = cnt.merge(ps[j - r], -1, Integer::sum);
                if (nc == 0) cnt.remove(ps[j - r]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
/*
3364. 最小正和子数组
https://leetcode.cn/problems/minimum-positive-sum-subarray/description/

第 425 场周赛 T1。

给你一个整数数组 nums 和 两个 整数 l 和 r。你的任务是找到一个长度在 l 和 r 之间（包含）且和大于 0 的 子数组 的 最小 和。
返回满足条件的子数组的 最小 和。如果不存在这样的子数组，则返回 -1。
子数组 是数组中的一个连续 非空 元素序列。
提示：
1 <= nums.length <= 100
1 <= l <= r <= nums.length
-1000 <= nums[i] <= 1000

如何做到 O(n)。
 */