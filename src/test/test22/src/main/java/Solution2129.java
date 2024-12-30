import java.util.Locale;

public class Solution2129 {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            String newWord = word.toLowerCase(Locale.ENGLISH);
            if (newWord.length() >= 3) {
                newWord = newWord.substring(0, 1).toUpperCase(Locale.ENGLISH).concat(newWord.substring(1));
            }
            stringBuilder.append(newWord).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
/*
2129. 将标题首字母大写
https://leetcode.cn/problems/capitalize-the-title/

第 69 场双周赛 T1。

给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
- 如果单词的长度为 1 或者 2 ，所有字母变成小写。
- 否则，将单词首字母大写，剩余字母变成小写。
请你返回 大写后 的 title 。

模拟。
 */