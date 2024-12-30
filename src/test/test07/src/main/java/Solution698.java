import java.util.Arrays;

public class Solution698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int partitionSum = sum / k;

        // 状态定义 dp[mask] 为选取状态 mask 时，未填满的组的和
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int state = 0; state < (1 << n); state++) {
            for (int i = 0; i < n; i++) {
                // 第 k 位被选中
                if (((state >> i) & 1) == 1) {
                    // 去掉 state 的第 k 根火柴得到状态 s1
                    int s1 = state & ~(1 << i);
                    if (dp[s1] >= 0 && dp[s1] + nums[i] <= partitionSum) {
                        dp[state] = (dp[s1] + nums[i]) % partitionSum;
                        break;
                    }
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }
}
/*
698. 划分为k个相等的子集
https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/

给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
提示：
1 <= k <= len(nums) <= 16
0 < nums[i] < 10000
每个元素的频率在 [1,4] 范围内

状态压缩动态规划
相似题目: 473. 火柴拼正方形
https://leetcode.cn/problems/matchsticks-to-square/
 */