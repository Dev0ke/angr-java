public class Solution2437 {
    public int countTime(String time) {
        int a = time.charAt(0) == '?' ? 10 : time.charAt(0) - '0';
        int b = time.charAt(1) == '?' ? 10 : time.charAt(1) - '0';
        int c = time.charAt(3) == '?' ? 10 : time.charAt(3) - '0';
        int d = time.charAt(4) == '?' ? 10 : time.charAt(4) - '0';
        return dfs(a, b, c, d);
    }

    private int dfs(int a, int b, int c, int d) {
        if (a < 10 && b < 10 && c < 10 && d < 10) {
            return ((a * 10 + b < 24) && (c * 10 + d < 60)) ? 1 : 0;
        }

        int res = 0;
        if (a == 10) {
            for (int i = 0; i <= 2; i++) {
                res += dfs(i, b, c, d);
            }
        } else if (b == 10) {
            for (int i = 0; i <= 9; i++) {
                res += dfs(a, i, c, d);
            }
        } else if (c == 10) {
            for (int i = 0; i <= 5; i++) {
                res += dfs(a, b, i, d);
            }
        } else if (d == 10) {
            for (int i = 0; i <= 9; i++) {
                res += dfs(a, b, c, i);
            }
        }
        return res;
    }

    // 暴力枚举
    public int countTime2(String time) {
        int cnt = 0;
        for (int hh = 0; hh < 24; hh++) {
            for (int mm = 0; mm < 60; mm++) {
                if (check(time, hh, mm)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean check(String time, int hh, int mm) {
        int t0 = hh / 10;
        int t1 = hh % 10;
        int t3 = mm / 10;
        int t4 = mm % 10;
        return (time.charAt(0) == '?' || time.charAt(0) - '0' == t0)
                && (time.charAt(1) == '?' || time.charAt(1) - '0' == t1)
                && (time.charAt(3) == '?' || time.charAt(3) - '0' == t3)
                && (time.charAt(4) == '?' || time.charAt(4) - '0' == t4);
    }
}
/*
2437. 有效时间的数目
https://leetcode.cn/problems/number-of-valid-clock-times/

第 89 场双周赛 T1。

给你一个长度为 5 的字符串 time ，表示一个电子时钟当前的时间，格式为 "hh:mm" 。最早 可能的时间是 "00:00" ，最晚 可能的时间是 "23:59" 。
在字符串 time 中，被字符 ? 替换掉的数位是 未知的 ，被替换的数字可能是 0 到 9 中的任何一个。
请你返回一个整数 answer ，将每一个 ? 都用 0 到 9 中一个数字替换后，可以得到的有效时间的数目。
提示：
time 是一个长度为 5 的有效字符串，格式为 "hh:mm" 。
"00" <= hh <= "23"
"00" <= mm <= "59"
字符串中有的数位是 '?' ，需要用 0 到 9 之间的数字替换。

记忆化搜索/暴力
时间复杂度 O(1) 常数为 1440
 */