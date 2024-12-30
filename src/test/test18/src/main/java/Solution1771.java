public class Solution1771 {
    public int longestPalindrome(String word1, String word2) {
        char[] s = (word1 + word2).toCharArray();
        int n = s.length;
        int ans = 0;
        int[][] f = new int[n][n];
        for (int span = 2; span <= n; span++) {
            for (int i = 0; i + span - 1 < n; i++) {
                f[i][i] = 1;
                int j = i + span - 1;
                if (s[i] == s[j]) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                    if (i < word1.length() && j >= word1.length()) {
                        ans = Math.max(ans, f[i][j]);
                    }
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return ans;
    }
}
/*
1771. 由子序列构造的最长回文串的长度
https://leetcode.cn/problems/maximize-palindrome-length-from-subsequences/description/

给你两个字符串 word1 和 word2 ，请你按下述方法构造一个字符串：
- 从 word1 中选出某个 非空 子序列 subsequence1 。
- 从 word2 中选出某个 非空 子序列 subsequence2 。
- 连接两个子序列 subsequence1 + subsequence2 ，得到字符串。
返回可按上述方法构造的最长 回文串 的 长度 。如果无法构造回文串，返回 0 。
字符串 s 的一个 子序列 是通过从 s 中删除一些（也可能不删除）字符而不更改其余字符的顺序生成的字符串。
回文串 是正着读和反着读结果一致的字符串。
提示：
1 <= word1.length, word2.length <= 1000
word1 和 word2 由小写英文字母组成

区间 DP。
s = word1 + word2
不能直接套 516 代码，否则 word1 = a, word2 = abcb, 结果为 bcb（word1 的子序列不能为空）
https://leetcode.cn/problems/maximize-palindrome-length-from-subsequences/solutions/2285215/shi-pin-qiao-miao-zhuan-huan-516-bian-xi-jhrt/
相似题目: 516. 最长回文子序列
https://leetcode.cn/problems/longest-palindromic-subsequence/
 */