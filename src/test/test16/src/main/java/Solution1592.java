import java.util.ArrayList;
import java.util.List;

public class Solution1592 {
    public String reorderSpaces(String text) {
        int len = text.length();
        String[] words = text.split(" ");
        int wordLen = 0;
        int wordCnt = 0;
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            if (word.length() > 0) {
                wordLen += word.length();
                wordCnt++;
                wordList.add(word);
            }
        }
        int spaceLen = len - wordLen;
        if (wordCnt == 1) {
            return wordList.get(0).concat(" ".repeat(spaceLen));
        }
        // 每对相邻单词之间的空格数目
        int intervalLen = spaceLen / (wordCnt - 1);
        // 将多余的空格放置在字符串末尾
        int remainLen = spaceLen - intervalLen * (wordCnt - 1);
        return String.join(" ".repeat(intervalLen), wordList).concat(" ".repeat(remainLen));
    }
}
/*
1592. 重新排列单词间的空格
https://leetcode.cn/problems/rearrange-spaces-between-words/

给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，
请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
返回 重新排列空格后的字符串 。
提示：
1 <= text.length <= 100
text 由小写英文字母和 ' ' 组成
text 中至少包含一个单词

字符串模拟。
 */