import java.util.Arrays;

public class Solution1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] cntArr1 = new int[26];
        int[] cntArr2 = new int[26];
        int len = s1.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            cntArr1[ch1 - 'a']++;
            cntArr2[ch2 - 'a']++;
            if (ch1 != ch2) {
                cnt++;
            }
        }
        return Arrays.equals(cntArr1, cntArr2) && (cnt == 0 || cnt == 2);
    }
}
/*
1790. 仅执行一次字符串交换能否使两个字符串相等
https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/

给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
提示：
1 <= s1.length, s2.length <= 100
s1.length == s2.length
s1 和 s2 仅由小写英文字母组成

条件：两个字符串字符频次相等 + 0 个或 2 个下标字符不等
 */