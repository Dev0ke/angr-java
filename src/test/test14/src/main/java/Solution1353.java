import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1353 {
    public int maxEvents(int[][] events) {
        int len = events.length;

        int endMax = 0;
        Map<Integer, List<Integer>> startIdxListMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int start = events[i][0];
            int end = events[i][1];
            startIdxListMap.computeIfAbsent(start, key -> new ArrayList<>()).add(i);
            endMax = Math.max(endMax, end);
        }

        // [endi, i]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        int res = 0;
        for (int day = 1; day <= endMax; day++) {
            // 加入当天开始的会议
            List<Integer> startIdxList = startIdxListMap.getOrDefault(day, new ArrayList<>());
            for (int idx : startIdxList) {
                minHeap.add(new int[]{events[idx][1], idx});
            }

            // 移除当天已结束的会议
            while (!minHeap.isEmpty() && minHeap.peek()[0] < day) {
                minHeap.remove();
            }

            if (!minHeap.isEmpty()) {
                minHeap.remove();
                res++;
            }
        }
        return res;
    }
}
/*
1353. 最多可以参加的会议数目
https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended/

给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
请你返回你可以参加的 最大 会议数目。
提示：
1 <= events.length <= 10^5
events[i].length == 2
1 <= startDayi <= endDayi <= 10^5

贪心。优先队列
如果一天中有 n 个会议可供选择，那么取最早结束的。
每天将可以开始的会议添加进优先队列，同时移除所有已结束会议，再取出最高结束的一个会议即可。
 */