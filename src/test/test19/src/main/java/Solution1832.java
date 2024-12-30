public class Solution1832 {
    public boolean checkIfPangram(String sentence) {
        return sentence.chars().distinct().count() == 26;
    }
}
/*
1832. 判断句子是否为全字母句
https://leetcode.cn/problems/check-if-the-sentence-is-pangram/

第 237 场周赛 T1。

全字母句 指包含英语字母表中每个字母至少一次的句子。
给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
如果是，返回 true ；否则，返回 false 。
提示：
1 <= sentence.length <= 1000
sentence 由小写英语字母组成

lambda 表达式一行
 */