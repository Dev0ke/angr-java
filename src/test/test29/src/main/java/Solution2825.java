public class Solution2825 {
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();

        // t 是否是 s 的子序列
        int n = s.length, m = t.length;
        int i = 0, j = 0;
        while (i < n && j < m) {
            char c1 = s[i], c2 = s[i] == 'z' ? 'a' : ++s[i];
            if (c1 == t[j] || c2 == t[j]) {
                j++;
            }
            i++;
        }
        return j == m;
    }
}
/*
2825. 循环增长使字符串子序列等于另一个字符串
https://leetcode.cn/problems/make-string-a-subsequence-using-cyclic-increments/

第 111 场双周赛 T2。

给你一个下标从 0 开始的字符串 str1 和 str2 。
一次操作中，你选择 str1 中的若干下标。对于选中的每一个下标 i ，你将 str1[i] 循环 递增，变成下一个字符。也就是说 'a' 变成 'b' ，'b' 变成 'c' ，以此类推，'z' 变成 'a' 。
如果执行以上操作 至多一次 ，可以让 str2 成为 str1 的子序列，请你返回 true ，否则返回 false 。
注意：一个字符串的子序列指的是从原字符串中删除一些（可以一个字符也不删）字符后，剩下字符按照原本先后顺序组成的新字符串。
提示：
1 <= str1.length <= 10^5
1 <= str2.length <= 10^5
str1 和 str2 只包含小写英文字母。

双指针 判定 子串问题
时间复杂度 O(n)
相似题目: 392. 判断子序列
https://leetcode.cn/problems/is-subsequence/
 */