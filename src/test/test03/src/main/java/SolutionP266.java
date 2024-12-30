public class SolutionP266 {
    public boolean canPermutePalindrome(String s) {
        int[] cntArr = new int[26];
        int cntOdd = 0;
        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
            if (cntArr[ch - 'a'] % 2 == 0) {
                cntOdd--;
            } else {
                cntOdd++;
            }
        }
        return cntOdd <= 1;
    }
}
/*
$266. 回文排列
https://leetcode.cn/problems/palindrome-permutation/

给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
Constraints:
1 <= s.length <= 5000
s consists of only lowercase English letters.

统计频次，最多允许有 1 个奇数频次。
相似题目: $267. 回文排列 II
https://leetcode.cn/problems/palindrome-permutation-ii/
 */