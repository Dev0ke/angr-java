import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SolutionP1102 {
    public int maximumMinimumPath(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        // 去重，升序排列
        Set<Integer> chooseSet = new HashSet<>();
        // 可选择的移除的单元格不能是 [0,0] 或 [R-1,C-1]
        int min = Math.min(grid[0][0], grid[M - 1][N - 1]);
        for (int[] row : grid) {
            for (int num : row) {
                if (num <= min) {
                    chooseSet.add(num);
                }
            }
        }
        List<Integer> chooseList = new ArrayList<>(chooseSet);
        Collections.sort(chooseList);
        // 线性遍历
//        int res = chooseList.get(0);
//        for (int choose : chooseList) {
//            if (check(grid, choose)) {
//                res = choose;
//            } else {
//                return res;
//            }
//        }
        // 二分
        int left = 0;
        int right = chooseList.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(grid, chooseList.get(mid))) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return chooseList.get(left - 1);
    }

    private boolean checkMid(int[][] grid, int mid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[M][N];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                for (int[] dir : direction) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    // grid[nextM][nextN] >= mid
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && grid[nextM][nextN] >= mid && !visited[nextM][nextN]) {
                        if (nextM == M - 1 && nextN == N - 1) {
                            return true;
                        }
                        visited[nextM][nextN] = true;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
        return false;
    }
}
/*
$1102. 得分最高的路径
https://leetcode.cn/problems/path-with-maximum-minimum-value/

第 3 场双周赛 T4。

给你一个 R 行 C 列的整数矩阵 A。矩阵上的路径从 [0,0] 开始，在 [R-1,C-1] 结束。
路径沿四个基本方向（上、下、左、右）展开，从一个已访问单元格移动到任一相邻的未访问单元格。
路径的得分是该路径上的 最小 值。例如，路径 8 →  4 →  5 →  9 的值为 4 。
找出所有路径中得分 最高 的那条路径，返回其 得分。
提示：
1 <= R, C <= 100
0 <= A[i][j] <= 10^9

数据量 100，由于是矩阵 O(n^2) 起步，10^4。若对每个元素进行线性枚举，数量级会去到 10^8 会超时。因此考虑使用二分优化。
时间复杂度 O(n^2 log(n^2))
 */