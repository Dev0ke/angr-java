import java.util.HashSet;
import java.util.Set;

public class Solution2718 {
    public long matrixSumQueries(int n, int[][] queries) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        long ans = 0L;
        int q = queries.length;
        for (int i = q - 1; i >= 0; i--) {
            int type = queries[i][0], index = queries[i][1], val = queries[i][2];
            if (type == 0) {
                if (rows.contains(index)) continue;
                ans += (long) (n - cols.size()) * val;
                rows.add(index);
            } else {
                if (cols.contains(index)) continue;
                ans += (long) (n - rows.size()) * val;
                cols.add(index);
            }
        }
        return ans;
    }
}
/*
2718. 查询后矩阵的和
https://leetcode.cn/problems/sum-of-matrix-after-queries/

第 348 场周赛 T3。

给你一个整数 n 和一个下标从 0 开始的 二维数组 queries ，其中 queries[i] = [typei, indexi, vali] 。
一开始，给你一个下标从 0 开始的 n x n 矩阵，所有元素均为 0 。每一个查询，你需要执行以下操作之一：
- 如果 typei == 0 ，将第 indexi 行的元素全部修改为 vali ，覆盖任何之前的值。
- 如果 typei == 1 ，将第 indexi 列的元素全部修改为 vali ，覆盖任何之前的值。
请你执行完所有查询以后，返回矩阵中所有整数的和。
提示：
1 <= n <= 10^4
1 <= queries.length <= 5 * 10^4
queries[i].length == 3
0 <= typei <= 1
0 <= indexi < n
0 <= vali <= 10^5

后往前。LCP 的前车之鉴。
LCP 52. 二叉搜索树染色
https://leetcode.cn/problems/QO5KpG/
时间复杂度 O(q)
 */