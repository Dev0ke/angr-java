public class Solution3360 {
    public boolean canAliceWin(int n) {
        boolean alice_win = false;
        int x = 10;
        while (n >= x) {
            n -= x;
            x--;
            alice_win = !alice_win;
        }
        return alice_win;
    }
}
/*
3360. 移除石头游戏
https://leetcode.cn/problems/stone-removal-game/description/

第 144 场双周赛 T1。

Alice 和 Bob 在玩一个游戏，他们俩轮流从一堆石头中移除石头，Alice 先进行操作。
- Alice 在第一次操作中移除 恰好 10 个石头。
- 接下来的每次操作中，每位玩家移除的石头数 恰好 为另一位玩家上一次操作的石头数减 1 。
第一位没法进行操作的玩家输掉这个游戏。
给你一个正整数 n 表示一开始石头的数目，如果 Alice 赢下这个游戏，请你返回 true ，否则返回 false 。
提示：
1 <= n <= 50

模拟。
 */