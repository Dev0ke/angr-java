public class Solution44 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        // f[i][j] 表示字符串 s 的前 i 个元素和字符串 p 的前 j 个元素是否能匹配
        boolean[][] f = new boolean[n + 1][m + 1];
        // 初始状态
        f[0][0] = true;
        for (int j = 1; j <= m; ++j) {
            if (p.charAt(j - 1) == '*') {
                f[0][j] = true;
            } else {
                break;
            }
        }
        // 状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 1] || f[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                }
            }
        }
        return f[n][m];
    }
}
/*
44. 通配符匹配
https://leetcode.cn/problems/wildcard-matching/

给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。
说明:
- s 可能为空，且只包含从 a-z 的小写字母。
- p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。

动态规划。
时间复杂度 O(mn)
空间复杂度 O(mn)
相似题目: 10. 正则表达式匹配
https://leetcode.cn/problems/regular-expression-matching/
 */