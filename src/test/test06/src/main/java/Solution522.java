public class Solution522 {
    // O(m^2 n) = 50 * 50 * 10 = 25000
    public int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < max) {
                continue;
            }
            if (check(strs, i)) {
                max = strs[i].length();
            }
        }
        return max;
    }

    // O(mn)
    private boolean check(String[] strs, int i) {
        for (int j = 0; j < strs.length; j++) {
            if (i != j) {
                if (isSubsequence(strs[i], strs[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
/*
522. 最长特殊序列 II
https://leetcode.cn/problems/longest-uncommon-subsequence-ii/

给定字符串列表 strs ，返回 它们中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
最长特殊序列 定义如下：该序列为某字符串 独有的最长子序列（即不能是其他字符串的子序列）。
- s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 - 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 提示:
2 <= strs.length <= 50
1 <= strs[i].length <= 10
strs[i] 只包含小写英文字母

判断子序列变种。
时间复杂度 O(m^2 n) 其中 m = strs.length, n = strs[i].length 理论上界 50 * 50 * 10 = 25000
相似题目: 392. 判断子序列
https://leetcode.cn/problems/is-subsequence/
 */