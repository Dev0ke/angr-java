public class Solution2000 {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        String subString1 = word.substring(0, idx + 1);
        String subString2 = word.substring(idx + 1);
        String reverseSubString = new StringBuilder(subString1).reverse().toString();
        return reverseSubString + subString2;
    }
}
/*
2000. 反转单词前缀
https://leetcode.cn/problems/reverse-prefix-of-word/

第 258 场周赛 T1。

给你一个下标从 0 开始的字符串 word 和一个字符 ch 。
找出 ch 第一次出现的下标 i ，反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。如果 word 中不存在字符 ch ，则无需进行任何操作。
- 例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。结果字符串将会是 "dcbaefd" 。
返回 结果字符串 。
提示：
1 <= word.length <= 250
word 由小写英文字母组成
ch 是一个小写英文字母

模拟。
 */