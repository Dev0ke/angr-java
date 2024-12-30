import java.math.BigInteger;

public class Solution1981 {
    // 58ms，击败 95.12%
    public int minimizeTheDifference(int[][] mat, int target) {
        BigInteger f = BigInteger.ONE;
        for (int[] row : mat) {
            BigInteger g = BigInteger.ZERO;
            for (int x : row) {
                g = g.or(f.shiftLeft(x));
            }
            f = g;
        }

        for (int d = 0; ; d++) {
            if (f.testBit(target + d) || target > d && (f.testBit(target - d))) {
                return d;
            }
        }
    }
}
/*
1981. 最小化目标值与所选元素的差
https://leetcode.cn/problems/minimize-the-difference-between-target-and-chosen-elements/

第 255 场周赛 T3。

给你一个大小为 m x n 的整数矩阵 mat 和一个整数 target 。
从矩阵的 每一行 中选择一个整数，你的目标是 最小化 所有选中元素之 和 与目标值 target 的 绝对差 。
返回 最小的绝对差 。
a 和 b 两数字的 绝对差 是 a - b 的绝对值。
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 70
1 <= mat[i][j] <= 70
1 <= target <= 800

bitset/bigint 优化
相似题目: 3181. 执行操作可获得的最大总奖励 II
https://leetcode.cn/problems/maximum-total-reward-using-operations-ii/description/
 */