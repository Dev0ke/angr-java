public class Solution2660 {
    public int isWinner(int[] player1, int[] player2) {
        int sum1 = getSum(player1);
        int sum2 = getSum(player2);
        if (sum1 == sum2) {
            return 0;
        }
        return sum1 > sum2 ? 1 : 2;
    }

    private int getSum(int[] player) {
        int n = player.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            if (i - 1 >= 0) {
                if (player[i - 1] == 10) {
                    flag = true;
                }
            }
            if (i - 2 >= 0) {
                if (player[i - 2] == 10) {
                    flag = true;
                }
            }
            sum += flag ? player[i] + player[i] : player[i];
        }
        return sum;
    }
}
/*
2660. 保龄球游戏的获胜者
https://leetcode.cn/problems/determine-the-winner-of-a-bowling-game/

第 343 场周赛 T1。

给你两个下标从 0 开始的整数数组 player1 和 player2 ，分别表示玩家 1 和玩家 2 击中的瓶数。
保龄球比赛由 n 轮组成，每轮的瓶数恰好为 10 。
假设玩家在第 i 轮中击中 xi 个瓶子。玩家第 i 轮的价值为：
- 如果玩家在该轮的前两轮的任何一轮中击中了 10 个瓶子，则为 2xi 。
- 否则，为 xi 。
玩家的得分是其 n 轮价值的总和。
返回
- 如果玩家 1 的得分高于玩家 2 的得分，则为 1 ；
- 如果玩家 2 的得分高于玩家 1 的得分，则为 2 ；
- 如果平局，则为 0 。
提示：
n == player1.length == player2.length
1 <= n <= 1000
0 <= player1[i], player2[i] <= 10

模拟。
注意题目有歧义。。
时间复杂度 O(n)
 */