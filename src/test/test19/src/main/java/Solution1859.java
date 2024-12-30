public class Solution1859 {
    public String sortSentence(String s) {
        String[] strings = s.split(" ");
        int len = strings.length;
        String[] ans = new String[len];
        for (String str : strings) {
            String word = str.substring(0, str.length() - 1);
            int order = Integer.parseInt(str.substring(str.length() - 1));
            ans[order - 1] = word;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            stringBuilder.append(ans[i]).append(" ");
        }
        stringBuilder.append(ans[len - 1]);
        return stringBuilder.toString();
    }
}
/*
1859. 将句子排序
https://leetcode.cn/problems/sorting-the-sentence/

第 52 场双周赛 T1。

一个 句子 指的是一个序列的单词用单个空格连接起来，且开头和结尾没有任何空格。每个单词都只包含小写或大写英文字母。
我们可以给一个句子添加 从 1 开始的单词位置索引 ，并且将句子中所有单词 打乱顺序 。
- 比方说，句子 "This is a sentence" 可以被打乱顺序得到 "sentence4 a3 is2 This1" 或者 "is2 sentence4 This1 a3" 。
给你一个 打乱顺序 的句子 s ，它包含的单词不超过 9 个，请你重新构造并得到原本顺序的句子。
提示：
2 <= s.length <= 200
s 只包含小写和大写英文字母、空格以及从 1 到 9 的数字。
s 中单词数目为 1 到 9 个。
s 中的单词由单个空格分隔。
s 不包含任何前导或者后缀空格。

1 位整数（0-9），难度很低了，String#substring 分离字符串与数字，按序拼接即可。
 */
