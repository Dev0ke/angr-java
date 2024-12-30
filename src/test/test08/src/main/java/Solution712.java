public class Solution712 {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // f[i][j] 表示 s1 前 i 个元素与 s2 前 j 个元素的最小ASCII删除和
        int[][] f = new int[n + 1][m + 1];

        // 初始状态
        for (int i = 1; i <= n; i++) {
            f[i][0] = f[i - 1][0] + s1.codePointAt(i - 1);
        }
        for (int j = 1; j <= m; j++) {
            f[0][j] = f[0][j - 1] + s2.codePointAt(j - 1);
        }

        // 状态转移
        for (int i = 1; i <= n; i++) {
            int code1 = s1.codePointAt(i - 1);
            for (int j = 1; j <= m; j++) {
                int code2 = s2.codePointAt(j - 1);
                if (code1 == code2) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j] + code1, f[i][j - 1] + code2);
                }
            }
        }
        return f[n][m];
    }
}
/*
712. 两个字符串的最小ASCII删除和
https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/

给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
提示:
0 <= s1.length, s2.length <= 1000
s1 和 s2 由小写英文字母组成

动态规划。
相似题目: 72. 编辑距离
https://leetcode.cn/problems/edit-distance/
 */