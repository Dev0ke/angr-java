import java.util.PriorityQueue;

public class SolutionP2599 {
    public int makePrefSumNonNegative(int[] nums) {
        long mock = 1;
        int cnt = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (num < 0) {
                minHeap.add(num);
            }
            if (mock + num <= 0) {
                cnt++;
                mock -= minHeap.remove();
            }
            mock += num;
        }
        return cnt;
    }
}
/*
$2599. 使前缀和数组非负
https://leetcode.cn/problems/make-the-prefix-sum-non-negative/description/

给定一个 下标从0开始 的整数数组 nums 。你可以任意多次执行以下操作：
- 从 nums 中选择任意一个元素，并将其放到 nums 的末尾。
nums 的前缀和数组是一个与 nums 长度相同的数组 prefix ，其中 prefix[i] 是所有整数 nums[j]（其中 j 在包括区间 [0，i] 内）的总和。
返回使前缀和数组不包含负整数的最小操作次数。测试用例的生成方式保证始终可以使前缀和数组非负。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

贪心+优先队列模拟。
相似题目: LCP 30. 魔塔游戏
https://leetcode.cn/problems/p0NxJO/
 */