public class Solution1816 {
    public String truncateSentence(String s, int k) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                cnt++;
                if (cnt == k) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }
}
/*
1816. 截断句子
https://leetcode.cn/problems/truncate-sentence/

第 235 场周赛 T1。

句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
- 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
给你一个句子 s 和一个整数 k ，请你将 s 截断 ，使截断后的句子仅含 前 k 个单词。返回 截断 s 后得到的句子。
提示：
1 <= s.length <= 500
k 的取值范围是 [1,  s 中单词的数目]
s 仅由大小写英文字母和空格组成
s 中的单词之间由单个空格隔开
不存在前导或尾随空格

直接遍历。
 */