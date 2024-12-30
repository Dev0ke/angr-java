public class Solution2555 {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;

        // f[i] 表示 [0, i) 线段长度 <= k 的最多奖品数
        int[] f = new int[n + 1];

        int l = 0, r = 0;
        int res = 0;
        while (r < n) {
            while (prizePositions[r] - prizePositions[l] > k) {
                l++;
            }
            res = Math.max(res, (r - l + 1) + f[l]);
            f[r + 1] = Math.max(f[r], r - l + 1);
            r++;
        }
        return res;
    }
}
/*
2555. 两个线段获得的最多奖品
https://leetcode.cn/problems/maximize-win-from-two-segments/

第 97 场双周赛 T3。

在 X轴 上有一些奖品。给你一个整数数组 prizePositions ，它按照 非递减 顺序排列，其中 prizePositions[i] 是第 i 件奖品的位置。
数轴上一个位置可能会有多件奖品。再给你一个整数 k 。
你可以选择两个端点为整数的线段。每个线段的长度都必须是 k 。你可以获得位置在任一线段上的所有奖品（包括线段的两个端点）。注意，两个线段可能会有相交。
- 比方说 k = 2 ，你可以选择线段 [1, 3] 和 [2, 4] ，你可以获得满足 1 <= prizePositions[i] <= 3 或者 2 <= prizePositions[i] <= 4 的所有奖品 i 。
请你返回在选择两个最优线段的前提下，可以获得的 最多 奖品数目。
提示：
1 <= prizePositions.length <= 10^5
1 <= prizePositions[i] <= 10^9
0 <= k <= 10^9
prizePositions 有序非递减。

双指针/滑动窗口
时间复杂度 O(n)
相似题目: 1477. 找两个和为目标值且不重叠的子数组
https://leetcode.cn/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 */