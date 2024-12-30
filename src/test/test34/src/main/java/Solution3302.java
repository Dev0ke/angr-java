public class Solution3302 {
    public int[] validSequence(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int n = s.length;
        int m = t.length;

        int[] suf = new int[n + 1];
        suf[n] = m;
        for (int i = n - 1, j = m - 1; i >= 0; i--) {
            if (j >= 0 && s[i] == t[j]) {
                j--;
            }
            suf[i] = j + 1;
        }

        int[] ans = new int[m];
        boolean changed = false; // 是否修改过
        for (int i = 0, j = 0; i < n; i++) {
            if (s[i] == t[j] || !changed && suf[i + 1] <= j + 1) {
                if (s[i] != t[j]) {
                    changed = true;
                }
                ans[j++] = i;
                if (j == m) {
                    return ans;
                }
            }
        }
        return new int[0];
    }
}
/*
3302. 字典序最小的合法序列
https://leetcode.cn/problems/find-the-lexicographically-smallest-valid-sequence/description/

第 140 场双周赛 T3。

给你两个字符串 word1 和 word2 。
如果一个字符串 x 修改 至多 一个字符会变成 y ，那么我们称它与 y 几乎相等 。
如果一个下标序列 seq 满足以下条件，我们称它是 合法的 ：
- 下标序列是 升序 的。
- 将 word1 中这些下标对应的字符 按顺序 连接，得到一个与 word2 几乎相等 的字符串。
请你返回一个长度为 word2.length 的数组，表示一个 字典序最小 的 合法 下标序列。如果不存在这样的序列，请你返回一个 空 数组。
注意 ，答案数组必须是字典序最小的下标数组，而 不是 由这些下标连接形成的字符串。
提示：
1 <= word2.length < word1.length <= 3 * 10^5
word1 和 word2 只包含小写英文字母。

前后缀分解 + 子序列匹配 + 贪心。
时间复杂度 O(n)。
rating 2511 (clist.by)
相似题目: 2565. 最少得分子序列
https://leetcode.cn/problems/subsequence-with-the-minimum-score/
 */