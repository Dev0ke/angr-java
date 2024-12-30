public class Solution58 {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        return strings[strings.length - 1].length();
    }
}
/*
58. 最后一个单词的长度
https://leetcode.cn/problems/length-of-last-word/

给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
提示：
1 <= s.length <= 10^4
s 仅有英文字母和空格 ' ' 组成
s 中至少存在一个单词

模拟。
 */