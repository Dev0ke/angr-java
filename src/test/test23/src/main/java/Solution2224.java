public class Solution2224 {
    public int convertTime(String current, String correct) {
        int currentTime = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3, 5));
        int correctTime = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3, 5));

        int cnt = 0;
        if (correctTime - currentTime >= 60) {
            int diff = correctTime - currentTime;
            currentTime += diff / 60 * 60;
            cnt += diff / 60;
        }
        if (correctTime - currentTime >= 15) {
            int diff = correctTime - currentTime;
            currentTime += diff / 15 * 15;
            cnt += diff / 15;
        }
        if (correctTime - currentTime >= 5) {
            int diff = correctTime - currentTime;
            currentTime += diff / 5 * 5;
            cnt += diff / 5;
        }
        cnt += correctTime - currentTime;
        return cnt;
    }
}
/*
2224. 转化时间需要的最少操作数
https://leetcode.cn/problems/minimum-number-of-operations-to-convert-time/

第 287 场周赛 T1。

给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
返回将 current 转化为 correct 需要的 最少操作数 。
提示：
current 和 correct 都符合 "HH:MM" 格式
current <= correct

贪心。
 */