public class Solution2957 {
    public int removeAlmostEqualCharacters(String word) {
        int n = word.length();
        char[] s = word.toCharArray();
        int ans = 0;
        int i = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && Math.abs(s[i] - s[i - 1]) <= 1; i++) {
            }
            ans += (i - st) / 2;
        }
        return ans;
    }
}
/*
2957. 消除相邻近似相等字符
https://leetcode.cn/problems/remove-adjacent-almost-equal-characters/description/

第 119 场双周赛 T2。

给你一个下标从 0 开始的字符串 word 。
一次操作中，你可以选择 word 中任意一个下标 i ，将 word[i] 修改成任意一个小写英文字母。
请你返回消除 word 中所有相邻 近似相等 字符的 最少 操作次数。
两个字符 a 和 b 如果满足 a == b 或者 a 和 b 在字母表中是相邻的，那么我们称它们是 近似相等 字符。
提示：
1 <= word.length <= 100
word 只包含小写英文字母。

分组循环。答案为每个分组的长度 / 2 的和。
时间复杂度 O(n)
 */