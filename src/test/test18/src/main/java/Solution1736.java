public class Solution1736 {
    public String maximumTime(String time) {
        for (int t = 1440 - 1; t >= 0; t--) {
            String ans = int2hhmm(t);
            if (check(time, ans)) {
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
1736. 替换隐藏数字得到的最晚时间
https://leetcode.cn/problems/latest-time-by-replacing-hidden-digits/description/

给你一个字符串 time ，格式为  hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
提示：
time 的格式为 hh:mm
题目数据保证你可以由输入的字符串生成有效的时间

由 24*60-1 枚举到 0。
时间复杂度 O(n)。
相似题目: 3114. 替换字符可以得到的最晚时间
https://leetcode.cn/problems/latest-time-you-can-obtain-after-replacing-characters/description/
 */