public class Solution1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        // 不可能准时到达的情况，hour <= dist.length - 1
        if (hour <= dist.length - 1) {
            return -1;
        }

        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 时速为 mid 时，能否准时到达办公室 FFFTTT
    private boolean checkMid(int[] dist, double hour, int mid) {
        int n = dist.length;
        double cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            // 数论向上取整法
            cnt += Math.ceil(dist[i] / (double) mid);
        }
        cnt += dist[n - 1] / (double) mid;
        // 浮点数不能用 "==" 比较
        return cnt <= hour;
    }
}
/*
1870. 准时到达的列车最小时速
https://leetcode.cn/problems/minimum-speed-to-arrive-on-time/

第 242 场周赛 T2。

给你一个浮点数 hour ，表示你到达办公室可用的总通勤时间。要到达办公室，你必须按给定次序乘坐 n 趟列车。
另给你一个长度为 n 的整数数组 dist ，其中 dist[i] 表示第 i 趟列车的行驶距离（单位是千米）。
每趟列车均只能在整点发车，所以你可能需要在两趟列车之间等待一段时间。
- 例如，第 1 趟列车需要 1.5 小时，那你必须再等待 0.5 小时，搭乘在第 2 小时发车的第 2 趟列车。
返回能满足你准时到达办公室所要求全部列车的 最小正整数 时速（单位：千米每小时），如果无法准时到达，则返回 -1 。
生成的测试用例保证答案不超过 10^7 ，且 hour 的 小数点后最多存在两位数字 。
提示：
n == dist.length
1 <= n <= 10^5
1 <= dist[i] <= 10^5
1 <= hour <= 10^9
hours 中，小数点后最多存在两位数字

二分
 */
