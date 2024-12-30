public class Solution777 {
    public boolean canTransform(String start, String end) {
        char[] s = start.toCharArray();
        char[] t = end.toCharArray();

        int i = 0, j = 0, n = s.length;
        while (i < n && j < n) {
            while (i < n && s[i] == 'X') i++;
            while (j < n && t[j] == 'X') j++;
            if (i < n && j < n) {
                if (s[i] != t[j]) {
                    return false;
                } else {
                    if ((s[i] == 'L' && i < j) || (s[i] == 'R' && i > j)) {
                        return false;
                    }
                    i++;
                    j++;
                }
            }
        }
        while (i < n && s[i] == 'X') i++;
        while (j < n && t[j] == 'X') j++;
        return i == n && j == n;
    }
}
/*
777. 在LR字符串中交换相邻字符
https://leetcode.cn/problems/swap-adjacent-in-lr-string/

在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。
现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
提示：
1 <= len(start) = len(end) <= 10000。
start和end中的字符串仅限于'L', 'R'和'X'。

双指针
相似题目: 2337. 移动片段得到字符串
https://leetcode.cn/problems/move-pieces-to-obtain-a-string/
 */