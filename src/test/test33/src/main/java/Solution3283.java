import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution3283 {
    private static final int[][] DIRECTIONS9 = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
    private int kx, ky;
    private int[][] positions;
    private int[][][] dist;
    private int[][] memo;

    public int maxMoves(int kx, int ky, int[][] positions) {
        this.kx = kx;
        this.ky = ky;
        this.positions = positions;

        int n = positions.length;
        // 计算马到兵的步数，等价于计算兵到其余格子的步数
        dist = new int[n][50][50];
        for (int i = 0; i < n; i++) {
            int[][] dis = dist[i];
            for (int j = 0; j < 50; j++) {
                Arrays.fill(dis[j], -1);
            }
            int px = positions[i][0], py = positions[i][1];
            dis[px][py] = 0;
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{px, py});
            int step = 1;
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int j = 0; j < sz; j++) {
                    int[] top = q.remove();
                    int cx = top[0], cy = top[1];
                    for (int[] d : DIRECTIONS9) {
                        int nx = cx + d[0];
                        int ny = cy + d[1];
                        if (0 <= nx && nx < 50 && 0 <= ny && ny < 50 && dis[nx][ny] < 0) {
                            dis[nx][ny] = step;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
                step++;
            }
        }

        memo = new int[n + 1][1 << n];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(n, (1 << n) - 1);
    }

    private int dfs(int i, int mask) {
        if (mask == 0) return 0;
        if (memo[i][mask] != -1) return memo[i][mask];

        int n = positions.length;
        int x = i < n ? positions[i][0] : kx;
        int y = i < n ? positions[i][1] : ky;

        int res = 0;
        int u = (1 << n) - 1;
        if (Integer.bitCount(u ^ mask) % 2 == 0) { // Alice 操作
            for (int j = 0; j < n; j++) {
                if ((mask >> j & 1) == 1) {
                    res = Math.max(res, dfs(j, mask ^ (1 << j)) + dist[j][x][y]);
                }
            }
        } else { // Bob 操作
            res = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if ((mask >> j & 1) == 1) {
                    res = Math.min(res, dfs(j, mask ^ (1 << j)) + dist[j][x][y]);
                }
            }
        }
        return memo[i][mask] = res;
    }
}
/*
3283. 吃掉所有兵需要的最多移动次数
https://leetcode.cn/problems/maximum-number-of-moves-to-kill-all-pawns/description/

第 414 场周赛 T4。

给你一个 50 x 50 的国际象棋棋盘，棋盘上有 一个 马和一些兵。给你两个整数 kx 和 ky ，其中 (kx, ky) 表示马所在的位置，同时还有一个二维数组 positions ，其中 positions[i] = [xi, yi] 表示第 i 个兵在棋盘上的位置。
Alice 和 Bob 玩一个回合制游戏，Alice 先手。玩家的一次操作中，可以执行以下操作：
- 玩家选择一个仍然在棋盘上的兵，然后移动马，通过 最少 的 步数 吃掉这个兵。注意 ，玩家可以选择 任意 一个兵，不一定 要选择从马的位置出发 最少 移动步数的兵。
- 在马吃兵的过程中，马 可能 会经过一些其他兵的位置，但这些兵 不会 被吃掉。只有 选中的兵在这个回合中被吃掉。
Alice 的目标是 最大化 两名玩家的 总 移动次数，直到棋盘上不再存在兵，而 Bob 的目标是 最小化 总移动次数。
假设两名玩家都采用 最优 策略，请你返回可以达到的 最大 总移动次数。
在一次 移动 中，如下图所示，马有 8 个可以移动到的位置，每个移动位置都是沿着坐标轴的一个方向前进 2 格，然后沿着垂直的方向前进 1 格。
提示：
0 <= kx, ky <= 49
1 <= positions.length <= 15
positions[i].length == 2
0 <= positions[i][0], positions[i][1] <= 49
positions[i] 两两互不相同。
输入保证对于所有 0 <= i < positions.length ，都有 positions[i] != [kx, ky] 。

相邻相关排列型状压 DP。记忆化搜索。
https://leetcode.cn/problems/maximum-number-of-moves-to-kill-all-pawns/solutions/2909069/pai-lie-xing-zhuang-ya-dpxiang-lin-xiang-q49q/
时间复杂度 O(nL^2 + n^2 * 2^n)。其中 n = positions.length, L = 50。
rating 2488 (clist.by)
 */