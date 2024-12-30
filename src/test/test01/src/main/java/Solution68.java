import java.util.ArrayList;
import java.util.List;

public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        List<String> resList = new ArrayList<>();

        int right = 0;
        while (true) {
            // 当前行的第一个单词在 words 的位置
            int left = right;
            // 统计这一行单词长度之和
            int sumLen = 0;
            // 循环确定当前行可以放多少单词，注意单词之间应至少有一个空格
            while (right < len && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }

            // 当前行是最后一行：单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格
            if (right == len) {
                StringBuilder stringBuilder = join(words, left, len, " ");
                stringBuilder.append(blank(maxWidth - stringBuilder.length()));
                resList.add(stringBuilder.toString());
                return resList;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            // 当前行只有一个单词：该单词左对齐，在行末填充剩余空格
            if (numWords == 1) {
                resList.add(words[left] + blank(numSpaces));
                continue;
            }

            // 当前行不只一个单词
            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);
            // 拼接额外加一个空格的单词
            String str = join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1)) + blank(avgSpaces)
                    // 拼接其余单词
                    + join(words, left + extraSpaces + 1, right, blank(avgSpaces));
            resList.add(str);
        }
    }

    // blank 返回长度为 n 的由空格组成的字符串
    private String blank(int n) {
        return " ".repeat(Math.max(0, n));
    }

    // join 返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
    private StringBuilder join(String[] words, int left, int right, String sep) {
        StringBuilder stringBuilder = new StringBuilder(words[left]);
        for (int i = left + 1; i < right; ++i) {
            stringBuilder.append(sep);
            stringBuilder.append(words[i]);
        }
        return stringBuilder;
    }
}
/*
68. 文本左右对齐
https://leetcode.cn/problems/text-justification/

给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
文本的最后一行应为左对齐，且单词之间不插入额外的空格。
注意:
- 单词是指由非空格字符组成的字符序列。
- 每个单词的长度大于 0，小于等于 maxWidth。
- 输入单词数组 words 至少包含一个单词。
提示:
1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] 由小写英文字母和符号组成
1 <= maxWidth <= 100
words[i].length <= maxWidth

模拟。字符串处理。
 */