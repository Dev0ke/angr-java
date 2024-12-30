public class Solution949 {
    public String largestTimeFromDigits(int[] arr) {
        int res = -1;
        for (int h0 = 0; h0 < 4; h0++) {
            for (int h1 = 0; h1 < 4; h1++) {
                if (h1 == h0) {
                    continue;
                }
                for (int m0 = 0; m0 < 4; m0++) {
                    if (m0 == h0 || m0 == h1) {
                        continue;
                    }
                    int m1 = 6 - h0 - h1 - m0;
                    int hour = arr[h0] * 10 + arr[h1];
                    int minute = arr[m0] * 10 + arr[m1];
                    if (hour <= 23 && minute <= 59) {
                        res = Math.max(res, hour * 60 + minute);
                    }
                }
            }
        }
        if (res == -1) {
            return "";
        }
        return String.format("%02d:%02d", res / 60, res % 60);
    }
}
/*
949. 给定数字能组成的最大时间
https://leetcode.cn/problems/largest-time-for-given-digits/

第 113 场周赛 T1。

给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
24 小时格式为 "HH:MM" ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大的是 23:59 。
从 00:00 （午夜）开始算起，过得越久，时间越大。
以长度为 5 的字符串，按 "HH:MM" 格式返回答案。如果不能确定有效时间，则返回空字符串。
提示：
arr.length == 4
0 <= arr[i] <= 9

暴力。三层 for 循环。最多 24 种情况。
时间复杂度 O(1)
空间复杂度 O(1)
 */