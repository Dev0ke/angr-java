import java.math.BigInteger;
import java.util.Arrays;

public class Solution3181 {
    public int maxTotalReward(int[] rewardValues) {
        BigInteger f = BigInteger.ONE;
        for (int v : Arrays.stream(rewardValues).distinct().sorted().toArray()) {
            BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE);
            f = f.or(f.and(mask).shiftLeft(v));
        }
        return f.bitLength() - 1;
    }

    public int maxTotalReward2(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n = rewardValues.length;
        int m = rewardValues[n - 1];
        long[] f = new long[2 * m / 64 + 1];
        f[0] |= 1;
        for (int v : rewardValues) {
            int idx = (v - 1) / 64;
            process(f, idx, v);
        }
        for (int i = f.length - 1; i >= 0; i--) {
            if (f[i] != 0) {
                return 64 * i + 64 - Long.numberOfLeadingZeros(f[i]) - 1;
            }
        }
        return 0;
    }

    private void process(long[] f, int idx, int v) {
        int shiftLeft = v % 64;
        if (shiftLeft == 0) {
            for (int i = 0; i <= idx; i++) {
                f[i + idx + 1] |= f[i];
            }
            return;
        }
        long cur = f[idx] & ((1L << shiftLeft) - 1);
        for (int i = 0; i < idx; i++) {
            f[idx + i] |= f[i] << shiftLeft;
            f[idx + i + 1] |= f[i] >>> (64 - shiftLeft);
        }
        f[idx + idx] |= cur << shiftLeft;
        if (cur >> (64 - shiftLeft) != 0) {
            f[idx + idx + 1] |= cur >>> (64 - shiftLeft);
        }
    }
}
/*
3181. 执行操作可获得的最大总奖励 II
https://leetcode.cn/problems/maximum-total-reward-using-operations-ii/description/

第 401 场周赛 T4。

给你一个整数数组 rewardValues，长度为 n，代表奖励的值。
最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ：
- 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。
- 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x + rewardValues[i]），并 标记 下标 i。
以整数形式返回执行最优操作能够获得的 最大 总奖励。
提示：
1 <= rewardValues.length <= 5 * 10^4
1 <= rewardValues[i] <= 5 * 10^4

bitset/bigint 优化 0-1 背包。
时间复杂度 O(nk / 64)。
先选大的，再选小的 -> 不行
先选小的，再选大的
---
从数组中选一个子序列，子序列的和尽可能大
0-1 背包
---
f[i][j] 表示能否从前 i 个数红，选出和为 j 的子序列
---
考虑 v = rewardValues[i] 选或不选
不选：f[i][j] = f[i-1][j]
选  ：f[i][j] = f[i-1][j-v]  0 <= j-v < v
---
f[i][j] = f[i-1][j] or f[i-1][j-v]
---
class Solution:
    def maxTotalReward(self, rewardValues: List[int]) -> int:
        f = 1
        for v in sorted(set(rewardValues)):
            mask = (1 << v) - 1
            f |= (f & mask) << v
        return f.bit_length() - 1
rating 2706 (clist.by)
相似题目: 1981. 最小化目标值与所选元素的差
https://leetcode.cn/problems/minimize-the-difference-between-target-and-chosen-elements/
 */