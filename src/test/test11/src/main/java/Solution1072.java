import java.util.HashMap;
import java.util.Map;

public class Solution1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;

        int ans = 0;
        Map<String, Integer> cntMap = new HashMap<>();
        for (int[] row : matrix) {
            char[] cs = new char[n];
            for (int j = 0; j < n; j++) {
                cs[j] = (char) (row[j] ^ row[0]);
            }
            String s = new String(cs);
            cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
            ans = Math.max(ans, cntMap.get(s));
        }
        return ans;
    }
}
/*
1072. 按列翻转得到最大值等行数
https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows/

给定 m x n 矩阵 matrix 。
你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。）
返回 经过一些翻转后，行内所有值都相等的最大行数 。
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] == 0 或 1

哈希表
时间复杂度 O(mn)
空间复杂度 O(m)
 */