public class Solution2486 {
    public int appendCharacters(String s, String t) {
        int p = 0;
        int q = 0;
        while (p < s.length() && q < t.length()) {
            if (s.charAt(p) == t.charAt(q)) {
                p++;
                q++;
            } else {
                p++;
            }
        }
        return t.length() - q;
    }
}
/*
2486. 追加字符以获得子序列
https://leetcode.cn/problems/append-characters-to-string-to-make-subsequence/

第 321 场周赛 T2。

给你两个仅由小写英文字母组成的字符串 s 和 t 。
现在需要通过向 s 末尾追加字符的方式使 t 变成 s 的一个 子序列 ，返回需要追加的最少字符数。
子序列是一个可以由其他字符串删除部分（或不删除）字符但不改变剩下字符顺序得到的字符串。
提示：
1 <= s.length, t.length <= 10^5
s 和 t 仅由小写英文字母组成

双指针
时间复杂度 O(|s| + |t|)
 */