public class Solution2595 {
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        for (int k = 0; k < 30; k++) {
            if ((n >> k & 1) == 1) {
                ans[k & 1]++;
            }
        }
        return ans;
    }
}
/*
2595. 奇偶位数
https://leetcode.cn/problems/number-of-even-and-odd-bits/

第 337 场周赛 T1。

给你一个 正 整数 n 。
用 even 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的偶数下标的个数。
用 odd 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的奇数下标的个数。
返回整数数组 answer ，其中 answer = [even, odd] 。
提示：
1 <= n <= 1000

位运算。模拟。
 */