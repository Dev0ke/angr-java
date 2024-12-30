import java.util.Arrays;

public class Solution2656 {
    public int maximizeSum(int[] nums, int k) {
        int max = Arrays.stream(nums).max().orElseThrow();
        return (max + (max + k - 1)) * k / 2;
    }
}
/*
2656. K 个元素的最大和
https://leetcode.cn/problems/maximum-sum-with-exactly-k-elements/

第 103 场双周赛 T1。

给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你需要执行以下操作 恰好 k 次，最大化你的得分：
1.从 nums 中选择一个元素 m 。
2.将选中的元素 m 从数组中删除。
3.将新元素 m + 1 添加到数组中。
4.你的得分增加 m 。
请你返回执行以上操作恰好 k 次后的最大得分。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100
1 <= k <= 100

贪心。等差数列求和。
时间复杂度 O(n)
 */