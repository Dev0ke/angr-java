public class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length(), m = typed.length();
        char[] s = name.toCharArray(), t = typed.toCharArray();
        int i = 0, j = 0;
        while (j < m) {
            if (i < n && s[i] == t[j]) {
                i++;
                j++;
            } else if (j - 1 >= 0 && t[j] == t[j - 1]) {
                j++;
            } else {
                return false;
            }
        }
        return i == n;
    }
}
/*
925. 长按键入
https://leetcode.cn/problems/long-pressed-name/description/

你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
提示：
1 <= name.length, typed.length <= 1000
name 和 typed 的字符都是小写字母

双指针。
时间复杂度 O(n + m)。
 */