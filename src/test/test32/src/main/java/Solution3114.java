public class Solution3114 {
    public String findLatestTime(String s) {
        for (int t = 720 - 1; t >= 0; t--) {
            String ans = int2hhmm(t);
            if (check(s, ans)) {
                return ans;
            }
        }
        return "-1";
    }

    private String int2hhmm(int t) {
        return String.format("%02d:%02d", t / 60, t % 60);
    }

    private boolean check(String s, String t) {
        for (int i = 0; i < 5; i++) {
            if (s.charAt(i) == '?') continue;
            if (s.charAt(i) != t.charAt(i)) return false;
        }
        return true;
    }
}
/*
3114. 替换字符可以得到的最晚时间
https://leetcode.cn/problems/latest-time-you-can-obtain-after-replacing-characters/description/

第 393 场周赛 T1。

给你一个字符串 s，表示一个 12 小时制的时间格式，其中一些数字（可能没有）被 "?" 替换。
12 小时制时间格式为 "HH:MM" ，其中 HH 的取值范围为 00 至 11，MM 的取值范围为 00 至 59。最早的时间为 00:00，最晚的时间为 11:59。
你需要将 s 中的 所有 "?" 字符替换为数字，使得结果字符串代表的时间是一个 有效 的 12 小时制时间，并且是可能的 最晚 时间。
返回结果字符串。
提示：
s.length == 5
s[2] 是字符 ":"
除 s[2] 外，其他字符都是数字或 "?"
输入保证在替换 "?" 字符后至少存在一个介于 "00:00" 和 "11:59" 之间的时间。

由 12*60-1 枚举到 0。
时间复杂度 O(n)。
相似题目: 1736. 替换隐藏数字得到的最晚时间
https://leetcode.cn/problems/latest-time-by-replacing-hidden-digits/description/
 */