import java.util.Arrays;
import java.util.Comparator;

public class Solution2747 {
    private static final int MAX_N = (int) (1e5 + 5);

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, Comparator.comparingInt(o -> o[1]));

        // 哈希表改数组
        int[] cnt = new int[MAX_N];
        int sz = 0;

        int q = queries.length;
        // 离线算法
        Integer[] ids = new Integer[q];
        for (int i = 0; i < q; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> queries[o]));

        // 双指针
        int[] ans = new int[q];
        int l = 0, r = 0;
        for (Integer id : ids) {
            int ql = queries[id] - x, qr = queries[id];
            while (r < logs.length && logs[r][1] <= qr) {
                int serverId = logs[r][0];
                cnt[serverId]++;
                if (cnt[serverId] == 1) sz++;
                r++;
            }
            while (l < logs.length && logs[l][1] < ql) {
                int serverId = logs[l][0];
                if (cnt[serverId] == 1) sz--;
                cnt[serverId]--;
                l++;
            }
            ans[id] = n - sz;
        }
        return ans;
    }
}
/*
2747. 统计没有收到请求的服务器数目
https://leetcode.cn/problems/count-zero-request-servers/

第 107 场双周赛 T4。

给你一个整数 n ，表示服务器的总数目，再给你一个下标从 0 开始的 二维 整数数组 logs ，其中 logs[i] = [server_id, time] 表示 id 为 server_id 的服务器在 time 时收到了一个请求。
同时给你一个整数 x 和一个下标从 0 开始的整数数组 queries  。
请你返回一个长度等于 queries.length 的数组 arr ，其中 arr[i] 表示在时间区间 [queries[i] - x, queries[i]] 内没有收到请求的服务器数目。
注意时间区间是个闭区间。
提示：
1 <= n <= 10^5
1 <= logs.length <= 10^5
1 <= queries.length <= 10^5
logs[i].length == 2
1 <= logs[i][0] <= n
1 <= logs[i][1] <= 10^6
1 <= x <= 10^5
x < queries[i] <= 10^6

离线优化 + 滑动窗口
同是滑窗，1e5 能 AC，1e6 TLE。。
 */