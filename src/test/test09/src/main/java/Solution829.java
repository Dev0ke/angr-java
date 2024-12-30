public class Solution829 {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        // k(k+1)/2 <= n
        for (int k = 1; k * (k + 1) <= n * 2; k++) {
            if (isKConsecutive(n, k)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isKConsecutive(int n, int k) {
        if (k % 2 == 1) {
            return n % k == 0;
        } else {
            return n % k != 0 && 2 * n % k == 0;
        }
    }
}
/*
829. 连续整数求和
https://leetcode.cn/problems/consecutive-numbers-sum/description/

给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。
提示:
1 <= n <= 10^9

数学。分类讨论：
1、如果 k 是奇数，则当 n 可以被 k 整除时，正整数 n 可以表示成 k 个连续正整数之和；
2、如果 k 是偶数，则当 n 不可以被 k 整除且 2n 可以被 k 整除时，正整数 n 可以表示成 k 个连续正整数之和。
时间复杂度 O(sqrt(n))。
 */