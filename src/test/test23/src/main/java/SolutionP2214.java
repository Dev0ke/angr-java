public class SolutionP2214 {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0, mx = 0;
        for (int v : damage) {
            sum += v;
            mx = Math.max(mx, v);
        }
        return sum - Math.min(armor, mx) + 1;
    }
}
/*
$2214. 通关游戏所需的最低生命值
https://leetcode.cn/problems/minimum-health-to-beat-game/description/

你正在玩一个有 n 个关卡的游戏，从 0 到 n - 1。给你一个 下标从 0 开始 的整数数组 damage，其中 damage[i] 是你完成第 i 个关卡所损失的生命值。
你也会得到一个整数 armor。你最多只能在 任何 等级使用 一次 护甲技能，这将保护你免受 最多 armor 伤害。
你必须按顺序完成关卡，并且你的生命值必须一直 大于 0 才能通关。
返回你开始通关所需的最低生命值。
提示:
n == damage.length
1 <= n <= 10^5
0 <= damage[i] <= 10^5
0 <= armor <= 10^5

贪心。只要让 armor 最大化的时用即可。
 */