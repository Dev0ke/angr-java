public class Solution917 {
    public String reverseOnlyLetters(String s) {
        int len = s.length();

        char[] chars = s.toCharArray();
        // 双指针
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(chars[right])) {
                right--;
            }
            // swap
            char ch = chars[left];
            chars[left] = chars[right];
            chars[right] = ch;

            left++;
            right--;
        }
        return new String(chars);
    }
}
/*
917. 仅仅反转字母
https://leetcode.cn/problems/reverse-only-letters/

第 105 场周赛 T1。

给你一个字符串 s ，根据下述规则反转字符串：
- 所有非英文字母保留在原有位置。
- 所有英文字母（小写或大写）位置反转。
返回反转后的 s 。
提示
1 <= s.length <= 100
s 仅由 ASCII 值在范围 [33, 122] 的字符组成
s 不含 '\"' 或 '\\'

双指针翻转即可。
 */