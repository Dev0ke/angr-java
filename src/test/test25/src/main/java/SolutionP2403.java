import java.util.Arrays;

public class SolutionP2403 {
    private static final long INF = Long.MAX_VALUE / 2;

    public long minimumTime(int[] power) {
        int n = power.length;
        long[] f = new long[1 << n];
        Arrays.fill(f, INF);
        f[0] = 0L;
        for (int mask = 1; mask < (1 << n); mask++) {
            long total = Integer.bitCount(mask);
            for (int sub = mask; sub > 0; sub = sub & (sub - 1)) {
                int idx = Integer.bitCount((sub & (-sub)) - 1);
                // 枚举最后一个选择的怪物，那么需要 ceil(powers[idx]/total) 时间
                long time = (total + power[idx] - 1) / total;
                f[mask] = Math.min(f[mask], f[mask ^ (1 << idx)] + time);
            }
        }
        return f[(1 << n) - 1];
    }
}
/*
$2403. 杀死所有怪物的最短时间
https://leetcode.cn/problems/minimum-time-to-kill-all-monsters/

你有一个整数数组 power，其中  power[i] 是第 i 个怪物的力量。
你从 0 点法力值开始，每天获取 gain 点法力值，最初 gain 等于 1。
每天，在获得 gain 点法力值后，如果你的法力值大于或等于怪物的力量，你就可以打败怪物。当你打败怪物时:
- 你的法力值会被重置为 0，并且
- gain 的值增加 1。
返回打败所有怪物所需的 最少 天数。
提示:
1 <= power.length <= 17
1 <= power[i] <= 10^9

状态压缩动态规划。
还可以 二分图最小权匹配。
时间复杂度 O(n * 2^n)
 */