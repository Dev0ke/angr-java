public class Solution1332 {
    public int removePalindromeSub(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return 2;
            }
        }
        return 1;
    }
}
/*
1332. 删除回文子序列
https://leetcode.cn/problems/remove-palindromic-subsequences/

第 173 场周赛 T1。

给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
提示：
1 <= s.length <= 1000
s 仅包含字母 'a'  和 'b'

脑筋急转弯，这个字符串太过特殊，问题等价于判断 字符串 本身是否是回文，如果是回文，最小删除次数是 1，否则是 2.
 */