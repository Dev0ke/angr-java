public class Solution2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        for (int i = n / 2; i >= 0; i--) {
            String target = "0".repeat(i) + "1".repeat(i);
            if (s.contains(target)) {
                return i * 2;
            }
        }
        return 0;
    }

    // 时间复杂度 O(n) 空间复杂度 O(1) 解法
    public int findTheLongestBalancedSubstring2(String s) {
        char[] cs = s.toCharArray();
        int ans = 0, pre = 0, cur = 0, n = cs.length;
        for (int i = 0; i < n; i++) {
            ++cur;
            if (i == n - 1 || cs[i] != cs[i + 1]) {
                if (cs[i] == '1') {
                    ans = Math.max(ans, Math.min(pre, cur) * 2);
                }
                pre = cur;
                cur = 0;
            }
        }
        return ans;
    }
}
/*
2609. 最长平衡子字符串
https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/

第 339 场周赛 T1。

给你一个仅由 0 和 1 组成的二进制字符串 s 。  
如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
返回  s 中最长的平衡子字符串长度。
子字符串是字符串中的一个连续字符序列。
提示：
1 <= s.length <= 50
'0' <= s[i] <= '1'

暴力。
 */