import java.util.ArrayList;
import java.util.List;

public class SolutionP361 {
    private int[][] array;

    public int maxKilledEnemies(char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        this.array = new int[M][N];

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'E') {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int[] cur : list) {
            boom(grid, cur[0], cur[1]);
        }

        // max
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, array[i][j]);
            }
        }
        return max;
    }

    private void boom(char[][] grid, int m, int n) {
        // left
        int left = m;
        while (left > 0) {
            left--;
            if (grid[left][n] == 'W') {
                break;
            }
            if (grid[left][n] == '0') {
                array[left][n] += 1;
            }
        }
        // right
        int right = m;
        while (right < grid.length - 1) {
            right++;
            if (grid[right][n] == 'W') {
                break;
            }
            if (grid[right][n] == '0') {
                array[right][n] += 1;
            }
        }
        // up
        int up = n;
        while (up > 0) {
            up--;
            if (grid[m][up] == 'W') {
                break;
            }
            if (grid[m][up] == '0') {
                array[m][up] += 1;
            }
        }
        // down
        int down = n;
        while (down < grid[0].length - 1) {
            down++;
            if (grid[m][down] == 'W') {
                break;
            }
            if (grid[m][down] == '0') {
                array[m][down] += 1;
            }
        }
    }
}
/*
$361. 轰炸敌人
https://leetcode.cn/problems/bomb-enemy/

给你一个大小为 m x n 的矩阵 grid ，其中每个单元格都放置有一个字符：
- 'W' 表示一堵墙
- 'E' 表示一个敌人
- '0'（数字 0）表示一个空位
返回你使用 一颗炸弹 可以击杀的最大敌人数目。你只能把炸弹放在一个空位里。
由于炸弹的威力不足以穿透墙体，炸弹只能击杀同一行和同一列没被墙体挡住的敌人。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] 可以是 'W'、'E' 或 '0'

暴力枚举，数据量不大，可以枚举每个炸弹爆炸造成的影响，时间复杂度 O(mn(m+n)) 最多有 mn 个炸弹，每个炸弹延申 m+n 个格子。
也可以枚举每个敌人能被炸到的位置，时间复杂度 O(mn(m+n)) 最多有 mn 个敌人，每个敌人延申 m+n 个格子。
本题有动态规划的标签。
 */