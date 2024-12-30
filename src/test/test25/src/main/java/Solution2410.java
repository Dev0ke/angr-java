import java.util.Arrays;

public class Solution2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        // 双指针
        int p1 = 0;
        int p2 = 0;
        int cnt = 0;
        while (p1 < players.length && p2 < trainers.length) {
            if (players[p1] <= trainers[p2]) {
                cnt++;
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        return cnt;
    }
}
/*
2410. 运动员和训练师的最大匹配数
https://leetcode.cn/problems/maximum-matching-of-players-with-trainers/

第 87 场双周赛 T2。

给你一个下标从 0 开始的整数数组 players ，其中 players[i] 表示第 i 名运动员的 能力 值，
同时给你一个下标从 0 开始的整数数组 trainers ，其中 trainers[j] 表示第 j 名训练师的 训练能力值 。
如果第 i 名运动员的能力值 小于等于 第 j 名训练师的能力值，那么第 i 名运动员可以 匹配 第 j 名训练师。
除此以外，每名运动员至多可以匹配一位训练师，每位训练师最多可以匹配一位运动员。
请你返回满足上述要求 players 和 trainers 的 最大 匹配数。
提示：
1 <= players.length, trainers.length <= 10^5
1 <= players[i], trainers[j] <= 10^9

排序 + 双指针。
时间复杂度 O(nlogn) 为排序时间复杂度。
 */