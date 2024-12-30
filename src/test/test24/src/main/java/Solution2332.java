import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2332 {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int n = buses.length;
        int m = passengers.length;

        Arrays.sort(buses);
        Arrays.sort(passengers);

        Set<Integer> cannot = new HashSet<>(m);
        for (int passenger : passengers) {
            cannot.add(passenger);
        }

        int j = 0;
        List<List<Integer>> listList = new ArrayList<>();
        for (int x : buses) {
            List<Integer> list = new ArrayList<>();
            for (int k = 0; j < m && passengers[j] <= x && k < capacity; j++, k++) {
                list.add(passengers[j]);
            }
            listList.add(list);
        }
        // 贪心
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> list = listList.get(i);
            if (list.isEmpty()) {
                return buses[i];
            }
            if (list.size() < capacity && list.get(list.size() - 1) + 1 <= buses[i]) {
                return buses[i];
            }
            for (int k = Math.min(list.size() - 1, capacity - 1); k >= 0; k--) {
                if (!cannot.contains(list.get(k) - 1)) {
                    return list.get(k) - 1;
                }
            }
        }
        return -1;
    }
}
/*
2332. 坐上公交的最晚时间
https://leetcode.cn/problems/the-latest-time-to-catch-a-bus/

第 82 场双周赛 T2。

给你一个下标从 0 开始长度为 n 的整数数组 buses ，其中 buses[i] 表示第 i 辆公交车的出发时间。
同时给你一个下标从 0 开始长度为 m 的整数数组 passengers ，其中 passengers[j] 表示第 j 位乘客的到达时间。所有公交车出发的时间互不相同，所有乘客到达的时间也互不相同。
给你一个整数 capacity ，表示每辆公交车 最多 能容纳的乘客数目。
每位乘客都会搭乘下一辆有座位的公交车。如果你在 y 时刻到达，公交在 x 时刻出发，满足 y <= x  且公交没有满，那么你可以搭乘这一辆公交。最早 到达的乘客优先上车。
返回你可以搭乘公交车的最晚到达公交站时间。你 不能 跟别的乘客同时刻到达。
注意：数组 buses 和 passengers 不一定是有序的。
提示：
n == buses.length
m == passengers.length
1 <= n, m, capacity <= 10^5
2 <= buses[i], passengers[i] <= 10^9
buses 中的元素 互不相同 。
passengers 中的元素 互不相同 。

比赛时 WA 了 4 发，细节是魔鬼。
贪心。两种情况，要么排在最后（最后一辆车到达时间）/要么插队。
 */