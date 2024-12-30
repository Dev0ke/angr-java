public class Solution866 {
    public int primePalindrome(int n) {
        for (int L = 1; L <= 5; L++) {
            int low = (int) Math.pow(10, L - 1);
            int high = (int) Math.pow(10, L);
            // Check for odd-length palindromes
            for (int root = low; root < high; root++) {
                int p = root;
                for (int x = root / 10; x > 0; x /= 10) {
                    p = p * 10 + x % 10;
                }
                if (p >= n && isPrime(p)) {
                    return p;
                }
            }
            // Check for even-length palindromes
            for (int root = low; root < high; root++) {
                int p = root;
                for (int x = root; x > 0; x /= 10) {
                    p = p * 10 + x % 10;
                }
                if (p >= n && isPrime(p)) {
                    return p;
                }
            }
        }
        return -1;
    }

    // 判断素数
    private static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i * i <= num; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
/*
866. 回文素数
https://leetcode.cn/problems/prime-palindrome/

第 92 场周赛 T3。

求出大于或等于 N 的最小回文素数。
回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
例如，2，3，5，7，11 以及 13 是素数。
回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
例如，12321 是回文数。
提示：
1 <= N <= 10^8
答案肯定存在，且小于 2 * 10^8。

2
3
5
7
11
101
131
...
9989899
100030001
相似题目: 564. 寻找最近的回文数
https://leetcode.cn/problems/find-the-closest-palindrome/description/
 */