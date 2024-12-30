public class Solution3110 {
    public int scoreOfString(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return ans;
    }
}
/*
3110. 字符串的分数
https://leetcode.cn/problems/score-of-a-string/description/

第 128 场双周赛 T1。

给你一个字符串 s 。一个字符串的 分数 定义为相邻字符 ASCII 码差值绝对值的和。
请你返回 s 的 分数 。
提示：
2 <= s.length <= 100
s 只包含小写英文字母。

训练场打车回公司强行参加的一场周赛，迟到 15min。掉分 43+
模拟。
时间复杂度 O(n)。
 */