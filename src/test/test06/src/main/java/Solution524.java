import java.util.List;

public class Solution524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String t : dictionary) {
            // t 是否为 s 的一个子序列
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) i++;
                j++;
                if (i == t.length()) {
                    if (t.length() > ans.length()
                            || t.length() == ans.length() && t.compareTo(ans) < 0) {
                        ans = t;
                    }
                }
            }
        }
        return ans;
    }
}
/*
524. 通过删除字母匹配到字典里最长单词
https://leetcode.cn/problems/longest-word-in-dictionary-through-deleting/

给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
提示：
1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s 和 dictionary[i] 仅由小写英文字母组成

双指针判断是否子序列。
时间复杂度: O(d×(m+n))，其中 d 表示 dictionary 的长度，m 表示 s 的长度，n 表示 dictionary 中字符串的平均长度。
空间复杂度: O(1)
 */