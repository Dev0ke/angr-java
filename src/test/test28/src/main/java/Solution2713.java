import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution2713 {
    private int[][] mat;
    private int[][] memo;
    private List<TreeMap<Integer, List<int[]>>> rowValMaps, colValMaps;

    // 529ms
    public int maxIncreasingCells(int[][] mat) {
        this.mat = mat;
        int m = mat.length;
        int n = mat[0].length;

        // 每 行/列 分别建 平衡树
        rowValMaps = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            rowValMaps.add(new TreeMap<>());
        }
        colValMaps = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            colValMaps.add(new TreeMap<>());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowValMaps.get(i).computeIfAbsent(mat[i][j], key -> new ArrayList<>()).add(new int[]{i, j});
                colValMaps.get(j).computeIfAbsent(mat[i][j], key -> new ArrayList<>()).add(new int[]{i, j});
                max = Math.max(max, mat[i][j]);
            }
        }

        // 记忆化搜索
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    private int dfs(int x, int y) {
        if (memo[x][y] != -1) {
            return memo[x][y];
        }
        int max = 0;
        // 只需算下一个比它大的
        Map.Entry<Integer, List<int[]>> rowHigherEntry = rowValMaps.get(x).higherEntry(mat[x][y]);
        if (rowHigherEntry != null) {
            for (int[] p : rowHigherEntry.getValue()) {
                max = Math.max(max, dfs(p[0], p[1]));
            }
        }
        Map.Entry<Integer, List<int[]>> colHigherEntry = colValMaps.get(y).higherEntry(mat[x][y]);
        if (colHigherEntry != null) {
            for (int[] p : colHigherEntry.getValue()) {
                max = Math.max(max, dfs(p[0], p[1]));
            }
        }
        return memo[x][y] = max + 1;
    }

    // 186ms 时间复杂度 O(mn * log(mn))
    public int maxIncreasingCells2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        TreeMap<Integer, List<int[]>> valMap = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valMap.computeIfAbsent(mat[i][j], key -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        int ans = 0;
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        for (Map.Entry<Integer, List<int[]>> entry : valMap.entrySet()) {
            List<int[]> pos = entry.getValue();
            int sz = pos.size();
            int[] max = new int[sz];
            for (int i = 0; i < sz; i++) {
                int x = pos.get(i)[0], y = pos.get(i)[1];
                max[i] = Math.max(rowMax[x], colMax[y]) + 1;
                ans = Math.max(ans, max[i]);
            }
            for (int i = 0; i < sz; i++) {
                int x = pos.get(i)[0], y = pos.get(i)[1];
                rowMax[x] = Math.max(rowMax[x], max[i]);
                colMax[y] = Math.max(colMax[y], max[i]);
            }
        }
        return ans;
    }
}
/*
2713. 矩阵中严格递增的单元格数
https://leetcode.cn/problems/maximum-strictly-increasing-cells-in-a-matrix/

第 347 场周赛 T4。

给你一个下标从 1 开始、大小为 m x n 的整数矩阵 mat，你可以选择任一单元格作为 起始单元格 。
从起始单元格出发，你可以移动到 同一行或同一列 中的任何其他单元格，但前提是目标单元格的值 严格大于 当前单元格的值。
你可以多次重复这一过程，从一个单元格移动到另一个单元格，直到无法再进行任何移动。
请你找出从某个单元开始访问矩阵所能访问的 单元格的最大数量 。
返回一个表示可访问单元格最大数量的整数。
提示：
m == mat.length 
n == mat[i].length 
1 <= m, n <= 10^5
1 <= m * n <= 10^5
-10^5 <= mat[i][j] <= 10^5

比赛时用了 每行每列各一棵平衡树，只需取比 ta 大的最小一个数即可。
时间复杂度 O(能过) 应该比 DP 版本多一个 log
注意 TreeSet 如果重写了 compare，会影响判重。debug 了好久，因此 java 需要用 TreeMap 来做。。
动态规划 + 优化
时间复杂度 O(mn * log(mn))
 */