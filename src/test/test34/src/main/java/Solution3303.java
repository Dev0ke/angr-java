public class Solution3303 {
    public int minStartingIndex(String s, String pattern) {
        int[] preZ = z_function(pattern + s);
        int[] sufZ = z_function(rev(pattern) + rev(s));
        // 可以不反转 sufZ，下面写 sufZ[sufZ.length - i]
        int n = s.length();
        int m = pattern.length();
        for (int i = m; i <= n; i++) {
            if (preZ[i] + sufZ[sufZ.length - i] >= m - 1) {
                return i - m;
            }
        }
        return -1;
    }

    private String rev(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private int[] z_function(String s) {
        return z_function(s.toCharArray());
    }

    private int[] z_function(char[] s) {
        int n = s.length;
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
3303. 第一个几乎相等子字符串的下标
https://leetcode.cn/problems/find-the-occurrence-of-first-almost-equal-substring/description/

第 140 场双周赛 T4。

给你两个字符串 s 和 pattern 。
如果一个字符串 x 修改 至多 一个字符会变成 y ，那么我们称它与 y 几乎相等 。
请你返回 s 中下标 最小 的 子字符串 ，它与 pattern 几乎相等 。如果不存在，返回 -1 。
子字符串 是字符串中的一个 非空、连续的字符序列。
提示：
1 <= pattern.length < s.length <= 10^5
s 和 pattern 都只包含小写英文字母。
进阶：如果题目变为 至多 k 个 连续 字符可以被修改，你可以想出解法吗？

前后缀分解 + Z 函数。
时间复杂度 O(n)。
rating 2538 (clist.by)
 */