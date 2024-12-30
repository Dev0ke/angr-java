import java.util.Arrays;

public class SolutionP1198 {
    public int smallestCommonElement(int[][] mat) {
        for (int j = 0; j < mat[0].length; j++) {
            if (check(mat, mat[0][j])) {
                return mat[0][j];
            }
        }
        return -1;
    }

    // O(mlogn)
    private boolean check(int[][] mat, int num) {
        for (int i = 1; i < mat.length; i++) {
            if (Arrays.binarySearch(mat[i], num) < 0) {
                return false;
            }
        }
        return true;
    }
}
/*
$1198. 找出所有行中最小公共元素
https://leetcode.cn/problems/find-smallest-common-element-in-all-rows/

给你一个 m x n 的矩阵 mat，其中每一行的元素均符合 严格递增 。请返回 所有行中的 最小公共元素 。
如果矩阵中没有这样的公共元素，就请返回 -1。
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 10^4
mat[i] 已按严格递增顺序排列。

二分，可直接用库函数。
时间复杂度 O(mn logn)
 */