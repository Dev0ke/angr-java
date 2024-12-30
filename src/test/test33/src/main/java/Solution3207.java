import java.util.Arrays;

public class Solution3207 {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        int mn = Arrays.stream(enemyEnergies).min().orElseThrow();
        if (currentEnergy >= mn) {
            long sum = currentEnergy;
            for (int v : enemyEnergies) {
                sum += v;
            }
            return sum / mn - 1;
        }
        return 0;
    }
}
/*
3207. 与敌人战斗后的最大分数
https://leetcode.cn/problems/maximum-points-after-enemy-battles/description/

第 134 场双周赛 T2。

给你一个下标从 0 开始的整数数组 enemyEnergies ，它表示一个下标从 0 开始的敌人能量数组。
同时给你一个整数 currentEnergy ，它表示你一开始拥有的能量值总量。
你一开始的分数为 0 ，且一开始所有的敌人都未标记。
你可以通过以下操作 之一 任意次（也可以 0 次）来得分：
- 选择一个 未标记 且满足 currentEnergy >= enemyEnergies[i] 的敌人 i 。在这个操作中：
  - 你会获得 1 分。
  - 你的能量值减少 enemyEnergies[i] ，也就是说 currentEnergy = currentEnergy - enemyEnergies[i] 。
- 如果你目前 至少 有 1 分，你可以选择一个 未标记 的敌人 i 。在这个操作中：
  - 你的能量值增加 enemyEnergies[i] ，也就是说 currentEnergy = currentEnergy + enemyEnergies[i] 。
  - 敌人 i 被标记 。
请你返回通过以上操作，最多 可以获得多少分。
提示：
1 <= enemyEnergies.length <= 10^5
1 <= enemyEnergies[i] <= 10^9
0 <= currentEnergy <= 10^9

诈骗题。
只有两种情况：一个都击败不了；或者能量增加至敌人总和，然后捏软柿子，选最弱的敌人得分。
时间复杂度 O(n)。
 */