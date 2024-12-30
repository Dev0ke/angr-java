public class Solution2255 {
    public int countPrefixes(String[] words, String s) {
        int cnt = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
2255. 统计是给定字符串前缀的字符串数目
https://leetcode.cn/problems/count-prefixes-of-a-given-string/

第 77 场双周赛 T1。

给你一个字符串数组 words 和一个字符串 s ，其中 words[i] 和 s 只包含 小写英文字母 。
请你返回 words 中是字符串 s 前缀 的 字符串数目 。
一个字符串的 前缀 是出现在字符串开头的子字符串。子字符串 是一个字符串中的连续一段字符序列。
提示：
1 <= words.length <= 1000
1 <= words[i].length, s.length <= 10
words[i] 和 s 只 包含小写英文字母。

模拟。直接用库函数 String#startsWith(String prefix) 判断是否为前缀即可。
时间复杂度：库函数不讨论时间复杂度。
 */