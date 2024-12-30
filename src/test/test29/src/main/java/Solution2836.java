import java.util.List;

public class Solution2836 {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int n = receiver.size();
        int m = 64 - Long.numberOfLeadingZeros(k);

        int[][] pa = new int[n][m];
        long[][] pasum = new long[n][m];
        for (int i = 0; i < n; i++) {
            pa[i][0] = receiver.get(i);
            pasum[i][0] = receiver.get(i);
        }
        for (int i = 0; i + 1 < m; i++) {
            for (int v = 0; v < n; v++) {
                int p = pa[v][i];
                pa[v][i + 1] = pa[p][i];
                pasum[v][i + 1] = pasum[v][i] + pasum[p][i];
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long s = i;
            int v = i;
            for (long j = k; j > 0; j &= j - 1) {
                int ctz = Long.numberOfTrailingZeros(j);
                s += pasum[v][ctz];
                v = pa[v][ctz];
            }
            ans = Math.max(ans, s);
        }
        return ans;
    }
}
/*
2836. 在传球游戏中最大化函数值
https://leetcode.cn/problems/maximize-value-of-function-in-a-ball-passing-game/

第 360 场周赛 T4。

给你一个长度为 n 下标从 0 开始的整数数组 receiver 和一个整数 k 。
总共有 n 名玩家，玩家 编号 互不相同，且为 [0, n - 1] 中的整数。这些玩家玩一个传球游戏，receiver[i] 表示编号为 i 的玩家会传球给编号为 receiver[i] 的玩家。玩家可以传球给自己，也就是说 receiver[i] 可能等于 i 。
你需要从 n 名玩家中选择一名玩家作为游戏开始时唯一手中有球的玩家，球会被传 恰好 k 次。
如果选择编号为 x 的玩家作为开始玩家，定义函数 f(x) 表示从编号为 x 的玩家开始，k 次传球内所有接触过球玩家的编号之 和 ，如果有玩家多次触球，则 累加多次 。换句话说， f(x) = x + receiver[x] + receiver[receiver[x]] + ... + receiver(k)[x] 。
你的任务时选择开始玩家 x ，目的是 最大化 f(x) 。
请你返回函数的 最大值 。
注意：receiver 可能含有重复元素。
提示：
1 <= receiver.length == n <= 10^5
0 <= receiver[i] <= n - 1
1 <= k <= 10^10

树上倍增
时间复杂度 O(nlogk) 其中 n = receiver.size()
空间复杂度 O(nlogk)
内向基环树 可以做到 O(n)？
 */