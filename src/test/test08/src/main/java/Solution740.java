import java.util.Arrays;

public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().orElseThrow();
        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return rob(sum);
    }

    private int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    // 如果值域 1e9 如何做？
    private int[] nums, cnt, memo;

    public int deleteAndEarn2(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        cnt = new int[(int) (1e4 + 5)];
        for (int v : nums) {
            cnt[v]++;
        }
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) return memo[i];
        int res = dfs(i + 1); // 不选
        // 选
        int j = lowerBound(nums, nums[i] + 2);
        res = Math.max(res, dfs(j) + nums[i] * cnt[nums[i]]);
        return memo[i] = res;
    }

    private int lowerBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
740. 删除并获得点数
https://leetcode.cn/problems/delete-and-earn/

给你一个整数数组 nums ，你可以对它进行一些操作。
每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
提示：
1 <= nums.length <= 2 * 10^4
1 <= nums[i] <= 10^4

先求出每个 num 出现了 cnt 次，求和 sum[num] = num * cnt
同 198 题，若选取了 sum[num]，sum[num-1] 和 sum[num+1] 都不可再选取，取 rob(int[] sum) 最大值即可。
如果值域 1e9 如何做？
相似题目: 3186. 施咒的最大总伤害
https://leetcode.cn/problems/maximum-total-damage-with-spell-casting/description/
 */