import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2163 {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        // 0 到 n 共 n+1 个
        long[] sumFirst = new long[n + 1];
        long[] sumSecond = new long[n + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 前 n 个最小和
        // [0, n-1]
        for (int i = 0; i < n; i++) {
            sumFirst[0] += nums[i];
            maxHeap.add(nums[i]);
        }
        // 枚举分割点 [n => 2n-1]
        for (int i = 0; i < n; i++) {
            maxHeap.add(nums[n + i]);
            int peek = maxHeap.remove();
            sumFirst[i + 1] = sumFirst[i] + nums[n + i] - peek;
        }

        // 后 n 个最大和
        // [2n, 3n-1]
        for (int i = n * 2; i < n * 3; i++) {
            sumSecond[n] += nums[i];
            minHeap.add(nums[i]);
        }
        // 枚举分割点 [2n-1 => n]
        for (int i = n - 1; i >= 0; i--) {
            minHeap.add(nums[n + i]);
            int peek = minHeap.remove();
            sumSecond[i] = sumSecond[i + 1] + nums[n + i] - peek;
        }

        // 遍历最小值
        long min = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            min = Math.min(min, sumFirst[i] - sumSecond[i]);
        }
        return min;
    }
}
/*
2163. 删除元素后和的最小差值
https://leetcode.cn/problems/minimum-difference-in-sums-after-removal-of-elements/

第 71 场双周赛 T4。

给你一个下标从 0 开始的整数数组 nums ，它包含 3 * n 个元素。
你可以从 nums 中删除 恰好 n 个元素，剩下的 2 * n 个元素将会被分成两个 相同大小 的部分。
- 前面 n 个元素属于第一部分，它们的和记为 sumfirst 。
- 后面 n 个元素属于第二部分，它们的和记为 sumsecond 。
两部分和的 差值 记为 sumfirst - sumsecond 。
- 比方说，sumfirst = 3 且 sumsecond = 2 ，它们的差值为 1 。
- 再比方，sumfirst = 2 且 sumsecond = 3 ，它们的差值为 -1 。
请你返回删除 n 个元素之后，剩下两部分和的 差值的最小值 是多少。
提示：
nums.length == 3 * n
1 <= n <= 10^5
1 <= nums[i] <= 10^5

前 n 个最小和，后 n 个最大和。
枚举分割点，从左到右建最大堆，从右到左建最小堆。三趟遍历。
也可以优化成两趟遍历，先求出后 n 个最大和，在求前 n 个最小和时候一并求出结果。
 */