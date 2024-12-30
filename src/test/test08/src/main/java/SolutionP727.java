import java.util.Arrays;

public class SolutionP727 {
    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] pos = new int[26];
        Arrays.fill(pos, n);

        // nxt[i][j] 表示 s[i] 右侧最近的字母 j 的位置
        int[][] nxt = new int[n][26];
        for (int i = n - 1; i >= 0; i--) {
            nxt[i] = pos.clone();
            pos[s1.charAt(i) - 'a'] = i;
        }

        String ans = "";
        for (int i0 = 0; i0 < n; i0++) {
            // 遍历所有 s 中的 t[0]
            if (s1.charAt(i0) == s2.charAt(0)) {
                int i = i0;
                // 匹配 t 中的字符
                for (int j = 1; j < m; j++) {
                    i = nxt[i][s2.charAt(j) - 'a'];
                    if (i == n) {
                        return ans;
                    }
                }
                String w = s1.substring(i0, i + 1);
                if (ans.equals("") || w.length() < ans.length()) {
                    ans = w;
                }
            }
        }
        return ans;
    }
}
/*
$727. 最小窗口子序列
https://leetcode.cn/problems/minimum-window-subsequence/

给定字符串 S and T，找出 S 中最短的（连续）子串 W ，使得 T 是 W 的 子序列 。
如果 S 中没有窗口可以包含 T 中的所有字符，返回空字符串 ""。如果有不止一个最短长度的窗口，返回开始位置最靠左的那个。
注：
所有输入的字符串都只包含小写字母。All the strings in the input will only contain lowercase letters.
S 长度的范围为 [1, 20000]。
T 长度的范围为 [1, 100]。

子序列自动机
灵神 https://leetcode.cn/problems/minimum-window-subsequence/solution/zi-xu-lie-zi-dong-ji-by-endlesscheng-guks/
 */