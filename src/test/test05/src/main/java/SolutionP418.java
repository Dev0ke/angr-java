public class SolutionP418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;

        int[] dp = new int[n];
        int idx;
        for (int i = 0; i < n; i++) {
            idx = i;
            int rowLen = 0, time = 0;
            while (rowLen + sentence[idx].length() <= cols) {
                rowLen += sentence[idx].length() + 1;
                idx++;
                if (idx == n) {
                    idx = 0;
                    time++;
                }
            }
            dp[i] = idx + time * 100;
        }

        int ans = 0;
        idx = 0;
        for (int i = 0; i < rows; i++) {
            ans += dp[idx] / 100;
            idx = dp[idx] % 100;
        }
        return ans;
    }
}
/*
$418. 屏幕可显示句子的数量
https://leetcode.cn/problems/sentence-screen-fitting/

给你一个 rows x cols 的屏幕和一个用 非空 的单词列表组成的句子，请你计算出给定句子可以在屏幕上完整显示的次数。
注意：
1. 一个单词不能拆分成两行。
2. 单词在句子中的顺序必须保持不变。
3. 在一行中 的两个连续单词必须用一个空格符分隔。
4. 句子中的单词总量不会超过 100。
5. 每个单词的长度大于 0 且不会超过 10。
6. 1 ≤ rows, cols ≤ 20,000.

动态规划
用空间换时间 - Java 动态规划 https://leetcode.cn/problems/sentence-screen-fitting/solution/yong-kong-jian-huan-shi-jian-java-dong-t-yzyj/
 */