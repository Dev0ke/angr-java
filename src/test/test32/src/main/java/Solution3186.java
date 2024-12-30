import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3186 {
    private int[] power;
    private Map<Integer, Integer> cnt;
    private long[] memo;

    public long maximumTotalDamage(int[] power) {
        this.power = power;
        Arrays.sort(power);
        cnt = new HashMap<>();
        for (int v : power) {
            cnt.merge(v, 1, Integer::sum);
        }

        int n = power.length;
        memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(0);
    }

    private long dfs(int i) {
        if (i >= power.length) return 0;
        if (memo[i] != -1) return memo[i];
        // 不选
        long res = dfs(i + 1);
        // 选
        int j = lowerBound(power, power[i] + 3);
        long damage = (long) power[i] * cnt.get(power[i]);
        res = Math.max(res, dfs(j) + damage);
        return memo[i] = res;
    }

    private int lowerBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
3186. 施咒的最大总伤害
https://leetcode.cn/problems/maximum-total-damage-with-spell-casting/description/

第 402 场周赛 T3。

一个魔法师有许多不同的咒语。
给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。
已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] + 1 或者 power[i] + 2 的咒语。
每个咒语最多只能被使用 一次 。
请你返回这个魔法师可以达到的伤害值之和的 最大值 。
提示：
1 <= power.length <= 10^5
1 <= power[i] <= 10^9

记忆化搜索。
时间复杂度 O(nlogn)。
赛时写成 O(n^2) 了。。
相似题目: 740. 删除并获得点数
https://leetcode.cn/problems/delete-and-earn/
 */