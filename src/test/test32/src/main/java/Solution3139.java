import java.util.Arrays;

public class Solution3139 {
    private static final int MOD = (int) (1e9 + 7);

    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        int n = nums.length;
        int mx = Arrays.stream(nums).max().orElseThrow();
        int mn = Arrays.stream(nums).min().orElseThrow();
        long s = 0;
        for (int v : nums) {
            s += mx - v;
        }
        long ans = s * cost1;
        if (cost1 * 2 <= cost2) return (int) (ans % MOD);

        for (int x = mx; x <= mx + mx; x++) {
            int d = x - mn;
            if (d <= s - d) {
                ans = Math.min(ans, s / 2 * cost2 + (s % 2) * cost1);
            } else {
                ans = Math.min(ans, (s - d) * cost2 + (d * 2L - s) * cost1);
            }
            s += n;
        }
        return (int) (ans % MOD);
    }
}
/*
3139. 使数组中所有元素相等的最小开销
https://leetcode.cn/problems/minimum-cost-to-equalize-array/description/

第 396 场周赛 T4。

给你一个整数数组 nums 和两个整数 cost1 和 cost2 。你可以执行以下 任一 操作 任意 次：
- 从 nums 中选择下标 i 并且将 nums[i] 增加 1 ，开销为 cost1。
- 选择 nums 中两个 不同 下标 i 和 j ，并且将 nums[i] 和 nums[j] 都 增加 1 ，开销为 cost2 。
你的目标是使数组中所有元素都 相等 ，请你返回需要的 最小开销 之和。
由于答案可能会很大，请你将它对 10^9 + 7 取余 后返回。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6
1 <= cost1 <= 10^6
1 <= cost2 <= 10^6

分类讨论。
枚举最终所有数都变成什么（枚举值域）x
  总共增加 s 次
case1：如果 c1*2 <= c2，那么全部用操作 1 完成
  代价 = s * c1
case2：如果 c1*2 > c2，那么我们要尽量多地使用操作 2
  d = x - min(nums)
case2-1：d <= s-d 那么可以尽量多地使用操作 2
  代价 = s / 2 * c2 + s % 2 * c1
case2-2：d > s-d
  代价 = (s-d) * c2 + (d*2-s) * c1
时间复杂度 O(n)
rating 2677 (clist.by)
 */