import java.util.Arrays;
import java.util.Comparator;

public class Solution1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;

        int[][] events = new int[len][3];
        for (int i = 0; i < len; i++) {
            events[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(events, Comparator.comparingInt(o -> o[1]));

        // solution 1751
        int[] f = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            int[] event = events[i - 1];

//            int last = 0;
//            for (int j = i - 1; j - 1 >= 0; j--) {
//                int[] ej = events[j - 1];
//
//                if (ej[1] <= ei[0]) {
//                    last = j;
//                    break;
//                }
//            }
            // 二分优化
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (events[mid][1] > event[0]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int last = left;

            // 选 or 不选
            f[i] = Math.max(f[i - 1], f[last] + event[2]);
        }
        return f[len];
    }
}
/*
1235. 规划兼职工作
https://leetcode.cn/problems/maximum-profit-in-job-scheduling/

你打算利用空闲时间来做兼职工作赚些零花钱。
这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
注意，时间上出现重叠的 2 份工作不能同时进行。
如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
提示：
1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
1 <= startTime[i] < endTime[i] <= 10^9
1 <= profit[i] <= 10^4

动态规划。
时间复杂度 O(nlogn) 其中找 last 的部分可用二分优化到 O(logn)
相似题目: 1751. 最多可以参加的会议数目 II
https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended-ii/
2008. 出租车的最大盈利
https://leetcode.cn/problems/maximum-earnings-from-taxi/
 */