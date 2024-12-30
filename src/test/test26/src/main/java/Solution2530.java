import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2530 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            maxHeap.add(num);
        }

        long res = 0;
        for (int i = 0; i < k; i++) {
            int pop = maxHeap.remove();
            res += pop;
            maxHeap.add((pop + 2) / 3);
        }
        return res;
    }
}
/*
2530. 执行 K 次操作后的最大分数
https://leetcode.cn/problems/maximal-score-after-applying-k-operations/

第 327 场周赛 T2。

给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。
在一步 操作 中：
1. 选出一个满足 0 <= i < nums.length 的下标 i ，
2. 将你的 分数 增加 nums[i] ，并且
3. 将 nums[i] 替换为 ceil(nums[i] / 3) 。
返回在 恰好 执行 k 次操作后，你可能获得的最大分数。
向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。
提示：
1 <= nums.length, k <= 10^5
1 <= nums[i] <= 10^9

大顶堆模拟
时间复杂度 O(nlogn)
 */