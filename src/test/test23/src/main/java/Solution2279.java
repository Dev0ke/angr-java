import java.util.Arrays;

public class Solution2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;

        // 预处理
        int[] remain = new int[n];
        for (int i = 0; i < n; i++) {
            remain[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remain);

        // 前缀和
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + remain[i];
        }

        int left = 1;
        int right = n + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (ps[mid] - ps[0] > additionalRocks) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
/*
2279. 装满石头的背包的最大数量
https://leetcode.cn/problems/maximum-bags-with-full-capacity-of-rocks/

第 294 场周赛 T2。

现有编号从 0 到 n - 1 的 n 个背包。给你两个下标从 0 开始的整数数组 capacity 和 rocks 。第 i 个背包最大可以装 capacity[i] 块石头，
当前已经装了 rocks[i] 块石头。另给你一个整数 additionalRocks ，表示你可以放置的额外石头数量，石头可以往 任意 背包中放置。
请你将额外的石头放入一些背包中，并返回放置后装满石头的背包的 最大 数量。
提示：
n == capacity.length == rocks.length
1 <= n <= 5 * 10^4
1 <= capacity[i] <= 10^9
0 <= rocks[i] <= capacity[i]
1 <= additionalRocks <= 10^9

前缀和+二分
 */