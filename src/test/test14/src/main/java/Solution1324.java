import java.util.ArrayList;
import java.util.List;

public class Solution1324 {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int m = words.length;
        int n = 0;
        for (String word : words) {
            n = Math.max(n, word.length());
        }

        char[][] chars = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                chars[i][j] = words[i].charAt(j);
            }
            for (int j = words[i].length(); j < n; j++) {
                chars[i][j] = ' ';
            }
        }

        List<String> resList = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < m; i++) {
                stringBuilder.append(chars[i][j]);
            }
            // 输出尾部的空格需要删除（不允许尾随空格）。
            resList.add(stringBuilder.toString().stripTrailing());
        }
        return resList;
    }
}
/*
1324. 竖直打印单词
https://leetcode.cn/problems/print-words-vertically/

给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
每个单词只能放在一列上，每一列中也只能有一个单词。
提示：
1 <= s.length <= 200
s 仅含大写英文字母。
题目数据保证两个单词之间只有一个空格。

模拟
 */