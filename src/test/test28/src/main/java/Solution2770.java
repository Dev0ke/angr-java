import java.util.Arrays;

public class Solution2770 {
    private int[] nums;
    private int target;
    private int n;
    private int[] memo;

    public int maximumJumps(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.n = nums.length;

        memo = new int[n];
        Arrays.fill(memo, -1);
        int ans = dfs(0);
        return ans < 0 ? -1 : ans;
    }

    private int dfs(int i) {
        if (i == n - 1) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }

        // 注意不能初始化为 0
        int res = (int) -1e9;
        for (int j = i + 1; j < n; j++) {
            if (Math.abs(nums[j] - nums[i]) <= target) {
                res = Math.max(res, dfs(j) + 1);
            }
        }
        return memo[i] = res;
    }
}
/*
2770. 达到末尾下标所需的最大跳跃次数
https://leetcode.cn/problems/maximum-number-of-jumps-to-reach-the-last-index/

第 353 场周赛 T2。

给你一个下标从 0 开始、由 n 个整数组成的数组 nums 和一个整数 target 。
你的初始位置在下标 0 。在一步操作中，你可以从下标 i 跳跃到任意满足下述条件的下标 j ：
- 0 <= i < j < n
- -target <= nums[j] - nums[i] <= target
返回到达下标 n - 1 处所需的 最大跳跃次数 。
如果无法到达下标 n - 1 ，返回 -1 。
提示：
2 <= nums.length == n <= 1000
-10^9 <= nums[i] <= 10^9
0 <= target <= 2 * 10^9

记忆化搜索
注意 res 不能初始化为 0，要初始化为 -inf
时间复杂度 O(n^2)
 */