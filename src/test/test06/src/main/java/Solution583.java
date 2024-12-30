public class Solution583 {
    public int minDistance(String word1, String word2) {
        int lcsLen = solution1143longestCommonSubsequence(word1, word2);
        return word1.length() + word2.length() - lcsLen - lcsLen;
    }

    private int solution1143longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
/*
583. 两个字符串的删除操作
https://leetcode.cn/problems/delete-operation-for-two-strings/

给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
提示：
1 <= word1.length, word2.length <= 500
word1 和 word2 只包含小写英文字母

LCS 变形。最小步数 = word1 长度 + word2 长度 - 两倍 LCS 长度
相似题目: 1143. 最长公共子序列
https://leetcode.cn/problems/longest-common-subsequence/
 */