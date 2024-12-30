import java.util.List;

public class Solution2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] f = new int[k + 1];

        // 循环每一组
        for (List<Integer> pile : piles) {
            int m = pile.size();
            for (int i = 1; i < m; i++) {
                // 价值为 pile.get(i), 重量为 i+1
                pile.set(i, pile.get(i) + pile.get(i - 1));
            }

            // 循环背包容量
            for (int i = k; i >= 0; i--) {
                for (int j = 0; j < m; j++) {
                    if (i >= j + 1) {
                        f[i] = Math.max(f[i], f[i - (j + 1)] + pile.get(j));
                    }
                }
            }
        }
        return f[k];
    }
}
/*
2218. 从栈中取出 K 个硬币的最大面值和
https://leetcode.cn/problems/maximum-value-of-k-coins-from-piles/

第 286 场周赛 T4。

一张桌子上总共有 n 个硬币 栈 。每个栈有 正整数 个带面值的硬币。
每一次操作中，你可以从任意一个栈的 顶部 取出 1 个硬币，从栈中移除它，并放入你的钱包里。
给你一个列表 piles ，其中 piles[i] 是一个整数数组，分别表示第 i 个栈里 从顶到底 的硬币面值。
同时给你一个正整数 k ，请你返回在 恰好 进行 k 次操作的前提下，你钱包里硬币面值之和 最大为多少 。
提示：
n == piles.length
1 <= n <= 1000
1 <= piles[i][j] <= 10^5
1 <= k <= sum(piles[i].length) <= 2000

利用前缀和 转化为分组背包
时间复杂度 O(ks)
空间复杂度 O(k)
相似题目: 221021天池-04. 意外惊喜
https://leetcode.cn/contest/tianchi2022/problems/tRZfIV/
 */