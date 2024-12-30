import java.util.Arrays;

public class SolutionP2464 {
    private static final int INF = (int) 1e9;

    public int validSubarraySplit(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (getGCD(nums[i - 1], nums[j - 1]) > 1) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n] == INF ? -1 : dp[n];
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
$2464. 有效分割中的最少子数组数目
https://leetcode.cn/problems/minimum-subarrays-in-a-valid-split/description/

给定一个整数数组 nums。
如果要将整数数组 nums 拆分为 子数组 后是 有效的，则必须满足:
- 每个子数组的第一个和最后一个元素的最大公约数 大于 1，且
- nums 的每个元素只属于一个子数组。
返回 nums 的 有效 子数组拆分中的 最少 子数组数目。如果不能进行有效的子数组拆分，则返回 -1。
注意:
- 两个数的 最大公约数 是能整除两个数的最大正整数。
- 子数组 是数组中连续的非空部分。
提示:
1 <= nums.length <= 1000
1 <= nums[i] <= 10^5

设 dp[i] 表示前 i 个元素可以被划分为子数组的最小数目
时间复杂度 O(n^2)。
 */