public class Solution1540 {
    public boolean canConvertString(String S, String T, int k) {
        if (S.length() != T.length()) return false;
        // 长度相等
        int n = S.length();
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            int d = (t[i] - s[i] + 26) % 26;
            cnt[d]++;
        }
        for (int i = 1; i < 26; i++) {
            int maxConvert = i + 26 * (cnt[i] - 1);
            if (maxConvert > k) {
                return false;
            }
        }
        return true;
    }
}
/*
1540. K 次操作转变字符串
https://leetcode.cn/problems/can-convert-string-in-k-moves/description/

给你两个字符串 s 和 t ，你的目标是在 k 次操作以内把字符串 s 转变成 t 。
在第 i 次操作时（1 <= i <= k），你可以选择进行如下操作：
- 选择字符串 s 中满足 1 <= j <= s.length 且之前未被选过的任意下标 j （下标从 1 开始），并将此位置的字符切换 i 次。
- 不进行任何操作。
切换 1 个字符的意思是用字母表中该字母的下一个字母替换它（字母表环状接起来，所以 'z' 切换后会变成 'a'）。第 i 次操作意味着该字符应切换 i 次
请记住任意一个下标 j 最多只能被操作 1 次。
如果在不超过 k 次操作内可以把字符串 s 转变成 t ，那么请你返回 true ，否则请你返回 false 。
提示：
1 <= s.length, t.length <= 10^5
0 <= k <= 10^9
s 和 t 只包含小写英文字母。

模拟，计数。
时间复杂度 O(n + 26)。
 */