import java.util.Arrays;
import java.util.Comparator;

public class SolutionP1101 {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));
        // 有 N 个人。每个人都有一个从 0 到 N-1 唯一的 id 编号。
        DSU dsu = new DSU(n);
        for (int[] log : logs) {
            dsu.union(log[1], log[2]);
            if (dsu.sz == 1) {
                return log[0];
            }
        }
        return -1;
    }

    static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sz = n;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
            sz--;
        }
    }
}
/*
$1101. 彼此熟识的最早时间
https://leetcode.cn/problems/the-earliest-moment-when-everyone-become-friends/

第 3 场双周赛 T3。

在一个社交圈子当中，有 N 个人。每个人都有一个从 0 到 N-1 唯一的 id 编号。
我们有一份日志列表 logs，其中每条记录都包含一个非负整数的时间戳，以及分属两个人的不同 id，logs[i] = [timestamp, id_A, id_B]。
每条日志标识出两个人成为好友的时间，友谊是相互的：如果 A 和 B 是好友，那么 B 和 A 也是好友。
如果 A 是 B 的好友，或者 A 是 B 的好友的好友，那么就可以认为 A 也与 B 熟识。
返回圈子里所有人之间都熟识的最早时间。如果找不到最早时间，就返回 -1 。
提示：
1 <= N <= 100
1 <= logs.length <= 10^4
0 <= logs[i][0] <= 10^9
0 <= logs[i][1], logs[i][2] <= N - 1
保证 logs[i][0] 中的所有时间戳都不同
Logs 不一定按某一标准排序
logs[i][1] != logs[i][2]

根据提示，需要按时间戳排序 logs，然后基于并查集即可。
 */