public class SolutionP3135 {
    // 583
    public int minOperations(String initial, String target) {
        char[] s = initial.toCharArray();
        char[] t = target.toCharArray();
        int n = s.length;
        int m = t.length;
        int[][] f = new int[n + 1][m + 1];
        int maxL = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s[i - 1] == t[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    maxL = Math.max(maxL, f[i][j]);
                } else {
                    // 不同于 LCS
//                    f[i][j] = Math.maxL(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return n + m - maxL * 2;
    }
}
/*
$3135. 通过添加或删除结尾字符来同化字符串
https://leetcode.cn/problems/equalize-strings-by-adding-or-removing-characters-at-ends/description/

给定两个字符串 initial 和 target，你的任务是通过一系列操作改变 initial 以使它与 target 相同。
在一次操作中，您只能在 initial 字符串开头或结尾添加或删除一个字符。
返回将 initial 变为 target 所需的最小 操作次数。
提示：
1 <= initial.length, target.length <= 1000
initial 和 target 只包含小写英文字母。

LCS 变种，本题 不能替换。
相似题目: 583. 两个字符串的删除操作
https://leetcode.cn/problems/delete-operation-for-two-strings/
 */