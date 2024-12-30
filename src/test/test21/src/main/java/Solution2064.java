public class Solution2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(n, quantities, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int n, int[] quantities, int mid) {
        int cnt = 0;
        for (int quantity : quantities) {
            cnt += Math.ceil(quantity / (double) mid);
        }
        return cnt <= n;
    }
}
/*
2064. 分配给商店的最多商品的最小值
https://leetcode.cn/problems/minimized-maximum-of-products-distributed-to-any-store/

第 266 场周赛 T3。

给你一个整数 n ，表示有 n 间零售商店。总共有 m 种产品，每种产品的数目用一个下标从 0 开始的整数数组 quantities 表示，
其中 quantities[i] 表示第 i 种商品的数目。
你需要将 所有商品 分配到零售商店，并遵守这些规则：
- 一间商店 至多 只能有 一种商品 ，但一间商店拥有的商品数目可以为 任意 件。
- 分配后，每间商店都会被分配一定数目的商品（可能为 0 件）。用 x 表示所有商店中分配商品数目的最大值，你希望 x 越小越好。
也就是说，你想 最小化 分配给任意商店商品数目的 最大值 。
请你返回最小的可能的 x 。
提示：
m == quantities.length
1 <= m <= n <= 10^5
1 <= quantities[i] <= 10^5

二分
 */