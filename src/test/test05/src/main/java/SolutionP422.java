import java.util.List;

public class SolutionP422 {
    public boolean validWordSquare(List<String> words) {
        int maxLen = 500;

        // 转成方阵
        char[][] chars = new char[maxLen][maxLen];
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < words.get(i).length(); j++) {
                chars[i][j] = word.charAt(j);
            }
        }

        // 校验
        for (int i = 0; i < maxLen; i++) {
            for (int j = i + 1; j < maxLen; j++) {
                if (chars[i][j] != chars[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
$422. 有效的单词方块
https://leetcode.cn/problems/valid-word-square/

给你一个单词序列，判断其是否形成了一个有效的单词方块。
有效的单词方块是指此由单词序列组成的文字方块的 第 k 行 和 第 k 列 (0 ≤ k < max(行数, 列数)) 所显示的字符串完全相同。
注意：
给定的单词数大于等于 1 且不超过 500。
单词长度大于等于 1 且不超过 500。
每个单词只包含小写英文字母 a-z。

判断矩阵是否关于主对角线对称。
 */