import java.util.HashMap;
import java.util.Map;

public class Solution3202 {
    public int maximumLength(int[] nums, int k) {
        int ans = 0;
        int[][] f = new int[k][k];
        for (int x : nums) {
            x %= k;
            for (int y = 0; y < k; y++) {
                f[y][x] = f[x][y] + 1;
                ans = Math.max(ans, f[y][x]);
            }
        }
        return ans;
    }

    // O(nkk) TLE
    static class V2 {
        int[] nums;
        int k;
        Map<String, Integer> memo;

        public int maximumLength(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                nums[i] %= k;
            }
            memo = new HashMap<>();
            return dfs(0, k, k);
        }

        // 最后两项模 k 分别为 a, b
        int dfs(int i, int a, int b) {
            if (i == nums.length) return 0;
            String key = i + ":" + a + ":" + b;
            if (memo.containsKey(key)) return memo.get(key);
            int res = dfs(i + 1, a, b);
            if (a == k || nums[i] == a) {
                res = Math.max(res, dfs(i + 1, b, nums[i]) + 1);
            }
            memo.put(key, res);
            return res;
        }
    }
}
/*
3202. 找出有效子序列的最大长度 II
https://leetcode.cn/problems/find-the-maximum-length-of-valid-subsequence-ii/description/

第 404 场周赛 T3。

给你一个整数数组 nums 和一个 正 整数 k 。
nums 的一个 子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列 ：
- (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k
返回 nums 的 最长有效子序列 的长度。
提示：
2 <= nums.length <= 10^3
1 <= nums[i] <= 10^7
1 <= k <= 10^3

等价转换 + 动态规划。
赛时看到子序列，思维固化，只想到 选或不选 or 枚举选哪个 的记忆化搜索。TLE 到完赛。。
时间复杂度 O(k^2 + nk)。
 */