import java.util.Arrays;
import java.util.Comparator;

public class Solution2054 {
    public int maxTwoEvents(int[][] events) {
        int[][] sEve = Arrays.copyOf(events, events.length);
        int[][] eEve = Arrays.copyOf(events, events.length);
        Arrays.sort(sEve, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(eEve, Comparator.comparingInt(o -> o[1]));
        int n = sEve.length;
        int j = 0;
        int ans = 0, mx = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && eEve[j][1] < sEve[i][0]) {
                mx = Math.max(mx, eEve[j][2]);
                j += 1;
            }
            ans = Math.max(ans, mx + sEve[i][2]);
        }
        return ans;
    }
}
/*
2054. 两个最好的不重叠活动
https://leetcode.cn/problems/two-best-non-overlapping-events/

第 64 场双周赛 T2。

给你一个下标从 0 开始的二维整数数组 events ，其中 events[i] = [startTimei, endTimei, valuei] 。第 i 个活动开始于 startTimei ，
结束于 endTimei ，如果你参加这个活动，那么你可以得到价值 valuei 。你 最多 可以参加 两个时间不重叠 活动，使得它们的价值之和 最大 。
请你返回价值之和的 最大值 。

扫描线。
相似题目: $253. 会议室 II
https://leetcode.cn/problems/meeting-rooms-ii/
 */