public class SolutionP2330 {
    public boolean makePalindrome(String s) {
        int n = s.length();
        int diff = 0;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) diff++;
            if (diff > 2) return false;
        }
        return true;
    }
}
/*
$2330. 验证回文串 IV
https://leetcode.cn/problems/valid-palindrome-iv/description/

给你一个下标从 0 开始、仅由小写英文字母组成的字符串 s 。在一步操作中，你可以将 s 中的任一字符更改为其他任何字符。
如果你能在 恰 执行一到两步操作后使 s 变成一个回文，则返回 true ，否则返回 false 。
提示：
1 <= s.length <= 10^5
s 仅由小写英文字母组成

双指针。
时间复杂度 O(n)。
 */