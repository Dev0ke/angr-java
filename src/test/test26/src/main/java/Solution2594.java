public class Solution2594 {
    public long repairCars(int[] ranks, int cars) {
        long left = 0L;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 时间为 mid，能否完成修理
    private boolean checkMid(int[] ranks, int cars, long mid) {
        long k = 0;
        for (int r : ranks) {
            long n2 = mid / r;
            long n = (long) Math.sqrt(n2);
            k += n;
        }
        return k >= cars;
    }
}
/*
2594. 修车的最少时间
https://leetcode.cn/problems/minimum-time-to-repair-cars/

第 100 场双周赛 T4。

给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。
同时给你一个整数 cars ，表示总共需要修理的汽车数目。
请你返回修理所有汽车 最少 需要多少时间。
注意：所有机械工可以同时修理汽车。
提示：
1 <= ranks.length <= 10^5
1 <= ranks[i] <= 100
1 <= cars <= 10^6

二分答案。
答案有单调性，可以二分答案。
时间复杂度 O(nlogU)。这里为了方便，U 直接取到了 2^63-1。
 */