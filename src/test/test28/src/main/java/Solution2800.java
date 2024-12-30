public class Solution2800 {
    private static final int[][] PERMS = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};

    public String minimumString(String a, String b, String c) {
        String[] arr = {a, b, c};
        String ans = null;
        for (int[] p : PERMS) {
            String s = merge(merge(arr[p[0]], arr[p[1]]), arr[p[2]]);
            if (ans == null
                    || s.length() < ans.length()
                    || s.length() == ans.length() && s.compareTo(ans) < 0) {
                ans = s;
            }
        }
        return ans;
    }

    private String merge(String s, String t) {
        if (s.contains(t)) return s;
        if (t.contains(s)) return t;
        for (int i = Math.min(s.length(), t.length()); i > 0; i--) {
            if (s.endsWith(t.substring(0, i))) {
                return s + t.substring(i);
            }
        }
        return s + t;
    }
}
/*
2800. 包含三个字符串的最短字符串
https://leetcode.cn/problems/shortest-string-that-contains-three-strings/

第 356 场周赛 T3。

给你三个字符串 a ，b 和 c ， 你的任务是找到长度 最短 的字符串，且这三个字符串都是它的 子字符串 。
如果有多个这样的字符串，请你返回 字典序最小 的一个。
请你返回满足题目要求的字符串。
注意：
- 个长度相同的字符串 a 和 b ，如果在第一个不相同的字符处，a 的字母在字母表中比 b 的字母 靠前 ，那么字符串 a 比字符串 b 字典序小 。
- 字符串 是一个字符串中一段连续的字符序列。
提示：
1 <= a.length, b.length, c.length <= 100
a ，b ，c 只包含小写英文字母。

暴力。枚举出所有排列情况。
时间复杂度 O(n^2)
 */