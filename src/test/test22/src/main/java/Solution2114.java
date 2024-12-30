public class Solution2114 {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            int amount = sentence.split(" ").length;
            max = Math.max(max, amount);
        }
        return max;
    }
}
/*
2114. 句子中的最多单词数
https://leetcode.cn/problems/maximum-number-of-words-found-in-sentences/

第 68 场双周赛 T1。

一个 句子 由一些 单词 以及它们之间的单个空格组成，句子的开头和结尾不会有多余空格。
给你一个字符串数组 sentences ，其中 sentences[i] 表示单个 句子 。
请你返回单个句子里 单词的最多数目 。
提示：

1 <= sentences.length <= 100
1 <= sentences[i].length <= 100
sentences[i] 只包含小写英文字母和 ' ' 。
sentences[i] 的开头和结尾都没有空格。
sentences[i] 中所有单词由单个空格隔开。

范围 10^4
暴力。
 */