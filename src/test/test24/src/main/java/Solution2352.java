import java.util.HashMap;
import java.util.Map;

public class Solution2352 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        // 列
        Map<String, Integer> colMap = new HashMap<>();
        for (int j = 0; j < n; j++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(grid[i][j]).append(",");
            }
            String col = stringBuilder.toString();
            colMap.put(col, colMap.getOrDefault(col, 0) + 1);
        }

        int cnt = 0;
        // 行
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                stringBuilder.append(grid[i][j]).append(",");
            }
            String row = stringBuilder.toString();
            cnt += colMap.getOrDefault(row, 0);
        }
        return cnt;
    }
}
/*
2352. 相等行列对
https://leetcode.cn/problems/equal-row-and-column-pairs/

第 303 场周赛 T2。

给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
提示：
n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 10^5

用 HashMap 先预处理 行/列，再在时间复杂度 O(1) 内出结果
时间复杂度 O(n^2)
 */