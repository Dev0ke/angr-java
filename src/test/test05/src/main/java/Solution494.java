import java.util.Arrays;

public class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();

        // 负数和 neg，正数和 sum-neg，sum - 2 * neg = target
        if ((sum - target < 0) || (sum - target) % 2 == 1) {
            return 0;
        }
        int neg = (sum - target) / 2;

        // 0-1 背包
        // f[j] 表示元素之和等于 j 的方案数。
        int[] f = new int[neg + 1];
        f[0] = 1;
        for (int wi : nums) {
            for (int j = neg; j >= wi; j--) {
                f[j] += f[j - wi];
            }
        }
        return f[neg];
    }
}
/*
494. 目标和
https://leetcode.cn/problems/target-sum/

给你一个整数数组 nums 和一个整数 target 。
向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
- 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
提示：
1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000

动态规划。0-1 背包 求方案数。
定义 f(i,j) 表示在数组前 i 个数字中选出若干数字使和等于 j 的方法的数目。
状态转移方程
j==0 时             f(i,j) = 1
i==0 && j>0 时      f(i,j) = 0
i>0 && j>nums[i] 时 f(i,j) = f(i-1,j) + f(i-1,j-nums[i])
相似题目: 416. 分割等和子集
https://leetcode.cn/problems/partition-equal-subset-sum/
 */