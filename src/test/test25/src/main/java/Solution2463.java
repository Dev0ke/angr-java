import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution2463 {
    private static final long INF = Long.MAX_VALUE / 2;
    private List<Integer> robot;
    private int[][] factory;
    private int n;
    private int m;
    private long[][] memo;

    // 记忆化搜索
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(o -> o[0]));
        this.robot = robot;
        this.factory = factory;
        n = factory.length;
        m = robot.size();

        memo = new long[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(0, 0);
    }

    // 原问题：n 个工厂修理 m 个机器人
    // 子问题：枚举第一个工厂修了 x 个机器人，余下 n-1 个工厂修理 m-x 个机器人
    // f(i,j) 表示用 [i,n-1] 工厂修理 [j,m-1] 机器人
    private long f(int i, int j) {
        if (j == m) {
            // 都修完了
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (i == n - 1) {
            // 修理剩余的机器人
            if (m - j > factory[i][1]) {
                // 不合法
                return INF;
            }
            long sum = 0L;
            for (int k = j; k < m; k++) {
                sum += Math.abs(robot.get(k) - factory[i][0]);
            }
            memo[i][j] = sum;
            return sum;
        }

        // 一个都不修
        long res = f(i + 1, j);
        long sum = 0L;
        // 修的机器人个数
        for (int k = 1; k <= factory[i][1] && j + k - 1 < m; k++) {
            sum += Math.abs(robot.get(j + k - 1) - factory[i][0]);
            res = Math.min(res, sum + f(i + 1, j + k));
        }
        memo[i][j] = res;
        return res;
    }

    // 动态规划（递推）
    public long minimumTotalDistance2(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(o -> o[0]));
        this.robot = robot;
        this.factory = factory;
        n = factory.length;
        m = robot.size();

        // dp[i][j] 表示前 i 个工厂，修理前 j 个机器人，移动的最小总距离
        // 一个都不修：dp[i-1][j]
        //          dp[i-1][j-k]+cost(i,j,k)
        // cost(i,j,k) 表示第 i 个工厂，修理从 j 往前的 k 个机器人，移动距离之和
        long[][] dp = new long[n + 1][m + 1];
        // 初始状态
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0L;
        }

        for (int i = 1; i <= n; i++) {
            int[] fact = factory[i - 1];
            for (int j = 1; j <= m; j++) {
                long cost = 0L;
                // 一个都不修
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                for (int k = 1; k <= j && k <= fact[1]; k++) {
                    cost += Math.abs(robot.get(j - k) - fact[0]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k] + cost);
                }
            }
        }
        return dp[n][m];
    }

    // 动态规划（递推）压缩到一维
    public long minimumTotalDistance3(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(o -> o[0]));
        this.robot = robot;
        this.factory = factory;
        n = factory.length;
        m = robot.size();

        long[] f = new long[m + 1];
        Arrays.fill(f, INF);
        f[0] = 0L;

        for (int[] fact : factory) {
            for (int j = m; j >= 1; j--) {
                long cost = 0L;
                for (int k = 1; k <= j && k <= fact[1]; k++) {
                    cost += Math.abs(robot.get(j - k) - fact[0]);
                    f[j] = Math.min(f[j], f[j - k] + cost);
                }
            }
        }
        return f[m];
    }
}
/*
2463. 最小移动总距离
https://leetcode.cn/problems/minimum-total-distance-traveled/

第 318 场周赛 T4。

X 轴上有一些机器人和工厂。给你一个整数数组 robot ，其中 robot[i] 是第 i 个机器人的位置。再给你一个二维整数数组 factory ，其中 factory[j] = [positionj, limitj] ，表示第 j 个工厂的位置在 positionj ，且第 j 个工厂最多可以修理 limitj 个机器人。
每个机器人所在的位置 互不相同 。每个工厂所在的位置也 互不相同 。注意一个机器人可能一开始跟一个工厂在 相同的位置 。
所有机器人一开始都是坏的，他们会沿着设定的方向一直移动。设定的方向要么是 X 轴的正方向，要么是 X 轴的负方向。当一个机器人经过一个没达到上限的工厂时，这个工厂会维修这个机器人，且机器人停止移动。
任何时刻，你都可以设置 部分 机器人的移动方向。你的目标是最小化所有机器人总的移动距离。
请你返回所有机器人移动的最小总距离。测试数据保证所有机器人都可以被维修。
注意：
- 所有机器人移动速度相同。
- 如果两个机器人移动方向相同，它们永远不会碰撞。
- 如果两个机器人迎面相遇，它们也不会碰撞，它们彼此之间会擦肩而过。
- 如果一个机器人经过了一个已经达到上限的工厂，机器人会当作工厂不存在，继续移动。
- 机器人从位置 x 到位置 y 的移动距离为 |y - x| 。
提示：
1 <= robot.length, factory.length <= 100
factory[j].length == 2
-10^9 <= robot[i], positionj <= 10^9
0 <= limitj <= robot.length
测试数据保证所有机器人都可以被维修。

划分型 DP。设有工厂 n 个，机器人 m 个。
关键结论（邻项交换法证明）：存在最优方案，机器人 i 被送去 ti，ti 是非单调递减的（相当于二分图的连线是不会交叉的）。
相似题目: 2449. 使数组相似的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-make-arrays-similar/
1478. 安排邮筒
https://leetcode.cn/problems/allocate-mailboxes/
 */