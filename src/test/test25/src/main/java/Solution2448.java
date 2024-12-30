import java.util.Arrays;
import java.util.Comparator;

public class Solution2448 {
    private int[] nums;
    private int[] cost;

    public long minCost(int[] nums, int[] cost) {
        this.nums = nums;
        this.cost = cost;
        int min = Arrays.stream(nums).min().orElseThrow();
        int max = Arrays.stream(nums).max().orElseThrow();
        return ternarySearch_u(min, max);
    }

    private long ternarySearch_u(int mn, int mx) {
        long l = mn, r = mx;
        while (r - l > 2) {
            long m1 = (l * 2 + r) / 3;
            long m2 = (l + r * 2) / 3;
            if (f(m1) > f(m2)) {
                l = m1;
            } else {
                r = m2;
            }
        }
        long res = f(l);
        for (long i = l + 1; i <= r; i++) {
            res = Math.min(res, f(i));
        }
        return res;
    }

    private long f(long mid) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - mid) * cost[i];
        }
        return res;
    }

    static class V2 {
        public long minCost(int[] nums, int[] cost) {
            int n = nums.length;
            Integer[] ids = new Integer[n];
            for (int i = 0; i < n; i++) ids[i] = i;
            Arrays.sort(ids, Comparator.comparingInt(o -> nums[o]));

            long sumCost = 0;
            for (int c : cost) {
                sumCost += c;
            }

            long ans = 0;
            long s = 0, mid = (sumCost + 1) / 2;
            for (Integer id : ids) {
                s += cost[id];
                if (s >= mid) {
                    // 把所有数变成 nums[id]
                    for (Integer j : ids) {
                        ans += (long) Math.abs(nums[j] - nums[id]) * cost[j];
                    }
                    break;
                }
            }
            return ans;
        }
    }
}
/*
2448. 使数组相等的最小开销
https://leetcode.cn/problems/minimum-cost-to-make-array-equal/

第 316 场周赛 T3。

给你两个下标从 0 开始的数组 nums 和 cost ，分别包含 n 个 正 整数。
你可以执行下面操作 任意 次：
将 nums 中 任意 元素增加或者减小 1 。
对第 i 个元素执行一次操作的开销是 cost[i] 。
请你返回使 nums 中所有元素 相等 的 最少 总开销。
提示：
n == nums.length == cost.length
1 <= n <= 10^5
1 <= nums[i], cost[i] <= 10^6

凹函数，三分法取最小值。
时间复杂度 O(nlogn)
 */