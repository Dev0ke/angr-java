import java.util.Arrays;

public class Solution2786 {
    private int[] nums;
    private int x;
    private long[][] memo;

    public long maxScore(int[] nums, int x) {
        this.nums = nums;
        this.x = x;
        int n = nums.length;
        memo = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, nums[0] % 2);
    }

    // j=1 上一个选了奇数
    private long dfs(int i, int j) {
        if (i == nums.length) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        // 不选
        long res = dfs(i + 1, j);
        // 选
        boolean b = nums[i] % 2 != j;
        res = Math.max(res, dfs(i + 1, nums[i] % 2) + nums[i] - (b ? x : 0));
        return memo[i][j] = res;
    }
}
/*
2786. 访问数组中的位置使分数最大
https://leetcode.cn/problems/visit-array-positions-to-maximize-score/

第 109 场双周赛 T3。

给你一个下标从 0 开始的整数数组 nums 和一个正整数 x 。
你 一开始 在数组的位置 0 处，你可以按照下述规则访问数组中的其他位置：
- 如果你当前在位置 i ，那么你可以移动到满足 i < j 的 任意 位置 j 。
- 对于你访问的位置 i ，你可以获得分数 nums[i] 。
- 如果你从位置 i 移动到位置 j 且 nums[i] 和 nums[j] 的 奇偶性 不同，那么你将失去分数 x 。
请你返回你能得到的 最大 得分之和。
注意 ，你一开始的分数为 nums[0] 。
提示：
2 <= nums.length <= 10^5
1 <= nums[i], x <= 10^6

记忆化搜索。选或不选。
时间复杂度 O(n)
 */