import java.util.PriorityQueue;

public class Solution3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        for (long v : nums) {
            heap.add(v);
        }

        int ans = 0;
        while (!heap.isEmpty() && heap.peek() < k) {
            long x = heap.remove();
            long y = heap.remove();
            heap.add(x * 2 + y);
            ans++;
        }
        return ans;
    }
}
/*
3066. 超过阈值的最少操作数 II
https://leetcode.cn/problems/minimum-operations-to-exceed-threshold-value-ii/description/

第 125 场双周赛 T2。

给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
一次操作中，你将执行：
- 选择 nums 中最小的两个整数 x 和 y 。
- 将 x 和 y 从 nums 中删除。
- 将 min(x, y) * 2 + max(x, y) 添加到数组中的任意位置。
注意，只有当 nums 至少包含两个元素时，你才可以执行以上操作。
你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
提示：
2 <= nums.length <= 2 * 10^5
1 <= nums[i] <= 10^9
1 <= k <= 10^9
输入保证答案一定存在，也就是说一定存在一个操作序列使数组中所有元素都大于等于 k 。

堆模拟。
 */