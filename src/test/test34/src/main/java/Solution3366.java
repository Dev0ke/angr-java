import java.util.Arrays;

public class Solution3366 {
    private int[] nums;
    private int k;
    private int[][][] memo;

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        this.nums = nums;
        this.k = k;
        int n = nums.length;
        memo = new int[n][op1 + 1][op2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < op1 + 1; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return Arrays.stream(nums).sum() - dfs(0, op1, op2);
    }

    private int dfs(int i, int op1, int op2) {
        if (i == nums.length) return 0;
        if (memo[i][op1][op2] != -1) return memo[i][op1][op2];
        // 不操作
        int res = dfs(i + 1, op1, op2);

        if (op1 > 0) { // 操作1
            res = Math.max(res, dfs(i + 1, op1 - 1, op2) + nums[i] / 2);
            if (op2 > 0 && nums[i] - nums[i] / 2 >= k) { // 接操作2
                res = Math.max(res, dfs(i + 1, op1 - 1, op2 - 1) + nums[i] / 2 + k);
            }
        }
        if (op2 > 0 && nums[i] >= k) { // 操作2
            res = Math.max(res, dfs(i + 1, op1, op2 - 1) + k);
            if (op1 > 0) { // 接操作1
                res = Math.max(res, dfs(i + 1, op1 - 1, op2 - 1) + k + (nums[i] - k) / 2);
            }
        }
        return memo[i][op1][op2] = res;
    }
}
/*
3366. 最小数组和
https://leetcode.cn/problems/minimum-array-sum/description/

第 425 场周赛 T3。

给你一个整数数组 nums 和三个整数 k、op1 和 op2。
你可以对 nums 执行以下操作：
- 操作 1：选择一个下标 i，将 nums[i] 除以 2，并 向上取整 到最接近的整数。你最多可以执行此操作 op1 次，并且每个下标最多只能执行一次。
- 操作 2：选择一个下标 i，仅当 nums[i] 大于或等于 k 时，从 nums[i] 中减去 k。你最多可以执行此操作 op2 次，并且每个下标最多只能执行一次。
注意： 两种操作可以应用于同一下标，但每种操作最多只能应用一次。
返回在执行任意次数的操作后，nums 中所有元素的 最小 可能 和 。
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 10^5
0 <= k <= 10^5
0 <= op1, op2 <= nums.length

记忆化搜索。
时间复杂度 O(n * op1 * op2)。
本题有 O(nlogn) 的贪心解法。
https://leetcode.cn/problems/minimum-array-sum/solutions/2998867/jiao-ni-yi-bu-bu-si-kao-dpcong-ji-yi-hua-0pc5/
 */