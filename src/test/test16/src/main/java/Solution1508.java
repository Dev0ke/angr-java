import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1508 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // 前缀和
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // O(n^2)
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                list.add(preSum[j + 1] - preSum[i]);
            }
        }
        Collections.sort(list);

        int sum = 0;
        for (int i = left - 1; i < right; i++) {
            sum += list.get(i);
            sum %= 1000000007;
        }
        return sum;
    }
}
/*
1508. 子数组和排序后的区间和
https://leetcode.cn/problems/range-sum-of-sorted-subarray-sums/

给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数字的数组。
请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
提示：
1 <= nums.length <= 10^3
nums.length == n
1 <= nums[i] <= 100
1 <= left <= right <= n * (n + 1) / 2

模拟。
 */