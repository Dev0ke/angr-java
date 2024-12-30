import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionP2297 {
    public long minCost(int[] nums, int[] costs) {
        int n = nums.length;
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        Deque<Integer> maxStack = new ArrayDeque<>();
        Deque<Integer> minStack = new ArrayDeque<>();
        for (int j = 0; j < n; j++) {
            while (!minStack.isEmpty() && nums[minStack.peek()] <= nums[j]) {
                int i = minStack.pop();
                dp[j] = Math.min(dp[j], dp[i] + costs[j]);
            }
            minStack.push(j);
            while (!maxStack.isEmpty() && nums[maxStack.peek()] > nums[j]) {
                dp[j] = Math.min(dp[j], dp[maxStack.pop()] + costs[j]);
            }
            maxStack.push(j);
        }
        return dp[n - 1];
    }
}
/*
$2297. 跳跃游戏 VIII
https://leetcode.cn/problems/jump-game-viii/description/

给定一个长度为 n 的下标从 0 开始的整数数组 nums。初始位置为下标 0。当 i < j 时，你可以从下标 i 跳转到下标 j:
- 对于在 i < k < j 范围内的所有下标 k 有 nums[i] <= nums[j] 和 nums[k] < nums[i] , 或者
- 对于在 i < k < j 范围内的所有下标 k 有 nums[i] > nums[j] 和 nums[k] >= nums[i] 。
你还得到了一个长度为 n 的整数数组 costs，其中 costs[i] 表示跳转到下标 i 的代价。
返回跳转到下标 n - 1 的最小代价。
解释:
n == nums.length == costs.length
1 <= n <= 10^5
0 <= nums[i], costs[i] <= 10^5

单调栈 + DP。
https://leetcode.cn/problems/jump-game-viii/solutions/1988189/by-esther29-fgck/
 */