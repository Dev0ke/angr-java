public class Solution372 {
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length, 1337);
    }

    private int superPow(int a, int[] b, int bLen, int mod) {
        if (a == 1) {
            return 1;
        }
        if (bLen < 1) {
            return 1;
        }
        int part1 = quickPow(a, b[bLen - 1], mod);
        int part2 = quickPow(superPow(a, b, bLen - 1, mod), 10, mod);
        return part1 * part2 % mod;
    }

    // 快速幂 res = a^b % mod
    private int quickPow(long a, long b, int mod) {
        a %= mod;
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res *= a;
                res %= mod;
            }
            a *= a;
            a %= mod;
            b /= 2;
        }
        return (int) res;
    }
}
/*
372. 超级次方
https://leetcode.cn/problems/super-pow/

你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
提示：
1 <= a <= 2^31 - 1
1 <= b.length <= 2000
0 <= b[i] <= 9
b 不含前导 0

快速幂
(a * b) % k = (a % k)(b % k) % k
 */