public class Solution2278 {
    public int percentageLetter(String s, char letter) {
        int len = s.length();

        int[] cntArr = new int[26];
        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
        }

        return (int) (cntArr[letter - 'a'] / (double) len * 100);
    }
}
/*
2278. 字母在字符串中的百分比
https://leetcode.cn/problems/percentage-of-letter-in-string/

第 294 场周赛 T1。

给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
提示：
1 <= s.length <= 100
s 由小写英文字母组成
letter 是一个小写英文字母

模拟
 */