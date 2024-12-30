public class Solution483 {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(num) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(num, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == num) {
                return Integer.toString(k);
            }
        }
        return Long.toString(num - 1);
    }
}
/*
483. 最小好进制
https://leetcode.cn/problems/smallest-good-base/

以字符串的形式给出 n , 以字符串的形式返回 n 的最小 好进制  。
如果 n 的  k(k>=2) 进制数的所有数位全为1，则称 k(k>=2) 是 n 的一个 好进制 。
提示：
n 的取值范围是 [3, 10^18]
n 没有前导 0

数学。
官方题解: https://leetcode.cn/problems/smallest-good-base/solution/zui-xiao-hao-jin-zhi-by-leetcode-solutio-csqn/
时间复杂度 O(log^2 n)
空间复杂度 O(1)
 */