public class SolutionP186 {
    public void reverseWords(char[] s) {
        int len = s.length;
        int l = 0;
        int r = 0;
        for (; r < len; r++) {
            if (s[r] == ' ') {
                swap(s, l, r - 1);
                l = r + 1;
                r = l;
            }
        }
        swap(s, l, r - 1);
        swap(s, 0, s.length - 1);
    }

    // 翻转 s[l, r]
    private void swap(char[] s, int l, int r) {
        int len = r - l + 1;
        for (int i = 0; i < len / 2; i++) {
            char tmp = s[l + i];
            s[l + i] = s[l + len - 1 - i];
            s[l + len - 1 - i] = tmp;
        }
    }
}
/*
$186. 反转字符串中的单词 II
https://leetcode.cn/problems/reverse-words-in-a-string-ii/

给你一个字符数组 s ，反转其中 单词 的顺序。
单词 的定义为：单词是一个由非空格字符组成的序列。s 中的单词将会由单个空格分隔。
必须设计并实现 原地 解法来解决此问题，即不分配额外的空间。
提示：
1 <= s.length <= 10^5
s[i] 可以是一个英文字母（大写或小写）、数字、或是空格 ' ' 。
s 中至少存在一个单词
s 不含前导或尾随空格
题目数据保证：s 中的每个单词都由单个空格分隔

两次翻转：整体翻转 + 单词翻转
 */