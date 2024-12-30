import java.util.Arrays;

public class Solution2681 {
    private static final int MOD = (int) (1e9 + 7);

    public int sumOfPower(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        long ans = 0;
        long minSum = 0;
        for (int i = 0; i < n; i++) {
            long maxPow = (long) nums[i] * nums[i] % MOD;
            minSum += nums[i];
            if (i > 1) {
                minSum = (minSum * 2 - nums[i] - nums[i - 1]) % MOD;
            }
            ans = (ans + maxPow * minSum) % MOD;
        }
        return (int) ans;
    }
}
/*
2681. 英雄的力量
https://leetcode.cn/problems/power-of-heroes/

第 104 场双周赛 T4。

给你一个下标从 0 开始的整数数组 nums ，它表示英雄的能力值。如果我们选出一部分英雄，这组英雄的 力量 定义为：
i0 ，i1 ，... ik 表示这组英雄在数组中的下标。那么这组英雄的力量为 max(nums[i0],nums[i1] ... nums[ik])2 * min(nums[i0],nums[i1] ... nums[ik]) 。
请你返回所有可能的 非空 英雄组的 力量 之和。由于答案可能非常大，请你将结果对 10^9 + 7 取余。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

贡献法。
子序列 最大最小值问题，与顺序无关。排序后找规律。
发现最小值系数为：
1
1 1
2 1 1
4 2 1 1
8 4 2 1 1
...
注意及时取模，避免爆 long...
相似题目: 2104. 子数组范围和
https://leetcode.cn/problems/sum-of-subarray-ranges/
 */