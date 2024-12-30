import java.util.HashMap;
import java.util.Map;

public class Solution2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int[] tuple = map.get(arr[i]);
            int x = tuple[0], y = tuple[1];
            row[x]++;
            col[y]++;
            if (row[x] == n || col[y] == m) {
                return i;
            }
        }
        return -1;
    }
}
/*
2661. 找出叠涂元素
https://leetcode.cn/problems/first-completely-painted-row-or-column/

第 343 场周赛 T2。

给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数。
从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。
请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。
提示：
m == mat.length
n = mat[i].length
arr.length == m * n
1 <= m, n <= 10^5
1 <= m * n <= 10^5
1 <= arr[i], mat[r][c] <= m * n
arr 中的所有整数 互不相同
mat 中的所有整数 互不相同

预处理 + 行列分开统计。
时间复杂度 O(mn)
 */