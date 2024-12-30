public class Solution2141 {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0L;
        for (int battery : batteries) {
            sum += battery;
        }

        long left = 1;
        long right = sum / n + 1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(n, batteries, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(int n, int[] batteries, long mid) {
        long sum = 0L;
        for (int battery : batteries) {
            sum += Math.min(battery, mid);
        }
        return mid * n <= sum;
    }
}
/*
2141. 同时运行 N 台电脑的最长时间
https://leetcode.cn/problems/maximum-running-time-of-n-computers/

第 276 场周赛 T4。

你有 n 台电脑。给你整数 n 和一个下标从 0 开始的整数数组 batteries ，其中第 i 个电池可以让一台电脑 运行 batteries[i] 分钟。
你想使用这些电池让 全部 n 台电脑 同时 运行。
一开始，你可以给每台电脑连接 至多一个电池 。然后在任意整数时刻，你都可以将一台电脑与它的电池断开连接，并连接另一个电池，
你可以进行这个操作 任意次 。新连接的电池可以是一个全新的电池，也可以是别的电脑用过的电池。断开连接和连接新的电池不会花费任何时间。
注意，你不能给电池充电。
请你返回你可以让 n 台电脑同时运行的 最长 分钟数。
提示：
1 <= n <= batteries.length <= 10^5
1 <= batteries[i] <= 10^9

比赛时看到数据范围考虑使用二分，由 n <= batteries.length 可得出下界为 1，上界为 sum/n. 难点在于如何判断 mid 值是否合法。
假设可以让 n 台电脑同时运行的 最长 分钟数为 x，那么哪怕是最大的电池也只能用 x 分钟，因此每块电池最多用 min(batteries[i], x)
设对其求和值为 sum，则 x * n <= sum
 */
