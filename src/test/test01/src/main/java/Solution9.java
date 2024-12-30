public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x >= 0) {
            String xStr = String.valueOf(x);
            return xStr.equals(new StringBuilder(xStr).reverse().toString());
        }
        return false;
    }
}
/*
9. 回文数
https://leetcode.cn/problems/palindrome-number/

给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
- 例如，121 是回文，而 123 不是。
提示：
-2^31 <= x <= 2^31 - 1
进阶：你能不将整数转为字符串来解决这个问题吗？

字符串 或 转化成数组
 */