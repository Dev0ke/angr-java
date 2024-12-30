public class Solution2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int res = 0;
        for (int i = 0; i < numOnes && k > 0; i++) {
            k--;
            res++;
        }
        for (int i = 0; i < numZeros && k > 0; i++) {
            k--;
        }
        for (int i = 0; i < numNegOnes && k > 0; i++) {
            k--;
            res--;
        }
        return res;
    }
}
/*
2600. K 件物品的最大和
https://leetcode.cn/problems/k-items-with-the-maximum-sum/

第 338 场周赛 T1。

袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。
给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。
袋子最初包含：
- numOnes 件标记为 1 的物品。
- numZeroes 件标记为 0 的物品。
- numNegOnes 件标记为 -1 的物品。
现计划从这些物品中恰好选出 k 件物品。返回所有可行方案中，物品上所标记数字之和的最大值。
提示：
0 <= numOnes, numZeros, numNegOnes <= 50
0 <= k <= numOnes + numZeros + numNegOnes

模拟。
 */