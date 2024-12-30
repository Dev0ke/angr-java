import java.util.Arrays;

public class Solution3251 {
    // 记忆化搜索
    static class V1 {
        final int MOD = (int) (1e9 + 7);
        int[] nums;
        long[][] memo;

        public int countOfPairs(int[] nums) {
            this.nums = nums;
            int n = nums.length;
            int mx = Arrays.stream(nums).max().orElseThrow();

            memo = new long[n][mx + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(memo[i], -1);
            }
            long ans = 0;
            for (int j = 0; j <= nums[n - 1]; j++) {
                ans += dfs(n - 1, j);
            }
            return (int) (ans % MOD);
        }

        private long dfs(int i, int j) {
            if (i == 0) return 1;
            if (memo[i][j] != -1) return memo[i][j];

            // a[i] 填了 j，设 a[i-1] 填 k
            // 0 <= k <= nums[i-1]
            // k <= j
            // nums[i] - j <= nums[i-1] - k
            long res = 0;
            int max_k = Math.min(nums[i - 1], Math.min(j, nums[i - 1] - nums[i] + j));
            for (int k = 0; k <= max_k; k++) {
                res += dfs(i - 1, k);
            }
            return memo[i][j] = res % MOD;
        }
    }

    // 1:1 翻译成递推
    static class V2 {
        final int MOD = (int) (1e9 + 7);

        public int countOfPairs(int[] nums) {
            int n = nums.length;
            int mx = Arrays.stream(nums).max().orElseThrow();
            long[][] f = new long[n][mx + 1];
            for (int j = 0; j <= nums[0]; j++) {
                f[0][j] = 1;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= nums[i]; j++) {
                    int max_k = Math.min(nums[i - 1], Math.min(j, nums[i - 1] - nums[i] + j));
                    for (int k = 0; k <= max_k; k++) {
//                        res += dfs(i - 1, k);
                        f[i][j] += f[i - 1][k];
                        f[i][j] %= MOD;
                    }
                }
            }

            long ans = 0;
            for (int j = 0; j <= nums[n - 1]; j++) {
                ans += f[n - 1][j];
            }
            return (int) (ans % MOD);
        }
    }

    // 前缀和优化 DP
    final int MOD = (int) (1e9 + 7);

    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int mx = Arrays.stream(nums).max().orElseThrow();
        long[][] f = new long[n][mx + 1];
        for (int j = 0; j <= nums[0]; j++) {
            f[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            long[] ps = new long[f[i - 1].length + 1];
            for (int j = 0; j < f[i - 1].length; j++) {
                ps[j + 1] = (ps[j] + f[i - 1][j]) % MOD;
            }

            for (int j = 0; j <= nums[i]; j++) {
                int max_k = Math.min(nums[i - 1], Math.min(j, nums[i - 1] - nums[i] + j));
//                for (int k = 0; k <= max_k; k++) {
//                    f[i][j] += f[i - 1][k];
//                    f[i][j] %= MOD;
//                }
                f[i][j] = max_k >= 0 ? ps[max_k + 1] : 0;
            }
        }

        long ans = 0;
        for (int j = 0; j <= nums[n - 1]; j++) {
            ans += f[n - 1][j];
        }
        return (int) (ans % MOD);
    }
}
/*
3251. 单调数组对的数目 II
https://leetcode.cn/problems/find-the-count-of-monotonic-pairs-ii/description/

第 410 场周赛 T4。

给你一个长度为 n 的 正 整数数组 nums 。
如果两个 非负 整数数组 (arr1, arr2) 满足以下条件，我们称它们是 单调 数组对：
- 两个数组的长度都是 n 。
- arr1 是单调 非递减 的，换句话说 arr1[0] <= arr1[1] <= ... <= arr1[n - 1] 。
- arr2 是单调 非递增 的，换句话说 arr2[0] >= arr2[1] >= ... >= arr2[n - 1] 。
- 对于所有的 0 <= i <= n - 1 都有 arr1[i] + arr2[i] == nums[i] 。
请你返回所有 单调 数组对的数目。
由于答案可能很大，请你将它对 10^9 + 7 取余 后返回。
提示：
1 <= n == nums.length <= 2000
1 <= nums[i] <= 1000

现在大家都会 前缀和优化 DP 了吗？
时间复杂度 O(nm)。其中 m = 1000
另有 O(n) 的组合数学做法。
https://leetcode.cn/problems/find-the-count-of-monotonic-pairs-ii/solutions/2876190/qian-zhui-he-you-hua-dppythonjavacgo-by-3biek/
 */