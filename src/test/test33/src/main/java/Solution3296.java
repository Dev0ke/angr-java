public class Solution3296 {
    private int mountainHeight;

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        this.mountainHeight = mountainHeight;

        long left = 0;
        long right = (long) (2e18 + 5);
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mountainHeight, workerTimes, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int mountainHeight, int[] workerTimes, long mid) {
        long curHeight = 0;
        for (int workerTime : workerTimes) {
            curHeight += get_max_x(workerTime, mid);
            if (curHeight >= mountainHeight) return true;
        }
        return false;
    }

    private long get_max_x(long workerTime, long mid) {
        long left = 1;
        long right = mountainHeight + 1;
        while (left < right) {
            long x = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (x * (x + 1) * workerTime > mid * 2) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left - 1;
    }
}
/*
3296. 移山所需的最少秒数
https://leetcode.cn/problems/minimum-number-of-seconds-to-make-mountain-height-zero/description/

第 416 场周赛 T2。

给你一个整数 mountainHeight 表示山的高度。
同时给你一个整数数组 workerTimes，表示工人们的工作时间（单位：秒）。
工人们需要 同时 进行工作以 降低 山的高度。对于工人 i :
- 山的高度降低 x，需要花费 workerTimes[i] + workerTimes[i] * 2 + ... + workerTimes[i] * x 秒。例如：
  - 山的高度降低 1，需要 workerTimes[i] 秒。
  - 山的高度降低 2，需要 workerTimes[i] + workerTimes[i] * 2 秒，依此类推。
返回一个整数，表示工人们使山的高度降低到 0 所需的 最少 秒数。
提示：
1 <= mountainHeight <= 10^5
1 <= workerTimes.length <= 10^4
1 <= workerTimes[i] <= 10^6

二分答案。注意 get_max_x 的二分。或者用一元二次方程求根公式。
 */