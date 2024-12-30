public class Solution2269 {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int n = s.length();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i + k <= n) {
                String subStr = s.substring(i, i + k);
                int sub = Integer.parseInt(subStr);
                if (sub != 0 && num % sub == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
2269. 找到一个数字的 K 美丽值
https://leetcode.cn/problems/find-the-k-beauty-of-a-number/

第 78 场双周赛 T1。

一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
- 子字符串长度为 k 。
- 子字符串能整除 num 。
给你整数 num 和 k ，请你返回 num 的 k 美丽值。
注意：
- 允许有 前缀 0 。
- 0 不能整除任何值。
一个 子字符串 是一个字符串里的连续一段字符序列。
提示：
1 <= num <= 10^9
1 <= k <= num.length （将 num 视为字符串）

枚举长度为 k 的子字符串。
 */