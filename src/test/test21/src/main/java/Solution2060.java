public class Solution2060 {
    private int n, m, mx = 2000, bias = 1000;
    private char[] s1, s2;
    private boolean[][][] vis;

    public boolean possiblyEquals(String s1, String s2) {
        n = s1.length();
        m = s2.length();
        this.s1 = s1.toCharArray();
        this.s2 = s2.toCharArray();
        vis = new boolean[n + 1][m + 1][mx];
        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int d) {
        if (i == n && j == m) {
            return d == 0; // 匹配成功
        }
        if (vis[i][j][d + bias]) {
            return false;
        }
        vis[i][j][d + bias] = true;
        // 原始字符串长度相同时，若 s1[i] == s2[j]，则 s1[:i] 和 s2[:j] 均可以向后扩展一个字母
        if (d == 0 && i < n && j < m && s1[i] == s2[j] && dfs(i + 1, j + 1, 0)) {
            return true;
        }
        if (d <= 0 && i < n) { // s1[:i] 的原始字符串长度不超过 s2[:j] 的原始字符串长度时，扩展 s1[:i]
            if (Character.isDigit(s1[i])) { // 数字
                int v = 0;
                for (int p = i; p < n && Character.isDigit(s1[p]); p++) {
                    v = v * 10 + (s1[p] & 15);
                    if (dfs(p + 1, j, d + v)) {
                        return true;
                    }
                }
            } else if (d < 0 && dfs(i + 1, j, d + 1)) { // 字符，扩展一位，注意这里 d 不能为 0
                return true;
            }
        }
        if (d >= 0 && j < m) { // s2[:j] 的原始字符串长度不超过 s1[:i] 的原始字符串长度时，扩展 s2[:j]
            if (Character.isDigit(s2[j])) { // 数字
                int v = 0;
                for (int q = j; q < m && Character.isDigit(s2[q]); q++) {
                    v = v * 10 + (s2[q] & 15);
                    if (dfs(i, q + 1, d - v)) {
                        return true;
                    }
                }
            } else if (d > 0 && dfs(i, j + 1, d - 1)) { // 字符，扩展一位，注意这里 d 不能为 0
                return true;
            }
        }
        return false;
    }
}
/*
2060. 同源字符串检测
https://leetcode.cn/problems/check-if-an-original-string-exists-given-two-encoded-strings/description/

原字符串由小写字母组成，可以按下述步骤编码：
- 任意将其 分割 为由若干 非空 子字符串组成的一个 序列 。
- 任意选择序列中的一些元素（也可能不选择），然后将这些元素替换为元素各自的长度（作为一个数字型的字符串）。
- 重新 顺次连接 序列，得到编码后的字符串。
例如，编码 "abcdefghijklmnop" 的一种方法可以描述为：
- 将原字符串分割得到一个序列：["ab", "cdefghijklmn", "o", "p"] 。
- 选出其中第二个和第三个元素并分别替换为它们自身的长度。序列变为 ["ab", "12", "1", "p"] 。
- 重新顺次连接序列中的元素，得到编码后的字符串："ab121p" 。
给你两个编码后的字符串 s1 和 s2 ，由小写英文字母和数字 1-9 组成。如果存在能够同时编码得到 s1 和 s2 原字符串，返回 true ；否则，返回 false。
注意：生成的测试用例满足 s1 和 s2 中连续数字数不超过 3 。
提示：
1 <= s1.length, s2.length <= 40
s1 和 s2 仅由数字 1-9 和小写英文字母组成
s1 和 s2 中连续数字数不超过 3

DFS + 分类讨论
dfs(i,j,d) 表示 s1[:i] 的原始字符串的长度减去 s2[:j] 的原始字符串的长度等于 d 时，能否匹配（即可以由同一个原始字符串转换得到）。
时间复杂度 O(n * m * mx)。
 */