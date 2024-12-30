import java.util.ArrayList;
import java.util.List;

public class SolutionP296 {
    // 时间复杂度 O(mn)
    public int minTotalDistance(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        // 预处理
        List<Integer> rowsList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    rowsList.add(i);
                }
            }
        }
        List<Integer> colsList = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                if (grid[i][j] == 1) {
                    colsList.add(j);
                }
            }
        }

        // 中位数
        int medianRow = rowsList.get(rowsList.size() / 2);
        int medianCol = colsList.get(colsList.size() / 2);

        // 求和
        int sum = 0;
        for (int row : rowsList) {
            sum += Math.abs(row - medianRow);
        }
        for (int col : colsList) {
            sum += Math.abs(col - medianCol);
        }
        return sum;
    }

    // 时间复杂度 O(m^2 * n^2) TLE
    public int minTotalDistance2(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        // 朋友们的家
        List<int[]> friends = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    friends.add(new int[]{i, j});
                }
            }
        }

        int min = Integer.MAX_VALUE;
        // 枚举每个碰头地点
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 总行走距离 是朋友们家到碰头地点的距离之和。
                int sum = 0;
                for (int[] friend : friends) {
                    int manhattan = manhattan(friend, new int[]{i, j});
                    sum += manhattan;
                }
                min = Math.min(min, sum);
            }
        }
        return min;
    }

    private int manhattan(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
/*
$296. 最佳的碰头地点
https://leetcode.cn/problems/best-meeting-point/

给你一个 m x n  的二进制网格 grid ，其中 1 表示某个朋友的家所处的位置。返回 最小的 总行走距离 。
总行走距离 是朋友们家到碰头地点的距离之和。
我们将使用 曼哈顿距离 来计算，其中 distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y| 。
提示:
m == grid.length
n == grid[i].length
1 <= m, n <= 200
grid[i][j] == 0 or 1.
grid 中 至少 有两个朋友

乍一看是多源 BFS，实际上多源 BFS 时间复杂度为 O(m^2 * n^2) 会 TLE，
需要转化为一维中位数问题解决，时间复杂度 O(mn)
相似题目: $317. 离建筑物最近的距离
https://leetcode.cn/problems/shortest-distance-from-all-buildings/
 */