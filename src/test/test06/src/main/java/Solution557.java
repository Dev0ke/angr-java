public class Solution557 {
    public String reverseWords(String s) {
        String[] reverseSs = new StringBuilder(s).reverse().toString().split(" ");
        reverseStrings(reverseSs);
        return String.join(" ", reverseSs);
    }

    private void reverseStrings(String[] s) {
        int len = s.length;
        for (int left = 0; left < len / 2; left++) {
            int right = len - 1 - left;
            String tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
/*
557. 反转字符串中的单词 III
https://leetcode.cn/problems/reverse-words-in-a-string-iii/

给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
提示：
1 <= s.length <= 5 * 10^4
s 包含可打印的 ASCII 字符。
s 不包含任何开头或结尾空格。
s 里 至少 有一个词。
s 中的所有单词都用一个空格隔开。
"Let's take LeetCode contest"
"s'teL ekat edoCteeL tsetnoc"

两次翻转
step1: 整行翻转 tsetnoc edoCteeL ekat s'teL
step2: 数组翻转 s'teL ekat edoCteeL tsetnoc
时间复杂度 O(n)
空间复杂度 O(n)
注意：原地解法在某些语言（比如 Java，JavaScript）中不适用，因为在这些语言中 String 类型是一个不可变的类型。
 */