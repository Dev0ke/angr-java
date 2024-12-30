import java.util.Arrays;

public class SolutionP351 {
    private boolean[] used;

    public int numberOfPatterns(int m, int n) {
        used = new boolean[9];

        int ans = 0;
        for (int i = m; i <= n; i++) {
            ans += dfs(i, -1);
            Arrays.fill(used, false);
        }
        return ans;
    }

    private boolean isValid(int from, int to) {
        if (from == -1) return true;
        if (from > to) return isValid(to, from);
        // 水平
        if (from == 0 && to == 2) return used[1];
        if (from == 3 && to == 5) return used[4];
        if (from == 6 && to == 8) return used[7];
        // 垂直
        if (from == 0 && to == 6) return used[3];
        if (from == 1 && to == 7) return used[4];
        if (from == 2 && to == 8) return used[5];
        // 对角线
        if (from == 0 && to == 8) return used[4];
        if (from == 2 && to == 6) return used[4];
        return true;
    }

    // pre: 上一个访问的数字
    private int dfs(int step, int pre) {
        if (step == 0) return 1;
        int sum = 0;
        for (int to = 0; to < 9; to++) {
            if (!used[to] && isValid(pre, to)) {
                used[to] = true;
                sum += dfs(step - 1, to);
                used[to] = false;
            }
        }
        return sum;
    }
}
/*
$351. 安卓系统手势解锁
https://leetcode.cn/problems/android-unlock-patterns/

我们都知道安卓有个手势解锁的界面，是一个 3 x 3 的点所绘制出来的网格。用户可以设置一个 “解锁模式” ，通过连接特定序列中的点，形成一系列彼此连接的线段，每个线段的端点都是序列中两个连续的点。如果满足以下两个条件，则 k 点序列是有效的解锁模式：
- 解锁模式中的所有点 互不相同 。
- 假如模式中两个连续点的线段需要经过其他点的 中心 ，那么要经过的点 必须提前出现 在序列中（已经经过），不能跨过任何还未被经过的点。
  - 例如，点 5 或 6 没有提前出现的情况下连接点 2 和 9 是有效的，因为从点 2 到点 9 的线没有穿过点 5 或 6 的中心。
  - 然而，点 2 没有提前出现的情况下连接点 1 和 3 是无效的，因为从圆点 1 到圆点 3 的直线穿过圆点 2 的中心。
以下是一些有效和无效解锁模式的示例：
- 无效手势：[4,1,3,6] ，连接点 1 和点 3 时经过了未被连接过的 2 号点。
- 无效手势：[4,1,9,2] ，连接点 1 和点 9 时经过了未被连接过的 5 号点。
- 有效手势：[2,4,1,3,6] ，连接点 1 和点 3 是有效的，因为虽然它经过了点 2 ，但是点 2 在该手势中之前已经被连过了。
- 有效手势：[6,5,4,1,9,2] ，连接点 1 和点 9 是有效的，因为虽然它经过了按键 5 ，但是点 5 在该手势中之前已经被连过了。
给你两个整数，分别为 m 和 n ，那么请返回有多少种 不同且有效的解锁模式 ，是 至少 需要经过 m 个点，但是 不超过 n 个点的。
两个解锁模式 不同 需满足：经过的点不同或者经过点的顺序不同。
提示：
1 <= m, n <= 9

回溯
时间复杂度 O(n!)
 */