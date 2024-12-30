import java.util.Arrays;

public class Solution2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;

        Arrays.sort(nums);

        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            answer[i] = binarySearch(preSum, queries[i]);
        }
        return answer;
    }

    private int binarySearch(int[] preSum, int query) {
        int left = 0;
        int right = preSum.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (preSum[mid] > query) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
/*
2389. 和有限的最长子序列
https://leetcode.cn/problems/longest-subsequence-with-limited-sum/

第 308 场周赛 T1。

给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
提示：
n == nums.length
m == queries.length
1 <= n, m <= 1000
1 <= nums[i], queries[i] <= 10^6

排序+前缀和+二分。根据贪心，子序列 的 最大 长度必然由最小的数组成。
时间复杂度 O(nlogn)
 */