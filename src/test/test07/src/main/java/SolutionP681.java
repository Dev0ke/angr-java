public class SolutionP681 {
    public String nextClosestTime(String time) {
        int mask = 0;
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue;
            mask |= (1 << (time.charAt(i) - '0'));
        }

        int cur = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        // 60*24
        for (int i = 1; i <= 1440; i++) {
            int t = (cur + i) % 1440;
            int hh = t / 60, mm = t % 60;
            int c1 = hh / 10, c2 = hh % 10, c3 = mm / 10, c4 = mm % 10;
            int tMask = (1 << c1) | (1 << c2) | (1 << c3) | (1 << c4);
            if ((mask & tMask) == tMask) {
                return "" + c1 + c2 + ':' + c3 + c4;
            }
        }
        return "-1";
    }
}
/*
$681. 最近时刻
https://leetcode.cn/problems/next-closest-time/

给定一个形如 "HH:MM" 表示的时刻 time ，利用当前出现过的数字构造下一个距离当前时间最近的时刻。每个出现数字都可以被无限次使用。
你可以认为给定的字符串一定是合法的。例如， "01:34" 和  "12:09" 是合法的，“1:34” 和 “12:9” 是不合法的。
提示：
time.length == 5
time 为有效时间，格式为 "HH:MM".
0 <= HH < 24
0 <= MM < 60

枚举 24 * 60 = 1440 种可能
时间复杂度 O(1)
 */