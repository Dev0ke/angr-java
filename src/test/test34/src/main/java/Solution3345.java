public class Solution3345 {
    public int smallestNumber(int n, int t) {
        while (digitProd(n) % t != 0) {
            n++;
        }
        return n;
    }

    private int digitProd(int x) {
        int res = 1;
        while (x > 0) {
            res *= x % 10;
            x /= 10;
        }
        return res;
    }
}
/*
3345. 最小可整除数位乘积 I
https://leetcode.cn/problems/smallest-divisible-digit-product-i/description/

第 143 场双周赛 T1。

给你两个整数 n 和 t 。请你返回大于等于 n 的 最小 整数，且该整数的 各数位之积 能被 t 整除。
提示：
1 <= n <= 100
1 <= t <= 10

暴力，至多循环 10 次。
 */