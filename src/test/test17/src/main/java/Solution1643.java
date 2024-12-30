public class Solution1643 {
    public String kthSmallestPath(int[] destination, int k) {
        int h = destination[1];
        int v = destination[0];

        // 预处理组合数
        int[][] comb = new int[h + v][h];
        comb[0][0] = 1;
        for (int i = 1; i < h + v; ++i) {
            comb[i][0] = 1;
            for (int j = 1; j <= i && j < h; ++j) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0, imax = h + v; i < imax; ++i) {
            if (h > 0) {
                int o = comb[h + v - 1][h - 1];
                if (k > o) {
                    ans.append("V");
                    --v;
                    k -= o;
                } else {
                    ans.append("H");
                    --h;
                }
            } else {
                ans.append("V");
                --v;
            }
        }
        return ans.toString();
    }
}
/*
1643. 第 K 条最小指令
https://leetcode.cn/problems/kth-smallest-instructions/description/

Bob 站在单元格 (0, 0) ，想要前往目的地 destination ：(row, column) 。他只能向 右 或向 下 走。你可以为 Bob 提供导航 指令 来帮助他到达目的地 destination 。
指令 用字符串表示，其中每个字符：
- 'H' ，意味着水平向右移动
- 'V' ，意味着竖直向下移动
能够为 Bob 导航到目的地 destination 的指令可以有多种，例如，如果目的地 destination 是 (2, 3)，"HHHVV" 和 "HVHVH" 都是有效 指令 。
然而，Bob 很挑剔。因为他的幸运数字是 k，他想要遵循 按字典序排列后的第 k 条最小指令 的导航前往目的地 destination 。k  的编号 从 1 开始 。
给你一个整数数组 destination 和一个整数 k ，请你返回可以为 Bob 提供前往目的地 destination 导航的 按字典序排列后的第 k 条最小指令 。
提示：
destination.length == 2
1 <= row, column <= 15
1 <= k <= nCr(row + column, row)，其中 nCr(a, b) 表示组合数，即从 a 个物品中选 b 个物品的不同方案数。

优先确定高位 + 组合计数。
https://leetcode.cn/problems/kth-smallest-instructions/solutions/468791/di-k-tiao-zui-xiao-zhi-ling-by-zerotrac2/
时间复杂度 O((h+v)*h)。
 */