public class Solution1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int n = words1.length;
        int m = words2.length;
        // 最短长度
        int minLen = Math.min(n, m);

        int i = 0;
        int j = 0;
        while (i < minLen && words1[i].equals(words2[i])) {
            i++;
        }
        while (i + j < minLen && words1[n - 1 - j].equals(words2[m - 1 - j])) {
            j++;
        }
        return i + j == minLen;
    }
}
/*
1813. 句子相似性 III
https://leetcode.cn/problems/sentence-similarity-iii/

一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的 。
比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。
提示：
1 <= sentence1.length, sentence2.length <= 100
sentence1 和 sentence2 都只包含大小写英文字母和空格。
sentence1 和 sentence2 中的单词都只由单个空格隔开。

双指针
 */