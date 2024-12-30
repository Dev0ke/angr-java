public class Solution598 {
    public int maxCount(int m, int n, int[][] ops) {
        int minM = m;
        int minN = n;
        for (int[] op : ops) {
            minM = Math.min(minM, op[0]);
            minN = Math.min(minN, op[1]);
        }
        return minM * minN;
    }
}
/*
598. 范围求和 II
https://leetcode.cn/problems/range-addition-ii/

给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
提示:
1 <= m, n <= 4 * 10^4
0 <= ops.length <= 10^4
ops[i].length == 2
1 <= ai <= m
1 <= bi <= n

求交集
时间复杂度 O(k) 其中 k = ops.length
空间复杂度 O(1)
 */