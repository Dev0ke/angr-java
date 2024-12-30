import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3098 {
    private static final int MOD = (int) (1e9 + 7);
    private int[] nums;
    private Map<String, Long> memo;

    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        this.nums = nums;
        int n = nums.length;
        memo = new HashMap<>();
        long ans = dfs(n - 1, k, Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2);
        return (int) ans;
    }

    // i:下标 j:需要选多少个数 pre:上一个选的数 min_diff:能量和
    private long dfs(int i, int j, int pre, int min_diff) {
        if (j > i + 1) return 0;
        if (j == 0) return min_diff;
        String key = i + ":" + j + ":" + pre + ":" + min_diff;
        if (memo.containsKey(key)) return memo.get(key);
        // 不选
        long res1 = dfs(i - 1, j, pre, min_diff);
        // 选
        long res2 = dfs(i - 1, j - 1, nums[i], Math.min(min_diff, pre - nums[i]));
        long res = (res1 + res2) % MOD;
        memo.put(key, res);
        return res;
    }

    static class TLE {
        private static final int MOD = (int) (1e9 + 7);
        private int[] nums;
        private int k;
        private List<Integer> res;
        private long ans;

        public int sumOfPowers(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
            Arrays.sort(nums);
            res = new ArrayList<>();
            ans = 0;
            dfs(0);
            return (int) ans;
        }

        private void dfs(int i) {
            if (res.size() == k) {
                int contribution = res.get(k - 1) - res.get(0);
                for (int j = 1; j < k; j++) {
                    contribution = Math.min(contribution, res.get(j) - res.get(j - 1));
                }
                ans = (ans + contribution) % MOD;
            } else if (i < nums.length) {
                dfs(i + 1);
                res.add(nums[i]);
                dfs(i + 1);
                res.remove(res.size() - 1);
            }
        }
    }
}
/*
3098. 求出所有子序列的能量和
https://leetcode.cn/problems/find-the-sum-of-subsequence-powers/description/

第 127 场双周赛 T4。

给你一个长度为 n 的整数数组 nums 和一个 正 整数 k 。
一个子序列的 能量 定义为子序列中 任意 两个元素的差值绝对值的 最小值 。
请你返回 nums 中长度 等于 k 的 所有 子序列的 能量和 。
由于答案可能会很大，将答案对 10^9 + 7 取余 后返回。
提示：
2 <= n == nums.length <= 50
-10^8 <= nums[i] <= 10^8
2 <= k <= n

记忆化搜索。
时间复杂度 O(kn^2)。
rating 2571 (clist.by)
 */