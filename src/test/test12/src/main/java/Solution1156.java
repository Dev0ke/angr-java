public class Solution1156 {
    public int maxRepOpt1(String text) {
        int n = text.length();
        char[] s = text.toCharArray();

        int[] cntArr = new int[26];
        for (char ch : s) {
            cntArr[ch - 'a']++;
        }

        int ans = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // 双指针，交换次数
            int l = 0, r = 0, time = 0;
            while (r < n) {
                if (s[r] != ch) time++;
                while (time > 1) {
                    if (s[l] != ch) time--;
                    l++;
                }
                if (cntArr[ch - 'a'] >= r - l + 1) {
                    ans = Math.max(ans, r - l + 1);
                }
                r++;
            }
        }
        return ans;
    }
}
/*
1156. 单字符重复子串的最大长度
https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/

如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
提示：
1 <= text.length <= 20000
text 仅由小写英文字母组成。

双指针 滑动窗口
 */