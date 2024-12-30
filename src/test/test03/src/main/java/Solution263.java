public class Solution263 {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
/*
263. 丑数
https://leetcode.cn/problems/ugly-number/

丑数 就是只包含质因数 2、3 和 5 的正整数。
给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
提示：
-2^31 <= n <= 2^31 - 1

数学
时间复杂度 O(logn)
空间复杂度 O(n)
 */
