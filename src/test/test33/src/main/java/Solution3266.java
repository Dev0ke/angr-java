import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution3266 {
    static final int MOD = (int) (1e9 + 7);

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) return nums;

        int n = nums.length;
        int mx = Arrays.stream(nums).max().orElseThrow();
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.val == o2.val) return Integer.compare(o1.i, o2.i);
            return Long.compare(o1.val, o2.val);
        });
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(nums[i], i));
        }

        // 模拟，直到堆顶是最大值
        while (k > 0 && pq.peek().val < mx) {
            Pair top = pq.remove();
            top.val *= multiplier;
            pq.add(top);
            k--;
        }

        // 剩余的操作可以直接用公式计算
        for (int i = 0; i < n; i++) {
            Pair top = pq.remove();
            int b = k / n + (i < k % n ? 1 : 0);
            long res = top.val % MOD * quickPow(multiplier, b) % MOD;
            nums[top.i] = (int) res;
        }
        return nums;
    }

    // 快速幂 res = a^b % mod
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    static class Pair {
        long val;
        int i;

        public Pair(long val, int i) {
            this.val = val;
            this.i = i;
        }
    }
}
/*
3266. K 次乘运算后的最终数组 II
https://leetcode.cn/problems/final-array-state-after-k-multiplication-operations-ii/description/

第 412 场周赛 T3。

给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
你需要对 nums 执行 k 次操作，每次操作中：
- 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
- 将 x 替换为 x * multiplier 。
k 次操作以后，你需要将 nums 中每一个数值对 10^9 + 7 取余。
请你返回执行完 k 次乘运算以及取余运算之后，最终的 nums 数组。
提示：
1 <= nums.length <= 10^4
1 <= nums[i] <= 10^9
1 <= k <= 10^9
1 <= multiplier <= 10^6

最小堆模拟+数学公式。
时间复杂度 O(nlogn logU)。
相似题目: 1648. 销售价值减少的颜色球
https://leetcode.cn/problems/sell-diminishing-valued-colored-balls/
2333. 最小差值平方和
https://leetcode.cn/problems/minimum-sum-of-squared-difference/
rating 2521 (clist.by)
相似题目: CF1181D
 */