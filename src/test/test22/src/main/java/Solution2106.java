public class Solution2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        // 这里也可以用二分来找 st，向左走最远可以到达 fruits[st][0]
        int st = n;
        for (int i = 0; i < n; i++) {
            if (fruits[i][0] >= startPos - k) {
                st = i;
                break;
            }
        }

        int l = st, r = st;
        int sum = 0, maxSum = 0;
        while (r < n && fruits[r][0] <= startPos + k) {
            sum += fruits[r][1];
            while (fruits[r][0] * 2 - fruits[l][0] - startPos > k
                    && fruits[r][0] - fruits[l][0] * 2 + startPos > k) {
                sum -= fruits[l][1];
                l++;
            }
            maxSum = Math.max(maxSum, sum);
            r++;
        }
        return maxSum;
    }
}
/*
2106. 摘水果
https://leetcode.cn/problems/maximum-fruits-harvested-after-at-most-k-steps/

第 271 场周赛 T4。

在一个无限的 x 坐标轴上，有许多水果分布在其中某些位置。给你一个二维整数数组 fruits ，其中 fruits[i] = [positioni, amounti]
表示共有 amounti 个水果放置在 positioni 上。fruits 已经按 positioni 升序排列 ，每个 positioni 互不相同 。
另给你两个整数 startPos 和 k 。最初，你位于 startPos 。从任何位置，你可以选择 向左或者向右 走。在 x 轴上每移动 一个单位 ，
就记作 一步 。你总共可以走 最多 k 步。你每达到一个位置，都会摘掉全部的水果，水果也将从该位置消失（不会再生）。
返回你可以摘到水果的 最大总数 。

不定长滑动窗口（求最长/最大）。
时间复杂度 O(n)
 */