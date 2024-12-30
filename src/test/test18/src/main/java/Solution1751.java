import java.util.Arrays;
import java.util.Comparator;

public class Solution1751 {
    public int maxValue(int[][] events, int k) {
        int len = events.length;

        Arrays.sort(events, Comparator.comparingInt(o -> o[1]));

        int[][] f = new int[len + 1][k + 1];
        for (int i = 1; i <= len; i++) {
            int[] event = events[i - 1];

//            int last = 0;
//            for (int j = i - 1; j - 1 >= 0; j--) {
//                int[] ej = events[j - 1];
//
//                if (ej[1] < ei[0]) {
//                    last = j;
//                    break;
//                }
//            }
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (events[mid][1] >= event[0]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int last = left;

            for (int j = 1; j <= k; j++) {
                // 选 or 不选
                f[i][j] = Math.max(f[i - 1][j], f[last][j - 1] + event[2]);
            }
        }
        return f[len][k];
    }
}
/*
1751. 最多可以参加的会议数目 II
https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended-ii/

给你一个 events 数组，其中 events[i] = [startDayi, endDayi, valuei] ，表示第 i 个会议在 startDayi 天开始，第 endDayi 天结束，
如果你参加这个会议，你能得到价值 valuei 。同时给你一个整数 k 表示你能参加的最多会议数目。
你同一时间只能参加一个会议。如果你选择参加某个会议，那么你必须 完整 地参加完这个会议。
会议结束日期是包含在会议内的，也就是说你不能同时参加一个开始日期与另一个结束日期相同的两个会议。
请你返回能得到的会议价值 最大和 。
提示：
1 <= k <= events.length
1 <= k * events.length <= 10^6
1 <= startDayi <= endDayi <= 10^9
1 <= valuei <= 10^6

动态规划
时间复杂度 O(n*(n+k+logn)) 其中找 last 的部分可用二分优化至 O(n*(k+logn))
空间复杂度 O(nk)
相似题目: 1235. 规划兼职工作
https://leetcode.cn/problems/maximum-profit-in-job-scheduling/
2008. 出租车的最大盈利
https://leetcode.cn/problems/maximum-earnings-from-taxi/
 */