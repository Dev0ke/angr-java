public class SolutionP625 {
    public int smallestFactorization(int num) {
        // 正整数 特判
        if (num == 1) {
            return 1;
        }

        long res = 0, mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (num % i == 0) {
                num /= i;
                res += mul * i;
                mul *= 10;
            }
        }
        if (num == 1 && res <= Integer.MAX_VALUE) {
            return (int) res;
        }
        return 0;
    }
}
/*
$625. 最小因式分解
https://leetcode.cn/problems/minimum-factorization/

给定一个正整数 a，找出最小的正整数 b 使得 b 的所有数位相乘恰好等于 a。
如果不存在这样的结果或者结果不是 32 位有符号整数，返回 0。
Constraints:
1 <= num <= 2^31 - 1

因式分解
时间复杂度 O(logn)
 */