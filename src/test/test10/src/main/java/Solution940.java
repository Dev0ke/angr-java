import java.util.Arrays;

public class Solution940 {
    private static final int MOD = (int) (1e9 + 7);

    public int distinctSubseqII(String s) {
        int n = s.length();

        // f[i][j] 表示用 s 的前 i 个字符组成以 j 结尾的不同非空子序列的个数
        long[][] f = new long[n][26];
        f[0][s.charAt(0) - 'a'] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1].clone();
            f[i][s.charAt(i) - 'a'] = (Arrays.stream(f[i - 1]).sum() + 1) % MOD;
        }
        return (int) (Arrays.stream(f[n - 1]).sum() % MOD);
    }
}
/*
940. 不同的子序列 II
https://leetcode.cn/problems/distinct-subsequences-ii/

给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
- 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
提示：
1 <= s.length <= 2000
s 仅由小写英文字母组成

动态规划
时间复杂度 O(n+26)
相似题目: 1987. 不同的好子序列数目
https://leetcode.cn/problems/number-of-unique-good-subsequences/
 */