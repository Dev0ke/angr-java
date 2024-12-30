public class Solution1267 {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 预处理 当前 行/列 各有多少服务器
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] += grid[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                cols[j] += grid[i][j];
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
1267. 统计参与通信的服务器
https://leetcode.cn/problems/count-servers-that-communicate/

这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
提示：
m == grid.length
n == grid[i].length
1 <= m <= 250
1 <= n <= 250
grid[i][j] == 0 or 1

问题等价于：服务器所在的 行/列 存在大于 1 台服务器。可以先预处理各 行/列 的服务器数量，再在 O(1) 内求解
时间复杂度 O(mn)
空间复杂度 O(m+n)
 */
