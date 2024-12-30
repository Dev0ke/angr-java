import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP656 {
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        int n = coins.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        // f[i] 表示从位置 i 跳到末尾的最小花费
        long[] f = new long[n];

        for (int i = n - 2; i >= 0; i--) {
            long minCost = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + maxJump && j < n; j++) {
                if (coins[i] != -1) {
                    long cost = coins[i] + f[j];
                    if (minCost > cost) {
                        minCost = cost;
                        next[i] = j;
                    }
                }
            }
            f[i] = minCost;
        }

        List<Integer> resList = new ArrayList<>();
        int i = 0;
        for (; i < n && next[i] != -1; i = next[i]) {
            resList.add(i + 1);
        }
        if (i == n - 1 && coins[i] != -1) {
            resList.add(n);
        } else {
            // 如果无法到达 N 位置，请返回一个空数组
            resList.clear();
        }
        return resList;
    }
}
/*
$656. 金币路径
https://leetcode.cn/problems/coin-path/

给定一个数组 A（下标从 1 开始）包含 N 个整数：A1，A2，……，AN 和一个整数 B。
你可以从数组 A 中的任何一个位置（下标为 i）跳到下标 i+1，i+2，……，i+B 的任意一个可以跳到的位置上。
如果你在下标为 i 的位置上，你需要支付 Ai 个金币。如果 Ai 是 -1，意味着下标为 i 的位置是不可以跳到的。
现在，你希望花费最少的金币从数组 A 的 1 位置跳到 N 位置，你需要输出花费最少的路径，依次输出所有经过的下标（从 1 到 N）。
如果有多种花费最少的方案，输出字典顺序最小的路径。
如果无法到达 N 位置，请返回一个空数组。
注释 :
路径 Pa1，Pa2，……，Pan 是字典序小于 Pb1，Pb2，……，Pbm 的，当且仅当第一个 Pai 和 Pbi 不同的 i 满足 Pai < Pbi，如果不存在这样的 i 那么满足 n < m。
A1 >= 0。 A2, ..., AN （如果存在） 的范围是 [-1, 100]。
A 数组的长度范围 [1, 1000].
B 的范围 [1, 100].

动态规划
 */