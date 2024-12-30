import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2386 {
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        // 所有非负数和
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                nums[i] = -nums[i];
            }
        }
        Arrays.sort(nums);

        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        // [sum, i]
        minHeap.add(new long[]{nums[0], 0});

        long subSum = 0;
        for (int i = 0; i < k - 1; i++) {
            long[] top = minHeap.remove();
            subSum = top[0];
            int idx = (int) top[1];
            if (idx + 1 < n) {
                minHeap.add(new long[]{subSum + nums[idx + 1], idx + 1});
                minHeap.add(new long[]{subSum + nums[idx + 1] - nums[idx], idx + 1});
            }
        }
        return sum - subSum;
    }
}
/*
2386. 找出数组的第 K 大和
https://leetcode.cn/problems/find-the-k-sum-of-an-array/

第 307 场周赛 T4。

给你一个整数数组 nums 和一个 正 整数 k 。你可以选择数组的任一 子序列 并且对其全部元素求和。
数组的 第 k 大和 定义为：可以获得的第 k 个 最大 子序列和（子序列和允许出现重复）
返回数组的 第 k 大和 。
子序列是一个可以由其他数组删除某些或不删除元素排生而来的数组，且派生过程不改变剩余元素的顺序。
注意：空子序列的和视作 0 。
提示：
n == nums.length
1 <= n <= 10^5
-10^9 <= nums[i] <= 10^9
1 <= k <= min(2000, 2^n)

最小堆
经典问题：第 k 小子序列和 https://www.cnblogs.com/i209M/p/15388624.html
 */