public class Solution2108 {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPal(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPal(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
/*
2108. 找出数组中的第一个回文字符串
https://leetcode.cn/problems/find-first-palindromic-string-in-the-array/

第 272 场周赛 T1。

给你一个字符串数组 words ，找出并返回数组中的 第一个回文字符串 。如果不存在满足要求的字符串，返回一个 空字符串 "" 。
回文字符串 的定义为：如果一个字符串正着读和反着读一样，那么该字符串就是一个 回文字符串 。

双指针模拟判断回文串。
 */