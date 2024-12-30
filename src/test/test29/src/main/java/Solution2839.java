import java.util.ArrayList;
import java.util.List;

public class Solution2839 {
    public boolean canBeEqual(String s1, String s2) {
        List<Character> s1odd = new ArrayList<>();
        List<Character> s1even = new ArrayList<>();
        List<Character> s2odd = new ArrayList<>();
        List<Character> s2even = new ArrayList<>();
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                s1odd.add(s1.charAt(i));
                s2odd.add(s2.charAt(i));
            } else {
                s1even.add(s1.charAt(i));
                s2even.add(s2.charAt(i));
            }
        }
        s1odd.sort(null);
        s1even.sort(null);
        s2odd.sort(null);
        s2even.sort(null);

        return s1odd.equals(s2odd) && s1even.equals(s2even);
    }
}
/*
2839. 判断通过操作能否让字符串相等 I
https://leetcode.cn/problems/check-if-strings-can-be-made-equal-with-operations-i/

第 112 场双周赛 T1。

给你两个字符串 s1 和 s2 ，两个字符串的长度都为 4 ，且只包含 小写 英文字母。
你可以对两个字符串中的 任意一个 执行以下操作 任意 次：
- 选择两个下标 i 和 j 且满足 j - i = 2 ，然后 交换 这个字符串中两个下标对应的字符。
如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。
提示：
s1.length == s2.length == 4
s1 和 s2 只包含小写英文字母。

先做 T2 在做 T1
同 2840. 判断通过操作能否让字符串相等 II
https://leetcode.cn/problems/check-if-strings-can-be-made-equal-with-operations-ii/
 */