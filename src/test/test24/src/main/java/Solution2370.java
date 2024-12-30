public class Solution2370 {
    public int longestIdealString(String s, int k) {
        int[] cntArr = new int[26];
        for (char ch : s.toCharArray()) {
            int left = Math.max(ch - 'a' - k, 0);
            int right = Math.min(ch - 'a' + k, 25);
            int max = 0;
            for (int i = left; i <= right; i++) {
                max = Math.max(max, cntArr[i]);
            }
            cntArr[ch - 'a'] = max + 1;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = Math.max(ans, cntArr[i]);
        }
        return ans;
    }
}
/*
2370. 最长理想子序列
https://leetcode.cn/problems/longest-ideal-subsequence/

第 305 场周赛 T4。

给你一个由小写字母组成的字符串 s ，和一个整数 k 。如果满足下述条件，则可以将字符串 t 视作是 理想字符串 ：
- t 是字符串 s 的一个子序列。
- t 中每两个 相邻 字母在字母表中位次的绝对差值小于或等于 k 。
返回 最长 理想字符串的长度。
字符串的子序列同样是一个字符串，并且子序列还满足：可以经由其他字符串删除某些字符（也可以不删除）但不改变剩余字符的顺序得到。
注意：字母表顺序不会循环。例如，'a' 和 'z' 在字母表中位次的绝对差值是 25 ，而不是 1 。
提示：
1 <= s.length <= 10^5
0 <= k <= 25
s 由小写英文字母组成

贪心。
时间复杂度：O(n)。常数为 26.
 */