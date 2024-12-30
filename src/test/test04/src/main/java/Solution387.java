public class Solution387 {
    public int firstUniqChar(String s) {
        int[] cntArr = new int[26];
        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (cntArr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
/*
387. 字符串中的第一个唯一字符
https://leetcode.cn/problems/first-unique-character-in-a-string/

给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
提示:
1 <= s.length <= 10^5
s 只包含小写字母

统计频次
 */