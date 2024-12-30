public class Solution3146 {
    public int findPermutationDifference(String s, String t) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            ans += Math.abs(i - t.indexOf(c));
        }
        return ans;
    }
}
/*
3146. 两个字符串的排列差
https://leetcode.cn/problems/permutation-difference-between-two-strings/description/

第 397 场周赛 T1。

给你两个字符串 s 和 t，每个字符串中的字符都不重复，且 t 是 s 的一个排列。
排列差 定义为 s 和 t 中每个字符在两个字符串中位置的绝对差值之和。
返回 s 和 t 之间的 排列差 。
提示：
1 <= s.length <= 26
每个字符在 s 中最多出现一次。
t 是 s 的一个排列。
s 仅由小写英文字母组成。

模拟。注意审题。
时间复杂度 O(n)。
 */