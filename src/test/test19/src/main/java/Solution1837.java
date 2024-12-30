public class Solution1837 {
    public int sumBase(int n, int k) {
        int cnt = 0;
        while (n > 0) {
            cnt += n % k;
            n /= k;
        }
        return cnt;
    }
}
/*
1837. K 进制表示下的各位数字总和
https://leetcode.cn/problems/sum-of-digits-in-base-k/

第 238 场周赛 T1。

给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。
转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。
提示：
1 <= n <= 100
2 <= k <= 10

进制转换
 */