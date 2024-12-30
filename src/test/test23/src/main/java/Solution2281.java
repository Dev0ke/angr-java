import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2281 {
    private static final int MOD = (int) (1e9 + 7);

    public int totalStrength(int[] strength) {
        int n = strength.length;

        // step1: 求左侧第一个 "严格小于" arr[i] 的下标，如没有则为 -1
        Deque<Integer> stack1 = new ArrayDeque<>();
        int[] left = new int[n];
        Arrays.fill(left, -1);
        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && strength[i] <= strength[stack1.peek()]) {
                stack1.pop();
            }
            if (!stack1.isEmpty()) {
                left[i] = stack1.peek();
            }
            stack1.push(i);
        }

        // step2: 求右侧第一个 "小于等于" arr[i] 的下标，如没有则为 n
        Deque<Integer> stack2 = new ArrayDeque<>();
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = n - 1; i >= 0; i--) {
            // <= 为避免重复计算
            while (!stack2.isEmpty() && strength[i] < strength[stack2.peek()]) {
                stack2.pop();
            }
            if (!stack2.isEmpty()) {
                right[i] = stack2.peek();
            }
            stack2.push(i);
        }

        // 前缀和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + strength[i];
        }
        // 前缀和的前缀和
        long[] ss = new long[n + 2];
        for (int i = 0; i < n + 1; i++) {
            ss[i + 1] = ss[i] + preSum[i];
            // attention
            ss[i + 1] %= MOD;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i] + 1;
            int r = right[i] - 1;

            long rangeSums = ((i - l + 1L) * (ss[r + 2] - ss[i + 1]) - (r - i + 1L) * (ss[i + 1] - ss[l])) % MOD;
            sum += strength[i] * rangeSums % MOD;
            sum %= MOD;
        }

        // attention
        return (int) ((sum + MOD) % MOD);
    }

    // O(n^2) TLE
    public int totalStrength2(int[] strength) {
        int len = strength.length;

        long ans = 0;
        for (int i = 0; i < len; i++) {
            long min = strength[i];
            long sum = 0;
            for (int j = i; j < len; j++) {
                min = Math.min(min, strength[j]);
                sum += strength[j];
                long res = min * sum % MOD;
                ans = (ans + res) % MOD;
            }
        }
        return (int) ans;
    }
}
/*
2281. 巫师的总力量和
https://leetcode.cn/problems/sum-of-total-strength-of-wizards/

第 294 场周赛 T4。

作为国王的统治者，你有一支巫师军队听你指挥。
给你一个下标从 0 开始的整数数组 strength ，其中 strength[i] 表示第 i 位巫师的力量值。
对于连续的一组巫师（也就是这些巫师的力量值是 strength 的 子数组），总力量 定义为以下两个值的 乘积 ：
- 巫师中 最弱 的能力值。
- 组中所有巫师的个人力量值 之和 。
请你返回 所有 巫师组的 总 力量之和。由于答案可能很大，请将答案对 10^9 + 7 取余 后返回。
子数组 是一个数组里 非空 连续子序列。
提示：
1 <= strength.length <= 10^5
1 <= strength[i] <= 10^9

单调栈 + 前缀和的前缀和
时间复杂度 O(n)
相似题目: 907. 子数组的最小值之和
https://leetcode.cn/problems/sum-of-subarray-minimums/
1508. 子数组和排序后的区间和
https://leetcode.cn/problems/range-sum-of-sorted-subarray-sums/
1856. 子数组最小乘积的最大值
https://leetcode.cn/problems/maximum-subarray-min-product/
2104. 子数组范围和
https://leetcode.cn/problems/sum-of-subarray-ranges/
 */