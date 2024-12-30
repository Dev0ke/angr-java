public class Solution1446 {
    public int maxPower(String s) {
        // 双指针
        int left = 0;
        int right = 0;
        int max = 1;
        while (right < s.length()) {
            if (s.charAt(right) != s.charAt(left)) {
                max = Math.max(max, right - left);
                left = right;
            } else {
                if (right == s.length() - 1) {
                    max = Math.max(max, right - left + 1);
                }
            }
            right++;
        }
        return max;
    }
}
/*
1446. 连续字符
https://leetcode.cn/problems/consecutive-characters/

第 26 场双周赛 T1。

给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
请你返回字符串的能量。
提示：
1 <= s.length <= 500
s 只包含小写英文字母。

双指针。
 */