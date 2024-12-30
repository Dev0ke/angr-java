public class Solution2187 {
    public long minimumTime(int[] time, int totalTrips) {
        // 二分
        long left = 1L;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(time, totalTrips, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int[] time, int totalTrips, long mid) {
        long cnt = 0;
        for (int ti : time) {
            cnt += mid / ti;
            if (cnt >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}
/*
2187. 完成旅途的最少时间
https://leetcode.cn/problems/minimum-time-to-complete-trips/

第 282 场周赛 T3。

给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。
每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，也就是说可以同时有多辆公交车在运行且互不影响。
给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。
提示：
1 <= time.length <= 10^5
1 <= time[i], totalTrips <= 10^7

边界二分。
注意边界，比赛时候 WA 了两次。
 */