import java.util.Arrays;

public class Solution1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] s = s1.toCharArray();
        char[] t = s2.toCharArray();
        Arrays.sort(s);
        Arrays.sort(t);
        return check(s, t) || check(t, s);
    }

    private boolean check(char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) return false;
        }
        return true;
    }
}
/*
1433. 检查一个字符串是否可以打破另一个字符串
https://leetcode.cn/problems/check-if-a-string-can-break-another-string/description/

给你两个字符串 s1 和 s2 ，它们长度相等，请你检查是否存在一个 s1  的排列可以打破 s2 的一个排列，或者是否存在一个 s2 的排列可以打破 s1 的一个排列。
字符串 x 可以打破字符串 y （两者长度都为 n ）需满足对于所有 i（在 0 到 n - 1 之间）都有 x[i] >= y[i]（字典序意义下的顺序）。
提示：
s1.length == n
s2.length == n
1 <= n <= 10^5
所有字符串都只包含小写英文字母。

排序后模拟。
时间复杂度 O(nlogn)。
 */