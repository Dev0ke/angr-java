import java.util.List;

public class Solution2828 {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(word.charAt(0));
        }
        return stringBuilder.toString().equals(s);
    }
}
/*
2828. 判别首字母缩略词
https://leetcode.cn/problems/check-if-a-string-is-an-acronym-of-words/

第 359 场周赛 T1。

给你一个字符串数组 words 和一个字符串 s ，请你判断 s 是不是 words 的 首字母缩略词 。
如果可以按顺序串联 words 中每个字符串的第一个字符形成字符串 s ，则认为 s 是 words 的首字母缩略词。例如，"ab" 可以由 ["apple", "banana"] 形成，但是无法从 ["bear", "aardvark"] 形成。
如果 s 是 words 的首字母缩略词，返回 true ；否则，返回 false 。
提示：
1 <= words.length <= 100
1 <= words[i].length <= 10
1 <= s.length <= 100
words[i] 和 s 由小写英文字母组成

模拟。
时间复杂度 O(n)
 */