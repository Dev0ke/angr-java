public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i < len1; i++) {
            dp[i + 1][0] = s1.charAt(i) == s3.charAt(i) && dp[i][0];
        }
        for (int i = 0; i < len2; i++) {
            dp[0][i + 1] = s2.charAt(i) == s3.charAt(i) && dp[0][i];
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                char ch3 = s3.charAt(i + j + 1);
                dp[i + 1][j + 1] = (ch1 == ch3 && dp[i][j + 1]) || (ch2 == ch3 && dp[i + 1][j]);
            }
        }
        return dp[len1][len2];
    }
}
/*
97. 交错字符串
https://leetcode.cn/problems/interleaving-string/

给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
- s = s1 + s2 + ... + sn
- t = t1 + t2 + ... + tm
- |n - m| <= 1
- 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
注意：a + b 意味着字符串 a 和 b 连接。
提示：
0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1、s2、和 s3 都由小写英文字母组成
进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?

动态规划。
定义 f(i,j) 为 字符串 s1 下标 0 到 i，字符串 s2 下标 0 到 j 能否交积得到字符串 s3 下标 0 到 i+j+1，
则解为 f(i,j) f(s1.length()-1， s2.length()-1)
如果 s1[i] == s3[i+j+1] 那么 f(i,j) = f(i-1,j)
如果 s2[j] == s3[i+j+1] 那么 f(i,j) = f(i,j-1)
如果 s1[i] == s3[i+j+1] && s2[j] == s3[i+j+1]，那么 f(i,j) = f(i-1,j) || f(i,j-1)
 */