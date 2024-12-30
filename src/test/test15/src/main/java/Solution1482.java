public class Solution1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }

        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 等待天数为 mid 天时，能否取到 m 束 k 朵花 FFFTTT
    private boolean checkMid(int[] bloomDay, int m, int k, int mid) {
        int cnt = 0;
        for (int bloom : bloomDay) {
            if (bloom <= mid) {
                cnt++;
                if (cnt >= k) {
                    m--;
                    cnt = 0;
                }
            } else {
                cnt = 0;
            }
        }
        return m <= 0;
    }
}
/*
1482. 制作 m 束花所需的最少天数
https://leetcode.cn/problems/minimum-number-of-days-to-make-m-bouquets/

给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
提示：
bloomDay.length == n
1 <= n <= 10^5
1 <= bloomDay[i] <= 10^9
1 <= m <= 10^6
1 <= k <= n

二分
 */