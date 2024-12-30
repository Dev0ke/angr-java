public class Solution1219 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int[][] grid;
    private int M;
    private int N;
    private int max;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        M = grid.length;
        N = grid[0].length;
        max = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    dfs(i, j, 0);
                }
            }
        }
        return max;
    }

    private void dfs(int i, int j, int sum) {
        int tmp = grid[i][j];
        sum += tmp;
        max = Math.max(max, sum);
        grid[i][j] = 0;
        for (int[] dir : DIRECTIONS) {
            int nextM = i + dir[0];
            int nextN = j + dir[1];
            if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N
                    && grid[nextM][nextN] != 0) {
                dfs(nextM, nextN, sum);
            }
        }
        grid[i][j] = tmp;
    }
}
/*
1219. 黄金矿工
https://leetcode.cn/problems/path-with-maximum-gold/

你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。
每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
为了使收益最大化，矿工需要按以下规则来开采黄金：
- 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
- 矿工每次可以从当前位置向上下左右四个方向走。
- 每个单元格只能被开采（进入）一次。
- 不得开采（进入）黄金数目为 0 的单元格。
- 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
提示：
1 <= grid.length, grid[i].length <= 15
0 <= grid[i][j] <= 100
最多 25 个单元格中有黄金。

DFS
时间复杂度 O(k·3^k) 其中 k 最大可取到 25，理论上界 3^25 = 847,288,609,443，关于为什么不会 TLE 的疑问需参考：hqztrue 大佬的
https://leetcode.cn/problems/path-with-maximum-gold/solution/fu-za-du-fen-xi-wei-shi-yao-dfsbu-hui-ch-0v9f/
 */