import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution1048 {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        for (String word : words) {
            int max = 0;
            for (int i = 0; i < word.length(); i++) {
                // 前身
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                max = Math.max(max, dp.getOrDefault(predecessor, 0) + 1);
            }
            dp.put(word, max);
            res = Math.max(res, max);
        }
        return res;
    }
}
/*
1048. 最长字符串链
https://leetcode.cn/problems/longest-string-chain/

给出一个单词数组 words ，其中每个单词都由小写英文字母组成。
如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 前身 。
- 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身
词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是 word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。
从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。
提示：
1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] 仅由小写英文字母组成。

动态规划。
 */