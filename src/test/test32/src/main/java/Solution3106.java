public class Solution3106 {
    public String getSmallestString(String s, int k) {
        int n = s.length();
        char[] ans = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int to_a = ans[i] - 'a';
            int to_z_to_a = 'z' - ans[i] + 1;
            int min = Math.min(to_a, to_z_to_a);
            if (min <= k) {
                k -= min;
                ans[i] = 'a';
            } else {
                ans[i] -= (char) k;
                break;
            }
        }
        return new String(ans);
    }
}
/*
3106. 满足距离约束且字典序最小的字符串
https://leetcode.cn/problems/lexicographically-smallest-string-after-operations-with-constraint/description/

第 392 场周赛 T2。

给你一个字符串 s 和一个整数 k 。
定义函数 distance(s1, s2) ，用于衡量两个长度为 n 的字符串 s1 和 s2 之间的距离，即：
- 字符 'a' 到 'z' 按 循环 顺序排列，对于区间 [0, n - 1] 中的 i ，计算所有「 s1[i] 和 s2[i] 之间 最小距离」的 和 。
例如，distance("ab", "cd") == 4 ，且 distance("a", "z") == 1 。
你可以对字符串 s 执行 任意次 操作。在每次操作中，可以将 s 中的一个字母 改变 为 任意 其他小写英文字母。
返回一个字符串，表示在执行一些操作后你可以得到的 字典序最小 的字符串 t ，且满足 distance(s, t) <= k 。
提示：
1 <= s.length <= 100
0 <= k <= 2000
s 只包含小写英文字母。

贪心。由于是“环形序列”，两个方向求到 'a' 的最小值，如果不能变到 'a‘，则往下 -k。
时间复杂度 O(n)。
 */