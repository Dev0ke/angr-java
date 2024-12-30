import java.util.Arrays;

public class Solution1862 {
    private static final long MOD = 1000000007;

    // 枚举 x 和 y, 时间复杂度 O(n^2) TLE
    public int sumOfFlooredPairs2(int[] nums) {
        long sum = 0;
        for (int n1 : nums) {
            for (int n2 : nums) {
                sum += n1 / n2;
                sum %= MOD;
            }
        }
        return (int) sum;
    }

    // 枚举 y 和 floor(x/y) 时间复杂度 O(n + ClogC)
    public int sumOfFlooredPairs(int[] nums) {
        int max = Arrays.stream(nums).max().orElseThrow();
        int[] cnt = new int[max + 1];
        for (int num : nums) {
            cnt[num]++;
        }

        // 前缀和
        int[] preSum = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            preSum[i] = preSum[i - 1] + cnt[i];
        }

        long sum = 0;
        // 枚举 y 和 floor(x/y)
        // d*y <= x <= (d+1)*y
        for (int y = 1; y <= max; y++) {
            if (cnt[y] > 0) {
                for (int d = 1; d * y <= max; d++) {
                    sum += (long) cnt[y] * d * (preSum[Math.min((d + 1) * y - 1, max)] - preSum[d * y - 1]);
                }
            }
        }
        return (int) (sum % MOD);
    }
}
/*
1862. 向下取整数对和
https://leetcode.cn/problems/sum-of-floored-pairs/

给你一个整数数组 nums ，请你返回所有下标对 0 <= i, j < nums.length 的 floor(nums[i] / nums[j]) 结果之和。
由于答案可能会很大，请你返回答案对 10^9 + 7 取余 的结果。
函数 floor() 返回输入数字的整数部分。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

直接枚举 x y 会 TLE
枚举 y 和 floor(x/y)
时间复杂度 O(n + ClogC)
 */