import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution864 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestPathAllKeys(String[] grid) {
        int M = grid.length;
        int N = grid[0].length();
        // 起点坐标，钥匙数量
        int sx = 0, sy = 0, cntKey = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    sx = i;
                    sy = j;
                } else if (Character.isLowerCase(ch)) {
                    // 钥匙
                    cntKey++;
                }
            }
        }

        // x, y, mask
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy, 0});
        int[][][] dist = new int[M][N][1 << cntKey];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        dist[sx][sy][0] = 0;
        // 获得所有钥匙
        int FULL = (1 << cntKey) - 1;
        while (!queue.isEmpty()) {
            int[] tuple = queue.remove();
            int cx = tuple[0], cy = tuple[1], cmask = tuple[2];
            int step = dist[cx][cy][cmask];
            if (cmask == FULL) {
                return step;
            }

            for (int[] dir : DIRECTIONS) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    char ch = grid[nx].charAt(ny);
                    if (ch == '#') continue;
                    // 锁 且 未开
                    if (Character.isUpperCase(ch)) {
                        if ((cmask >> (ch - 'A') & 1) == 0) continue;
                    }
                    int nmask = cmask;
                    if (Character.isLowerCase(ch)) {
                        nmask |= 1 << (ch - 'a');
                    }
                    if (dist[nx][ny][nmask] > step + 1) {
                        dist[nx][ny][nmask] = step + 1;
                        queue.add(new int[]{nx, ny, nmask});
                    }
                }
            }
        }
        return -1;
    }
}
/*
864. 获取所有钥匙的最短路径
https://leetcode.cn/problems/shortest-path-to-get-all-keys/

给定一个二维网格 grid ，其中：
- '.' 代表一个空房间
- '#' 代表一堵
- '@' 是起点
- 小写字母代表钥匙
- 大写字母代表锁
我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。
我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
假设 k 为 钥匙/锁 的个数，且满足 1 <= k <= 6，字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母。
换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 30
grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
钥匙的数目范围是 [1, 6] 
每个钥匙都对应一个 不同 的字母
每个钥匙正好打开一个对应的锁

状态压缩 + BFS
时间复杂度 O(mn*2^k)
方法一: 暴力+枚举 因为钥匙的数目范围不超过 6，可以枚举每种钥匙组合。时间复杂度 O(m*n*A*A!) 理论上界 3,888,000
方法二: 关键点+dijkstra
官方题解: https://leetcode.cn/problems/shortest-path-to-get-all-keys/solution/huo-qu-suo-you-yao-chi-de-zui-duan-lu-jing-by-leet/
 */