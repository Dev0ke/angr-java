import java.util.HashMap;
import java.util.Map;

public class SolutionP750 {
    public int countCornerRectangles(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        Map<String, Integer> cntMap = new HashMap<>();
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j1 = 0; j1 < N; j1++) {
                if (grid[i][j1] == 1) {
                    for (int j2 = j1 + 1; j2 < N; j2++) {
                        if (grid[i][j2] == 1) {
                            String key = j1 + ":" + j2;
                            int value = cntMap.getOrDefault(key, 0);
                            res += value;
                            cntMap.put(key, value + 1);
                        }
                    }
                }
            }
        }
        return res;
    }
}
/*
$750. 角矩形的数量
https://leetcode.cn/problems/number-of-corner-rectangles/

给定一个只包含 0 和 1 的 m x n 整数矩阵 grid ，返回 其中 「角矩形 」的数量 。
一个「角矩形」是由四个不同的在矩阵上的 1 形成的轴对称的矩形。注意只有角的位置才需要为 1。
注意：4 个 1 的位置需要是不同的。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 200
grid[i][j] 不是 0 就是 1
网格中 1 的个数在 [1, 6000] 范围内

时间复杂度 O(m*n^2)
 */