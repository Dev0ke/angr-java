public class Solution1422 {
    public int maxScore(String s) {
        int len = s.length();

        // 前缀和
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + ((s.charAt(i) == '1') ? 1 : 0);
        }

        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            // 左 0 右 1
            int left = i + 1 - preSum[i + 1];
            int right = preSum[len] - preSum[i + 1];
            max = Math.max(max, left + right);
        }
        return max;
    }
}
/*
1422. 分割字符串的最大得分
https://leetcode.cn/problems/maximum-score-after-splitting-a-string/

给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即  左 子字符串和 右 子字符串）所能获得的最大得分。
「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
提示：
2 <= s.length <= 500
字符串 s 仅由字符 '0' 和 '1' 组成。

前缀和+贪心。
 */