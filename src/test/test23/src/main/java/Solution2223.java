public class Solution2223 {
    public long sumScores(String s) {
        int n = s.length();
        int[] z = z_function(n, s.toCharArray());

        long cnt = n;
        for (int i : z) {
            cnt += i;
        }
        return cnt;
    }

    private int[] z_function(int n, char[] s) {
        int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; ++i) {
            if (i <= r && z[i - l] < r - i + 1) {
                z[i] = z[i - l];
            } else {
                z[i] = Math.max(0, r - i + 1);
                while (i + z[i] < n && s[z[i]] == s[i + z[i]]) ++z[i];
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
/*
2223. 构造字符串的总得分和
https://leetcode.cn/problems/sum-of-scores-of-built-strings/

第 75 场双周赛 T4。

你需要从空字符串开始 构造 一个长度为 n 的字符串 s ，构造的过程为每次给当前字符串 前面 添加 一个 字符。
构造过程中得到的所有字符串编号为 1 到 n ，其中长度为 i 的字符串编号为 si 。
- 比方说，s = "abaca" ，s1 == "a" ，s2 == "ca" ，s3 == "aca" 依次类推。
si 的 得分 为 si 和 sn 的 最长公共前缀 的长度（注意 s == sn ）。
给你最终的字符串 s ，请你返回每一个 si 的 得分之和 。
提示：
1 <= s.length <= 10^5
s 只包含小写英文字母。

Z 函数（扩展 KMP）
https://oi-wiki.org/string/z-func/
时间复杂度 O(n)
 */