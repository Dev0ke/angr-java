public class Solution1015 {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        // 一定有解
        int x = 1 % k;
        for (int i = 1; ; i++) {
            if (x == 0) {
                return i;
            }
            x = (x * 10 + 1) % k;
        }
    }
}
/*
1015. 可被 K 整除的最小整数
https://leetcode.cn/problems/smallest-integer-divisible-by-k/

给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。
返回 n 的长度。如果不存在这样的 n ，就返回-1。
注意： n 不符合 64 位带符号整数。
提示：
1 <= k <= 10^5

由于 n 的个位数是 1，所以必然不是 2 和 5 的倍数，如果 k 是 2 和 5 的倍数，那么必然无解，返回 -1，否则一定有解。
时间复杂度 O(K)
 */