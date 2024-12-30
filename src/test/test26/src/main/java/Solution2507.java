public class Solution2507 {
    public int smallestValue(int n) {
        while (true) {
            int x = n, s = 0;
            for (int i = 2; i * i <= x; ++i) {
                for (; x % i == 0; x /= i) {
                    s += i;
                }
            }
            if (x > 1) s += x;
            if (s == n) return n;
            n = s;
        }
    }
}
/*
2507. 使用质因数之和替换后可以取到的最小值
https://leetcode.cn/problems/smallest-value-after-replacing-with-sum-of-prime-factors/

第 324 场周赛 T2。

给你一个正整数 n 。
请你将 n 的值替换为 n 的 质因数 之和，重复这一过程。
- 注意，如果 n 能够被某个质因数多次整除，则在求和时，应当包含这个质因数同样次数。
返回 n 可以取到的最小值。
提示：
2 <= n <= 10^5

暴力。
时间复杂度 O(sqrt(n))
 */