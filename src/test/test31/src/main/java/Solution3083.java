public class Solution3083 {
    public boolean isSubstringPresent(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        for (int i = 0; i + 2 <= n; i++) {
            String sub = s.substring(i, i + 2);
            if (rev.contains(sub)) return true;
        }
        return false;
    }
}
/*
3083. 字符串及其反转中是否存在同一子字符串
https://leetcode.cn/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/

第 389 场周赛 T1。

给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。
如果存在这样的子字符串，返回 true；如果不存在，返回 false 。
提示：
1 <= s.length <= 100
字符串 s 仅由小写英文字母组成。

模拟。
 */