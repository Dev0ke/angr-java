import java.util.Arrays;

public class Solution1547 {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);

        int[] cuts1 = new int[m + 2];
        for (int i = 1; i <= m; i++) {
            cuts1[i] = cuts[i - 1];
        }
        cuts1[m + 1] = n;

        // f[i][j] 表示 [i,j] 切棍子的 最小总成本
        int[][] f = new int[m + 2][m + 2];
        for (int i = m; i >= 1; i--) {
            for (int j = i; j <= m; j++) {
                f[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k - 1] + f[k + 1][j]);
                }
                f[i][j] += cuts1[j + 1] - cuts1[i - 1];
            }
        }
        return f[1][m];
    }
}
/*
1547. 切棍子的最小成本
https://leetcode.cn/problems/minimum-cost-to-cut-a-stick/

有一根长度为 n 个单位的木棍，棍上从 0 到 n 标记了若干位置。例如，长度为 6 的棍子可以标记如下：
给你一个整数数组 cuts ，其中 cuts[i] 表示你需要将棍子切开的位置。
你可以按顺序完成切割，也可以根据需要更改切割的顺序。
每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和。
对棍子进行切割将会把一根木棍分成两根较小的木棍（这两根木棍的长度和就是切割前木棍的长度）。请参阅第一个示例以获得更直观的解释。
返回切棍子的 最小总成本 。
提示：
2 <= n <= 10^6
1 <= cuts.length <= min(n - 1, 100)
1 <= cuts[i] <= n - 1
cuts 数组中的所有整数都 互不相同

区间 DP
时间复杂度 O(m^3)
空间复杂度 O(m^2)
相似题目: 312. 戳气球
https://leetcode.cn/problems/burst-balloons/
 */