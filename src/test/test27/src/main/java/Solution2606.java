public class Solution2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        // 预处理
        int[] chVal = new int[26];
        for (int i = 0; i < 26; i++) {
            chVal[i] = i + 1;
        }
        for (int i = 0; i < chars.length(); i++) {
            chVal[chars.charAt(i) - 'a'] = vals[i];
        }
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = chVal[s.charAt(i) - 'a'];
        }

        // solution53
        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp = nums[i] + Math.max(dp, 0);
            max = Math.max(max, dp);
        }
        return Math.max(0, max);
    }
}
/*
2606. 找到最大开销的子字符串
https://leetcode.cn/problems/find-the-substring-with-maximum-cost/

第 101 场双周赛 T2。

给你一个字符串 s ，一个字符 互不相同 的字符串 chars 和一个长度与 chars 相同的整数数组 vals 。
子字符串的开销 是一个子字符串中所有字符对应价值之和。空字符串的开销是 0 。
字符的价值 定义如下：
- 如果字符不在字符串 chars 中，那么它的价值是它在字母表中的位置（下标从 1 开始）。
  - 比方说，'a' 的价值为 1 ，'b' 的价值为 2 ，以此类推，'z' 的价值为 26 。
- 否则，如果这个字符在 chars 中的位置为 i ，那么它的价值就是 vals[i] 。
请你返回字符串 s 的所有子字符串中的最大开销。
提示：
1 <= s.length <= 10^5
s 只包含小写英文字母。
1 <= chars.length <= 26
chars 只包含小写英文字母，且 互不相同 。
vals.length == chars.length
-1000 <= vals[i] <= 1000

最大子数组和 套壳题。动态规划。
相似题目: 53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/
 */