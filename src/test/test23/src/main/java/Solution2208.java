import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2208 {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // 数组和的一半
        double halfSum = 0;
        for (int num : nums) {
            halfSum += num;
            maxHeap.add((double) num);
        }
        halfSum /= 2;

        // 贪心
        int cnt = 0;
        double sum = 0;
        while (sum < halfSum && !maxHeap.isEmpty()) {
            double poll = maxHeap.poll();
            poll /= 2.0;
            sum += poll;
            maxHeap.add(poll);
            cnt++;
        }
        return cnt;
    }
}
/*
2208. 将数组和减半的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/

第 74 场双周赛 T3。

给你一个正整数数组 nums 。每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。（注意，在后续操作中你可以对减半过的数继续执行操作）
请你返回将 nums 数组和 至少 减少一半的 最少 操作数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^7

贪心，若要使操作数最少，则每次应该选择当前最大的数，使用优先队列进行模拟即可。
 */