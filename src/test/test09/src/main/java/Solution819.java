import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase(Locale.ENGLISH).split("[!?',;. ]");

        Map<String, Integer> cntMap = new HashMap<>();
        for (String word : words) {
            cntMap.put(word, cntMap.getOrDefault(word, 0) + 1);
        }
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        bannedSet.add("");

        int maxCnt = 0;
        String maxString = "";
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            if (!bannedSet.contains(entry.getKey())) {
                if (entry.getValue() > maxCnt) {
                    maxCnt = entry.getValue();
                    maxString = entry.getKey();
                }
            }
        }
        return maxString;
    }
}
/*
819. 最常见的单词
https://leetcode.cn/problems/most-common-word/

给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
题目保证至少有一个词不在禁用列表中，而且答案唯一。
禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
提示：
1 <= 段落长度 <= 1000
0 <= 禁用单词个数 <= 100
1 <= 禁用单词长度 <= 10
答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
paragraph 只包含字母、空格和下列标点符号!?',;.
不存在没有连字符或者带有连字符的单词。
单词里只包含字母，不会出现省略号或者其他标点符号。

正则表达式。
 */