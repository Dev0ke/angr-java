import java.util.HashMap;
import java.util.Map;

public class Solution1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        // 二维前缀和
        int[][] ps2d = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                ps2d[i][j] = ps2d[i - 1][j] + ps2d[i][j - 1] - ps2d[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int ans = 0;
        for (int top = 1; top <= n; top++) {
            for (int bot = top; bot <= n; bot++) {
                Map<Integer, Integer> mp = new HashMap<>();
                for (int r = 1; r <= m; r++) {
                    int cur = ps2d[bot][r] - ps2d[top - 1][r];
                    if (cur == target) ans++;
                    ans += mp.getOrDefault(cur - target, 0);
                    mp.merge(cur, 1, Integer::sum);
                }
            }
        }
        return ans;
    }
}
/*
1074. 元素和为目标值的子矩阵数量
https://leetcode.cn/problems/number-of-submatrices-that-sum-to-target/description/

给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
提示：
1 <= matrix.length <= 100
1 <= matrix[0].length <= 100
-1000 <= matrix[i][j] <= 1000
-10^8 <= target <= 10^8

二维前缀和 + 哈希表
时间复杂度 O(n^2 * m)。
 */