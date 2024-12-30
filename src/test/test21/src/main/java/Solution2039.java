import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution2039 {
    // https://leetcode.cn/problems/the-time-when-the-network-becomes-idle/submissions/496899469
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            int x = p[0], y = p[1];
            g[x].add(y);
            g[y].add(x);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        queue.add(0);
        vis[0] = true;

        int ans = 0;
        int dist = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int x = queue.remove();
                for (Integer y : g[x]) {
                    if (!vis[y]) {
                        vis[y] = true;
                        int time = (dist * 2 - 1) / patience[y] * patience[y] + (dist * 2 + 1);
                        ans = Math.max(ans, time);
                        queue.add(y);
                    }
                }
            }
            dist++;
        }
        return ans;
    }
}
/*
2039. 网络空闲的时刻
https://leetcode.cn/problems/the-time-when-the-network-becomes-idle/description/

第 63 场双周赛 T3。

给你一个有 n 个服务器的计算机网络，服务器编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示服务器 ui 和 vi 之间有一条信息线路，在 一秒 内它们之间可以传输 任意 数目的信息。再给你一个长度为 n 且下标从 0 开始的整数数组 patience 。
题目保证所有服务器都是 相通 的，也就是说一个信息从任意服务器出发，都可以通过这些信息线路直接或间接地到达任何其他服务器。
编号为 0 的服务器是 主 服务器，其他服务器为 数据 服务器。每个数据服务器都要向主服务器发送信息，并等待回复。信息在服务器之间按 最优 线路传输，也就是说每个信息都会以 最少时间 到达主服务器。主服务器会处理 所有 新到达的信息并 立即 按照每条信息来时的路线 反方向 发送回复信息。
在 0 秒的开始，所有数据服务器都会发送各自需要处理的信息。从第 1 秒开始，每 一秒最 开始 时，每个数据服务器都会检查它是否收到了主服务器的回复信息（包括新发出信息的回复信息）：
- 如果还没收到任何回复信息，那么该服务器会周期性 重发 信息。数据服务器 i 每 patience[i] 秒都会重发一条信息，也就是说，数据服务器 i 在上一次发送信息给主服务器后的 patience[i] 秒 后 会重发一条信息给主服务器。
- 否则，该数据服务器 不会重发 信息。
当没有任何信息在线路上传输或者到达某服务器时，该计算机网络变为 空闲 状态。
请返回计算机网络变为 空闲 状态的 最早秒数 。
提示：
n == patience.length
2 <= n <= 10^5
patience[0] == 0
对于 1 <= i < n ，满足 1 <= patience[i] <= 10^5
1 <= edges.length <= min(105, n * (n - 1) / 2)
edges[i].length == 2
0 <= ui, vi < n
ui != vi
不会有重边。
每个服务器都直接或间接与别的服务器相连。

BFS。
时间复杂度 O(n + m)
 */