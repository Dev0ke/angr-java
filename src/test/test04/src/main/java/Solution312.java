import java.util.Arrays;

public class Solution312 {
    private int[] val;
    private int[][] memo;

    public int maxCoins(int[] nums) {
        int n = nums.length;

        // 两边各加上题目中假设存在的 nums[-1] 和 nums[n]
        val = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;

        memo = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(0, n + 1);
    }

    private int f(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (memo[left][right] != -1) {
            return memo[left][right];
        }

        int max = 0;
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += f(left, i) + f(i, right);
            max = Math.max(max, sum);
        }
        memo[left][right] = max;
        return max;
    }
}
/*
312. 戳气球
https://leetcode.cn/problems/burst-balloons/

有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
求所能获得硬币的最大数量。
提示：
n == nums.length
1 <= n <= 300
0 <= nums[i] <= 100

记忆化搜索
时间复杂度 O(n^3)
空间复杂度 O(n^2)
 */