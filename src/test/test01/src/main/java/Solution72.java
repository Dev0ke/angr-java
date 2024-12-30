public class Solution72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // f[i][j] 表示 word1 前 i 个字母与 word2 前 j 个字母的编辑距离
        int[][] f = new int[n + 1][m + 1];

        // 初始状态
        for (int i = 1; i <= n; i++) {
            f[i][0] = i;
        }
        for (int j = 1; j <= m; j++) {
            f[0][j] = j;
        }

        // 状态转移
        for (int i = 1; i <= n; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    // 在 word1 插入，在 word2 插入，替换一个
                    f[i][j] = Math.min(f[i - 1][j] + 1, Math.min(f[i][j - 1] + 1, f[i - 1][j - 1]));
                } else {
                    f[i][j] = Math.min(f[i - 1][j] + 1, Math.min(f[i][j - 1] + 1, f[i - 1][j - 1] + 1));
                }
            }
        }
        return f[n][m];
    }
}
/*
72. 编辑距离
https://leetcode.cn/problems/edit-distance/

给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
- 插入一个字符
- 删除一个字符
- 替换一个字符
提示：
0 <= word1.length, word2.length <= 500
word1 和 word2 由小写英文字母组成

编辑距离算法被数据科学家广泛应用，是用作机器翻译和语音识别评价标准的基本算法。
动态规划。
时间复杂度 O(mn)
空间复杂度 O(mn)
 */