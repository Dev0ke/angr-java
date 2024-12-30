public class Solution2565 {
    // CF1203D2
    public int minimumScore(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] suf = new int[n + 1];
        suf[n] = m;
        for (int i = n - 1, j = m - 1; i >= 0; i--) {
            if (s.charAt(i) == t.charAt(j)) j--;
            if (j < 0) return 0; // t 是 s 的子序列
            suf[i] = j + 1;
        }

        int ans = suf[0]; // 删除 t[:suf[0]]
        for (int i = 0, j = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(j)) { // 注意上面判断了 t 是 s 子序列的情况，这里 j 不会越界
                j++;
                ans = Math.min(ans, suf[i + 1] - j); // 删除 t[j:suf[i+1]]
            }
        }
        return ans;
    }
}
/*
2565. 最少得分子序列
https://leetcode.cn/problems/subsequence-with-the-minimum-score/

第 332 场周赛 T4。

给你两个字符串 s 和 t 。
你可以从字符串 t 中删除任意数目的字符。
如果没有从字符串 t 中删除字符，那么得分为 0 ，否则：
- 令 left 为删除字符中的最小下标。
- 令 right 为删除字符中的最大下标。
字符串的得分为 right - left + 1 。
请你返回使 t 成为 s 子序列的最小得分。
一个字符串的 子序列 是从原字符串中删除一些字符后（也可以一个也不删除），剩余字符不改变顺序得到的字符串。（比方说 "ace" 是 "abcde" 的子序列，但是 "aec" 不是）。
提示：
1 <= s.length, t.length <= 10^5
s 和 t 都只包含小写英文字母。

前后缀分解 + 判断子序列。
时间复杂度 O(n)。
相似题目: 2484. 统计回文子序列数目
https://leetcode.cn/problems/count-palindromic-subsequences/
2552. 统计上升四元组
https://leetcode.cn/problems/count-increasing-quadruplets/
D - Match or Not
https://atcoder.jp/contests/abc287/tasks/abc287_d
D2. Remove the Substring (hard version)
https://codeforces.com/contest/1203/problem/D2
3302. 字典序最小的合法序列
https://leetcode.cn/problems/find-the-lexicographically-smallest-valid-sequence/description/
 */