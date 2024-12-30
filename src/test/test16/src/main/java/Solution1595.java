import java.util.Arrays;
import java.util.List;

public class Solution1595 {
    private List<List<Integer>> cost;
    private int size1, size2;
    private int[] minCost;
    private int[][] memo;

    public int connectTwoGroups(List<List<Integer>> cost) {
        this.cost = cost;
        size1 = cost.size();
        size2 = cost.get(0).size();
        minCost = new int[size2];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                minCost[j] = Math.min(minCost[j], cost.get(i).get(j));
            }
        }
        memo = new int[size1][1 << size2];
        for (int i = 0; i < size1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0);
    }

    // 第一组前 i 个数，第二组连接状态为 mask
    private int dfs(int i, int mask) {
        if (i == size1) {
            int res = 0;
            for (int k = 0; k < size2; k++) {
                if ((mask >> k & 1) == 0) {
                    res += minCost[k];
                }
            }
            return res;
        }
        if (memo[i][mask] != -1) {
            return memo[i][mask];
        }
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < size2; k++) {
            res = Math.min(res, dfs(i + 1, mask | (1 << k)) + cost.get(i).get(k));
        }
        return memo[i][mask] = res;
    }
}
/*
1595. 连通两组点的最小成本
https://leetcode.cn/problems/minimum-cost-to-connect-two-groups-of-points/

给你两组点，其中第一组中有 size1 个点，第二组中有 size2 个点，且 size1 >= size2 。
任意两点间的连接成本 cost 由大小为 size1 x size2 矩阵给出，其中 cost[i][j] 是第一组中的点 i 和第二组中的点 j 的连接成本。如果两个组中的每个点都与另一组中的一个或多个点连接，则称这两组点是连通的。换言之，第一组中的每个点必须至少与第二组中的一个点连接，且第二组中的每个点必须至少与第一组中的一个点连接。
返回连通两组点所需的最小成本。
提示：
size1 == cost.length
size2 == cost[i].length
1 <= size1, size2 <= 12
size1 >= size2
0 <= cost[i][j] <= 100

状态压缩动态规划 / 动态规划
预处理，先左侧全匹配，再后侧补漏
时间复杂度 O(nm * 2^m)
空间复杂度 O(n * 2^m)
 */