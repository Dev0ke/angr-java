public class Solution849 {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int max = 0;

        int start = -1;
        int end = -1;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 1) {
                max = Math.max(max, i);
                start = i;
                break;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                max = Math.max(max, len - 1 - i);
                end = i;
                break;
            }
        }

        int cnt0 = 0;
        for (int i = start; i <= end; i++) {
            if (seats[i] == 0) {
                cnt0++;
            } else {
                max = Math.max(max, (cnt0 + 1) / 2);
                cnt0 = 0;
            }
        }
        return max;
    }
}
/*
849. 到最近的人的最大距离
https://leetcode.cn/problems/maximize-distance-to-closest-person/

给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
至少有一个空座位，且至少有一人已经坐在座位上。
亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
返回他到离他最近的人的最大距离。
提示：
2 <= seats.length <= 2 * 10^4
seats[i] 为 0 或 1
至少有一个 空座位
至少有一个 座位上有人

贪心。
如果下标 0 无人，则应选下标 0，右边最近一人下标为 i，距离为 i；
如果下标 n-1 无人，则应选下标 n-1，右边最近一人下标为 i，距离为 n-1-i；
其他位置，统计连续 0 的个数（假设为 k），最近距离为 (k+1)/2
时间复杂度 O(n)
空间复杂度 O(1)
 */