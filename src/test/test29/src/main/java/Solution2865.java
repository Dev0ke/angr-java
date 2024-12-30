import java.util.List;

public class Solution2865 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long sum = maxHeights.get(i);

            int max = maxHeights.get(i);
            for (int j = i; j > 0; j--) {
                int hj = Math.min(max, maxHeights.get(j - 1));
                max = Math.min(max, hj);
                sum += hj;
            }

            max = maxHeights.get(i);
            for (int k = i; k < n - 1; k++) {
                int hk = Math.min(max, maxHeights.get(k + 1));
                max = Math.min(max, hk);
                sum += hk;
            }

            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
/*
2865. 美丽塔 I
https://leetcode.cn/problems/beautiful-towers-i/

第 364 场周赛 T2。

给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
如果以下条件满足，我们称这些塔是 美丽 的：
1. 1 <= heights[i] <= maxHeights[i]
2. heights 是一个 山状 数组。
如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山状 数组：
- 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
- 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
提示：
1 <= n == maxHeights <= 10^3
1 <= maxHeights[i] <= 10^9

暴力模拟
时间复杂度 O(n^2)
 */