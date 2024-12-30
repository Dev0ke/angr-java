import java.util.ArrayList;
import java.util.List;

public class Solution3086 {
    public long minimumMoves(int[] nums, int k, int maxChanges) {
        int n = nums.length;
        int c = 0;
        List<Integer> oneIds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != 1) continue;
            oneIds.add(i);
            c = Math.max(c, 1);
            if (i - 1 >= 0 && nums[i - 1] == 1) {
                if (i - 2 >= 0 && nums[i - 2] == 1) {
                    c = 3;
                } else {
                    c = Math.max(c, 2);
                }
            }
        }

        c = Math.min(c, k);
        // 其余 k-c 个 1 可以全部用两次操作得到
        if (maxChanges >= k - c) {
            return Math.max(0, c - 1) + (k - c) * 2L;
        }

        int sz = oneIds.size();
        long[] ps = new long[sz + 1];
        for (int i = 0; i < sz; i++) {
            ps[i + 1] = ps[i] + oneIds.get(i);
        }

        long minCost = Long.MAX_VALUE;
        // 窗口大小
        int L = k - maxChanges;
        for (int i = 0; i + L <= sz; i++) {
            int l = i;
            int r = i + L - 1;

            int m = (l + r) / 2;
            int median = oneIds.get(m);
            // [l, m-1] [m, r]
            long l_sum = ps[m] - ps[l];
            long l_len = m - 1 - l + 1;
            long r_sum = ps[r + 1] - ps[m];
            long r_len = r - m + 1;
            long cost = r_sum - r_len * median + l_len * median - l_sum;
            minCost = Math.min(minCost, cost);
        }
        return minCost + maxChanges * 2L;
    }
}
/*
3086. 拾起 K 个 1 需要的最少行动次数
https://leetcode.cn/problems/minimum-moves-to-pick-k-ones/description/

第 389 场周赛 T4。

给你一个下标从 0 开始的二进制数组 nums，其长度为 n ；另给你一个 正整数 k 以及一个 非负整数 maxChanges 。
灵茶山艾府在玩一个游戏，游戏的目标是让灵茶山艾府使用 最少 数量的 行动 次数从 nums 中拾起 k 个 1 。游戏开始时，灵茶山艾府可以选择数组 [0, n - 1] 范围内的任何索引index 站立。如果 nums[index] == 1 ，灵茶山艾府就会拾起一个 1 ，并且 nums[index] 变成0（这 不算 作一次行动）。之后，灵茶山艾府可以执行 任意数量 的 行动（包括零次），在每次行动中灵茶山艾府必须 恰好 执行以下动作之一：
- 选择任意一个下标 j != index 且满足 nums[j] == 0 ，然后将 nums[j] 设置为 1 。这个动作最多可以执行 maxChanges 次。
- 选择任意两个相邻的下标 x 和 y（|x - y| == 1）且满足 nums[x] == 1, nums[y] == 0 ，然后交换它们的值（将 nums[y] = 1 和 nums[x] = 0）。如果 y == index，在这次行动后灵茶山艾府拾起一个 1 ，并且 nums[y] 变成 0 。
返回灵茶山艾府拾起 恰好 k 个 1 所需的 最少 行动次数。
提示：
2 <= n <= 10^5
0 <= nums[i] <= 1
1 <= k <= 10^5
0 <= maxChanges <= 10^5
maxChanges + sum(nums) >= k

中位数贪心。
时间复杂度 O(n)
rating 2708 (clist.by)
相似题目: 2968. 执行操作使频率分数最大
https://leetcode.cn/problems/apply-operations-to-maximize-frequency-score/description/
 */