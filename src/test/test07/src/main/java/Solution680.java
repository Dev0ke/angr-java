public class Solution680 {
    public boolean validPalindrome(String s) {
        // 双指针 两侧向中心
        int left = 0;
        int right = s.length() - 1;
        while (left < s.length() / 2) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }
        // 三种情况 满足其一即可
        return left == s.length() / 2
                || isPalindrome(s, left, right - 1)
                || isPalindrome(s, left + 1, right);
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }
        return left >= right;
    }
}
/*
680. 验证回文字符串 Ⅱ
https://leetcode.cn/problems/valid-palindrome-ii/

给你一个字符串 s，最多 可以从中删除一个字符。
请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
提示：
1 <= s.length <= 10^5
s 由小写英文字母组成

贪心
时间复杂度 O(n)
空间复杂度 O(1)
 */
