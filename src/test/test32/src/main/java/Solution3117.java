import java.util.HashMap;
import java.util.Map;

public class Solution3117 {
    private static final int INF = (int) 1e9;
    private int[] nums, andValues;
    private int n, m;
    private Map<String, Integer> memo;

    public int minimumValueSum(int[] nums, int[] andValues) {
        this.nums = nums;
        this.andValues = andValues;
        n = nums.length;
        m = andValues.length;

        memo = new HashMap<>();
        int ans = dfs(0, 0, -1);
        return ans < INF ? ans : -1;
    }

    // 前 i 个数，划分成 j 份，子数组 & 的值为 and
    private int dfs(int i, int j, int and) {
        // 剩余元素不足
        if (m - j > n - i) return INF;
        if (j == m) {
            return i == n ? 0 : INF;
        }
        if (j > m) return INF;
        and &= nums[i];
        if (and < andValues[j]) return INF;

        String key = i + ":" + j + ":" + and;
        if (memo.containsKey(key)) return memo.get(key);
        // 不划分新组
        int res = dfs(i + 1, j, and);
        // 划分新组
        if (and == andValues[j]) {
            res = Math.min(res, nums[i] + dfs(i + 1, j + 1, -1));
        }
        memo.put(key, res);
        return res;
    }
}
/*
3117. 划分数组得到最小的值之和
https://leetcode.cn/problems/minimum-sum-of-values-by-dividing-array/description/

第 393 场周赛 T4。

给你两个数组 nums 和 andValues，长度分别为 n 和 m。
数组的 值 等于该数组的 最后一个 元素。
你需要将 nums 划分为 m 个 不相交的连续 子数组，对于第 ith 个子数组 [li, ri]，子数组元素的按位AND运算结果等于 andValues[i]，换句话说，对所有的 1 <= i <= m，nums[li] & nums[li + 1] & ... & nums[ri] == andValues[i] ，其中 & 表示按位AND运算符。
返回将 nums 划分为 m 个子数组所能得到的可能的 最小 子数组 值 之和。如果无法完成这样的划分，则返回 -1 。
提示：
1 <= n == nums.length <= 10^4
1 <= m == andValues.length <= min(n, 10)
1 <= nums[i] < 10^5
0 <= andValues[j] < 10^5

记忆化搜索。
时间复杂度 O(nmlogU)。
rating 2760 (clist.by)
 */