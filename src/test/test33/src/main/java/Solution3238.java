public class Solution3238 {
    public int winningPlayerCount(int n, int[][] pick) {
        int MAX_Y = 10;
        int[][] cnt = new int[n][MAX_Y + 1];
        for (int[] p : pick) {
            int x = p[0], y = p[1];
            cnt[x][y]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int c : cnt[i]) {
                if (c > i) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
/*
3238. 求出胜利玩家的数目
https://leetcode.cn/problems/find-the-number-of-winning-players/description/

第 136 场双周赛 T1。

给你一个整数 n ，表示在一个游戏中的玩家数目。同时给你一个二维整数数组 pick ，其中 pick[i] = [xi, yi] 表示玩家 xi 获得了一个颜色为 yi 的球。
如果玩家 i 获得的球中任何一种颜色球的数目 严格大于 i 个，那么我们说玩家 i 是胜利玩家。换句话说：
- 如果玩家 0 获得了任何的球，那么玩家 0 是胜利玩家。
- 如果玩家 1 获得了至少 2 个相同颜色的球，那么玩家 1 是胜利玩家。
- ...
- 如果玩家 i 获得了至少 i + 1 个相同颜色的球，那么玩家 i 是胜利玩家。
请你返回游戏中 胜利玩家 的数目。
注意，可能有多个玩家是胜利玩家。
提示：
2 <= n <= 10
1 <= pick.length <= 100
pick[i].length == 2
0 <= xi <= n - 1
0 <= yi <= 10

模拟。
时间复杂度 O(m + n)。其中 m = pick.length。
 */