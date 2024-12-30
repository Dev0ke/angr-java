public class Solution1370 {
    public String sortString(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        while (ans.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    ans.append((char) (i + 'a'));
                    cnt[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (cnt[i] > 0) {
                    ans.append((char) (i + 'a'));
                    cnt[i]--;
                }
            }
        }
        return ans.toString();
    }
}
/*
1370. 上升下降字符串
https://leetcode.cn/problems/increasing-decreasing-string/description/

给你一个字符串 s ，请你根据下面的算法重新构造字符串：
1.从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
2.从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
3.重复步骤 2 ，直到你没法从 s 中选择字符。
4.从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
5.从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
6.重复步骤 5 ，直到你没法从 s 中选择字符。
7.重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
请你返回将 s 中字符重新排序后的 结果字符串 。
提示：
1 <= s.length <= 500
s 只包含小写英文字母。

计数 + 模拟构造。
时间复杂度 O(26n)。
 */