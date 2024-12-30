import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2602 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);

        // 前缀和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        List<Long> resList = new ArrayList<>();
        for (long query : queries) {
            int left = 0;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (nums[mid] >= query) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // [0, left] <= query

            long lans = query * left - preSum[left];
            long rans = preSum[n] - preSum[left] - query * (n - left);
            long ans = lans + rans;
            resList.add(ans);
        }
        return resList;
    }
}
/*
2602. 使数组元素全部相等的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-all-array-elements-equal/

第 338 场周赛 T3。

给你一个正整数数组 nums 。
同时给你一个长度为 m 的整数数组 queries 。第 i 个查询中，你需要将 nums 中所有元素变成 queries[i] 。你可以执行以下操作 任意 次：
- 将数组里一个元素 增大 或者 减小 1 。
请你返回一个长度为 m 的数组 answer ，其中 answer[i]是将 nums 中所有元素变成 queries[i] 的 最少 操作次数。
注意，每次查询后，数组变回最开始的值。
提示：
n == nums.length
m == queries.length
1 <= n, m <= 10^5
1 <= nums[i], queries[i] <= 10^9

前缀和 + 二分
 */