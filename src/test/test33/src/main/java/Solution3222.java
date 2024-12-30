public class Solution3222 {
    public String losingPlayer(int x, int y) {
        boolean alice = false;
        while (x >= 1 && y >= 4) {
            x -= 1;
            y -= 4;
            alice = !alice;
        }
        return alice ? "Alice" : "Bob";
    }

    // O(1) 数学法
    public String losingPlayer2(int x, int y) {
        return Math.min(x, y / 4) % 2 == 0 ? "Bob" : "Alice";
    }
}
/*
3222. 求出硬币游戏的赢家
https://leetcode.cn/problems/find-the-winning-player-in-coin-game/description/

第 135 场双周赛 T1。

给你两个 正 整数 x 和 y ，分别表示价值为 75 和 10 的硬币的数目。
Alice 和 Bob 正在玩一个游戏。每一轮中，Alice 先进行操作，Bob 后操作。每次操作中，玩家需要拿出价值 总和 为 115 的硬币。如果一名玩家无法执行此操作，那么这名玩家 输掉 游戏。
两名玩家都采取 最优 策略，请你返回游戏的赢家。
提示：
1 <= x, y <= 100

模拟。
时间复杂度 O(min(x, y/4))。
 */