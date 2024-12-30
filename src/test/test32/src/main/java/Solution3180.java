import java.util.Arrays;

public class Solution3180 {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        Arrays.sort(rewardValues);
        int k = rewardValues[n - 1];
        int[] f = new int[k];
        for (int v : rewardValues) {
            for (int j = k - 1; j >= v; j--) {
                int x = v > j - v ? j - v : v - 1;
                f[j] = Math.max(f[j], v + f[x]);
            }
        }
        return f[k - 1] + k;
    }
}
/*
3180. 执行操作可获得的最大总奖励 I
https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/

第 401 场周赛 T3。

给你一个整数数组 rewardValues，长度为 n，代表奖励的值。
最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ：
- 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。
- 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x + rewardValues[i]），并 标记 下标 i。
以整数形式返回执行最优操作能够获得的 最大 总奖励。
提示：
1 <= rewardValues.length <= 2000
1 <= rewardValues[i] <= 2000

0-1 背包。
时间复杂度 O(nk)。
 */