import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int[][] a = new int[2][n];
        for (int j = 0; j < n; j++) {
            if (colsum[j] == 2) {
                a[0][j] = 1;
                a[1][j] = 1;
                upper--;
                lower--;
            }
            if (colsum[j] == 1) {
                if (upper > lower) {
                    a[0][j] = 1;
                    upper--;
                } else {
                    a[1][j] = 1;
                    lower--;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        if (lower != 0 || upper != 0) {
            return ans;
        }

        for (int i = 0; i < 2; i++) {
            ans.add(Arrays.stream(a[i]).boxed().toList());
        }
        return ans;
    }
}
/*
1253. 重构 2 行二进制矩阵
https://leetcode.cn/problems/reconstruct-a-2-row-binary-matrix/description/

给你一个 2 行 n 列的二进制数组：
- 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
- 第 0 行的元素之和为 upper。
- 第 1 行的元素之和为 lower。
- 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
如果有多个不同的答案，那么任意一个都可以通过本题。
如果不存在符合要求的答案，就请返回一个空的二维数组。
提示：
1 <= colsum.length <= 10^5
0 <= upper, lower <= colsum.length
0 <= colsum[i] <= 2

贪心。
- colsum[j] = 2 时，两行都是 1。
- colsum[j] = 0 时，两行都是 0。
- 关键点在于 colsum[j] = 1 时，哪行大往哪行填 1。
时间复杂度 O(mn)。
相似题目: 1605. 给定行和列的和求可行矩阵
https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums/
 */