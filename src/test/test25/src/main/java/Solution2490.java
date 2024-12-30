public class Solution2490 {
    public boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }

        String[] words = sentence.split(" ");
        int len = words.length;
        for (int i = 1; i < len; i++) {
            String pre = words[i - 1];
            String cur = words[i];
            if (cur.charAt(0) != pre.charAt(pre.length() - 1)) {
                return false;
            }
        }
        return true;
    }
}
/*
2490. 回环句
https://leetcode.cn/problems/circular-sentence/

第 322 场周赛 T1。

句子 是由单个空格分隔的一组单词，且不含前导或尾随空格。
- 例如，"Hello World"、"HELLO"、"hello world hello world" 都是符合要求的句子。
单词 仅 由大写和小写英文字母组成。且大写和小写字母会视作不同字符。
如果句子满足下述全部条件，则认为它是一个 回环句 ：
- 单词的最后一个字符和下一个单词的第一个字符相等。
- 最后一个单词的最后一个字符和第一个单词的第一个字符相等。
例如，"leetcode exercises sound delightful"、"eetcode"、"leetcode eats soul" 都是回环句。然而，"Leetcode is cool"、"happy Leetcode"、"Leetcode" 和 "I like Leetcode" 都 不 是回环句。
给你一个字符串 sentence ，请你判断它是不是一个回环句。如果是，返回 true ；否则，返回 false 。
提示：
1 <= sentence.length <= 500
sentence 仅由大小写英文字母和空格组成
sentence 中的单词由单个空格进行分隔
不含任何前导或尾随空格

模拟。
 */