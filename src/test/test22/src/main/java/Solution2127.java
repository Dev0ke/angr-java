import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution2127 {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        // 统计入度，便于进行拓扑排序
        int[] inDeg = new int[n];
        for (int fav : favorite) {
            inDeg[fav]++;
        }

        boolean[] used = new boolean[n];
        // dp[i] 表示到节点 i 为止的最长「游走」路径经过的节点个数
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // 入度为 0 进队列
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.remove();
            used[x] = true;
            int y = favorite[x];
            // 状态转移
            dp[y] = Math.max(dp[y], dp[x] + 1);
            inDeg[y]--;
            if (inDeg[y] == 0) {
                queue.add(y);
            }
        }

        // ring 表示最大的环的大小
        // total 表示所有环大小为 2 的「基环内向树」上的最长的「双向游走」路径之和
        int ring = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                int j = favorite[i];
                // favorite[favorite[i]] = i 说明环的大小为 2
                if (favorite[j] == i) {
                    total += dp[i] + dp[j];
                    used[i] = used[j] = true;
                }
                // 否则环的大小至少为 3，我们需要找出环
                else {
                    int cnt = 1;
                    for (int u = favorite[i]; u != i; u = favorite[u]) {
                        used[u] = true;
                        cnt++;
                    }
                    ring = Math.max(ring, cnt);
                }
            }
        }
        return Math.max(ring, total);
    }
}
/*
2127. 参加会议的最多员工数
https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/

第 274 场周赛 T4。

一个公司准备组织一场会议，邀请名单上有 n 位员工。公司准备了一张 圆形 的桌子，可以坐下 任意数目 的员工。
员工编号为 0 到 n - 1 。每位员工都有一位 喜欢 的员工，每位员工 当且仅当 他被安排在喜欢员工的旁边，他才会参加会议。
每位员工喜欢的员工 不会 是他自己。
给你一个下标从 0 开始的整数数组 favorite ，其中 favorite[i] 表示第 i 位员工喜欢的员工。请你返回参加会议的 最多员工数目 。
提示：
n == favorite.length
2 <= n <= 10^5
0 <= favorite[i] <= n - 1
favorite[i] != i

内向基环树
拓扑排序 + 动态规划
时间复杂度 O(n)
空间复杂度 O(n)
官方题解: https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/solution/can-jia-hui-yi-de-zui-duo-yuan-gong-shu-u8e8u/
 */