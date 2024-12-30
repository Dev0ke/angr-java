import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2741 {
    private static final int MOD = (int) (1e9 + 7);
    private List<Integer>[] g;
    private long[][] memo;
    private int FULL;

    public int specialPerm(int[] nums) {
        int n = nums.length;
        // 预处理 建图
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    g[i].add(j);
                    g[j].add(i);
                }
            }
        }

        // 记忆化搜索
        memo = new long[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        FULL = (1 << n) - 1;
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            ans += dfs(i, 1 << i);
            ans %= MOD;
        }
        return (int) ans;
    }

    // O(n * 2^n)
    // 上一次选择 i, 已选数状态为 mask
    private long dfs(int i, int mask) {
        if (mask == FULL) return 1;
        if (memo[i][mask] != -1) return memo[i][mask];
        long res = 0;
        for (Integer j : g[i]) {
            if ((mask >> j & 1) == 1) continue;
            res += dfs(j, mask | (1 << j));
            res %= MOD;
        }
        return memo[i][mask] = res;
    }
}
/*
2741. 特别的排列
https://leetcode.cn/problems/special-permutations/

第 350 场周赛 T3。

给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列：
- 对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i] == 0 。
请你返回特别排列的总数目，由于答案可能很大，请将它对 10^9 + 7 取余 后返回。
提示：
2 <= nums.length <= 14
1 <= nums[i] <= 10^9

状态压缩动态规划。
时间复杂度 O(n^2 * 2^n)
相似题目: 996. 正方形数组的数目
https://leetcode.cn/problems/number-of-squareful-arrays/
 */