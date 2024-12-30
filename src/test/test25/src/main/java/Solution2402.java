import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2402 {
    public int mostBooked(int n, int[][] meetings) {
        int[] cnt = new int[n];

        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        // 空闲会议室编号
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            free.add(i);
        }
        // 使用中会议室 [结束时间, 编号]
        PriorityQueue<Node> busy = new PriorityQueue<>((o1, o2) -> {
            if (o1.end == o2.end) {
                return Integer.compare(o1.idx, o2.idx);
            }
            return Long.compare(o1.end, o2.end);
        });

        for (int[] meeting : meetings) {
            // 当会议室处于未占用状态时，将会优先提供给原 开始 时间更早的会议。
            while (!busy.isEmpty() && busy.peek().end <= meeting[0]) {
                free.add(busy.remove().idx);
            }

            long end;
            int idx;
            if (free.isEmpty()) {
                // 如果没有可用的会议室，会议将会延期，直到存在空闲的会议室。延期会议的持续时间和原会议持续时间 相同 。
                Node node = busy.remove();
                end = node.end + meeting[1] - meeting[0];
                idx = node.idx;
            } else {
                // 每场会议都会在未占用且编号 最小 的会议室举办。
                end = meeting[1];
                idx = free.remove();
            }
            cnt[idx]++;
            busy.add(new Node(end, idx));
        }

        // 返回举办最多次会议的房间 编号 。如果存在多个房间满足此条件，则返回编号 最小 的房间。
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[i] > cnt[res]) {
                res = i;
            }
        }
        return res;
    }

    private static class Node {
        long end;
        int idx;

        public Node(long end, int idx) {
            this.end = end;
            this.idx = idx;
        }
    }
}
/*
2402. 会议室 III
https://leetcode.cn/problems/meeting-rooms-iii/

第 309 场周赛 T4。

给你一个整数 n ，共有编号从 0 到 n - 1 的 n 个会议室。
给你一个二维整数数组 meetings ，其中 meetings[i] = [starti, endi] 表示一场会议将会在 半闭 时间区间 [starti, endi) 举办。所有 starti 的值 互不相同 。
会议将会按以下方式分配给会议室：
1.每场会议都会在未占用且编号 最小 的会议室举办。
2.如果没有可用的会议室，会议将会延期，直到存在空闲的会议室。延期会议的持续时间和原会议持续时间 相同 。
3.当会议室处于未占用状态时，将会优先提供给原 开始 时间更早的会议。
返回举办最多次会议的房间 编号 。如果存在多个房间满足此条件，则返回编号 最小 的房间。
半闭区间 [a, b) 是 a 和 b 之间的区间，包括 a 但 不包括 b 。
提示：
1 <= n <= 100
1 <= meetings.length <= 10^5
meetings[i].length == 2
0 <= starti < endi <= 5 * 10^5
starti 的所有值 互不相同

双堆模拟
时间复杂度 O(n + m(logn + logm)) 其中 m = meetings.length
空间复杂度 O(n)
相似题目: 1606. 找到处理最多请求的服务器
https://leetcode.cn/problems/find-servers-that-handled-most-number-of-requests/
1882. 使用服务器处理任务
https://leetcode.cn/problems/process-tasks-using-servers/
 */