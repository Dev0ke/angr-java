import java.util.Arrays;

public class Solution1262 {
    private int n;
    private int[] nums;
    private int[][] memo;

    public int maxSumDivThree(int[] nums) {
        n = nums.length;
        this.nums = nums;
        memo = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0);
    }

    private int dfs(int i, int pre) {
        if (i == n) {
            return pre == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[i][pre] != -1) {
            return memo[i][pre];
        }
        int res = Math.max(dfs(i + 1, pre), dfs(i + 1, (pre + nums[i]) % 3) + nums[i]);
        return memo[i][pre] = res;
    }
}
/*
1262. 可被三整除的最大和
https://leetcode.cn/problems/greatest-sum-divisible-by-three/

给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
提示：
1 <= nums.length <= 4 * 10^4
1 <= nums[i] <= 10^4

记忆化搜索
时间复杂度 O(n)
 */