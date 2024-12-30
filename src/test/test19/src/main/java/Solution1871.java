public class Solution1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] f = new boolean[n];
        int[] pre = new int[n];
        f[0] = true;
        for (int i = 0; i < minJump; i++) {
            pre[i] = 1;
        }
        for (int i = minJump; i < n; i++) {
            int left = i - maxJump, right = i - minJump;
            if (s.charAt(i) == '0') {
                int tot = pre[right] - (left - 1 >= 0 ? pre[left - 1] : 0);
                f[i] = tot > 0; // 只要存在一个 j 满足 f[j] = true，就可以从 j 跳到 i
            }
            pre[i] = pre[i - 1] + (f[i] ? 1 : 0);
        }
        return f[n - 1];
    }
}
/*
1871. 跳跃游戏 VII
https://leetcode.cn/problems/jump-game-vii/description/

给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时满足如下条件时，你可以从下标 i 移动到下标 j 处：
- i + minJump <= j <= min(i + maxJump, s.length - 1) 且
- s[j] == '0'.
如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。
提示：
2 <= s.length <= 10^5
s[i] 要么是 '0' ，要么是 '1'
s[0] == '0'
1 <= minJump <= maxJump < s.length

前缀和优化 DP。
f(i) 表示能否从位置 0 按照给定的规则跳到位置 i。
时间复杂度 O(n)。
 */