import java.util.Arrays;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;

        // 0-1 背包
        // f[j] 代表选择数字总和不超过 j 的最大和。
        int[] f = new int[target + 1];
        for (int wi : nums) {
            for (int j = target; j >= wi; j--) {
                f[j] = Math.max(f[j], f[j - wi] + wi);
            }
        }
        return f[target] == target;
    }
}
/*
416. 分割等和子集
https://leetcode.cn/problems/partition-equal-subset-sum/

给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
提示：
1 <= nums.length <= 200
1 <= nums[i] <= 100

经典 NP 完全问题。
动态规划。0-1 背包。
f(i,j) 表示能否从前 i 个物品中选择若干物品放满容量为 j 的背包。
如果总共有 n 个物品，背包的容量为 t，那么 f(n,t) 就是问题的解。
状态转移：
对于每件物品有两种选择，即选择与不选择
如果能从前 i-1 个物品 中选择若干物品放满容量为 j-nums[i-1] 的背包。若 f(i-1,j-nums[i-1]) == true 则 f(i,j) = true
如果能从前 i-1 个物品 中选择若干物品放满容量为 j 的背包。若 f(i-1,j) == true 则 f(i,j) = true
初始状态：
当 j 等于 0 时，即背包容量为 0，则 f(i,0) 恒为 true
当 i 等于 0 时，即物品数为 0，则 f(0,j) 恒为 false
相似题目: 494. 目标和
https://leetcode.cn/problems/target-sum/
 */