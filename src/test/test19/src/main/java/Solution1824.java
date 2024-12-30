import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution1824 {
    public int minSideJumps(int[] obstacles) {
        int len = obstacles.length;
        Map<Integer, Queue<Integer>> roadIdxQueueMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            // 转化为 0~2
            roadIdxQueueMap.computeIfAbsent(obstacles[i] - 1, key -> new LinkedList<>()).add(i);
        }

        // 第 2 道
        int k = 1;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (obstacles[i] - 1 != k) {
                continue;
            }
            cnt++;

            int k1 = (k + 1) % 3;
            int k2 = (k + 2) % 3;
            Queue<Integer> idxQueue1 = roadIdxQueueMap.getOrDefault(k1, new LinkedList<>());
            while (!idxQueue1.isEmpty() && idxQueue1.peek() < i - 1) {
                idxQueue1.poll();
            }
            Queue<Integer> idxQueue2 = roadIdxQueueMap.getOrDefault(k2, new LinkedList<>());
            while (!idxQueue2.isEmpty() && idxQueue2.peek() < i - 1) {
                idxQueue2.poll();
            }
            if (idxQueue1.isEmpty()) {
                k = k1;
                continue;
            }
            if (idxQueue2.isEmpty()) {
                k = k2;
                continue;
            }
            int dist1 = idxQueue1.peek() - i;
            int dist2 = idxQueue2.peek() - i;
            if (dist1 > 0 && dist1 > dist2) {
                k = k1;
            } else {
                k = k2;
            }
        }
        return cnt;
    }
}
/*
1824. 最少侧跳次数
https://leetcode.cn/problems/minimum-sideway-jumps/

给你一个长度为 n 的 3 跑道道路 ，它总共包含 n + 1 个 点 ，编号为 0 到 n 。一只青蛙从 0 号点第二条跑道 出发 ，它想要跳到点 n 处。然而道路上可能有一些障碍。
给你一个长度为 n + 1 的数组 obstacles ，其中 obstacles[i] （取值范围从 0 到 3）表示在点 i 处的 obstacles[i] 跑道上有一个障碍。
如果 obstacles[i] == 0 ，那么点 i 处没有障碍。任何一个点的三条跑道中 最多有一个 障碍。
- 比方说，如果 obstacles[2] == 1 ，那么说明在点 2 处跑道 1 有障碍。
这只青蛙从点 i 跳到点 i + 1 且跑道不变的前提是点 i + 1 的同一跑道上没有障碍。为了躲避障碍，这只青蛙也可以在 同一个 点处 侧跳 到 另外一条 跑道（这两条跑道可以不相邻），但前提是跳过去的跑道该点处没有障碍。
- 比方说，这只青蛙可以从点 3 处的跑道 3 跳到点 3 处的跑道 1 。
这只青蛙从点 0 处跑道 2 出发，并想到达点 n 处的 任一跑道 ，请你返回 最少侧跳次数 。
注意：点 0 处和点 n 处的任一跑道都不会有障碍。
提示：
obstacles.length == n + 1
1 <= n <= 5 * 10^5
0 <= obstacles[i] <= 3
obstacles[0] == obstacles[n] == 0

贪心。遇到障碍时再跳，跳到距离下一个障碍更远的跑道。
 */