public class Solution389 {
    public char findTheDifference(String s, String t) {
        int[] cntArrS = new int[26];
        int[] cntArrT = new int[26];
        for (char ch : s.toCharArray()) {
            cntArrS[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            cntArrT[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cntArrS[i] != cntArrT[i]) {
                return (char) ('a' + i);
            }
        }
        return '?';
    }
}
/*
389. 找不同
https://leetcode.cn/problems/find-the-difference/

给定两个字符串 s 和 t ，它们只包含小写字母。
字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
请找出在 t 中被添加的字母。
提示：
0 <= s.length <= 1000
t.length == s.length + 1
s 和 t 只包含小写字母

长度为26的数组模拟哈希表统计字符频次。
时间复杂度 O(n)
 */