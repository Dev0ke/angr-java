import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution996 {
    private Map<Integer, List<Integer>> adj;
    private int[][] memo;
    private int FULL;

    public int numSquarefulPerms(int[] nums) {
        int n = nums.length;
        // 预处理 建图
        adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSqrtNum(nums[i] + nums[j])) {
                    adj.computeIfAbsent(i, key -> new ArrayList<>()).add(j);
                    adj.computeIfAbsent(j, key -> new ArrayList<>()).add(i);
                }
            }
        }

        // 记忆化搜索
        memo = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        FULL = (1 << n) - 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dfs(i, 1 << i);
        }

        // 去重 两个排列 A1 和 A2 不同的充要条件是存在某个索引 i，使得 A1[i] != A2[i]。
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        for (Integer cnt : cntMap.values()) {
            for (int i = 1; i <= cnt; i++) {
                ans /= i;
            }
        }
        return ans;
    }

    private boolean isSqrtNum(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    // O(n * 2^n) * O(n)
    // 上一次选择 i, 已选数状态为 mask
    private int dfs(int i, int mask) {
        if (mask == FULL) {
            return 1;
        }
        if (memo[i][mask] != -1) {
            return memo[i][mask];
        }

        int res = 0;
        for (Integer j : adj.getOrDefault(i, new ArrayList<>())) {
            if ((mask >> j & 1) == 1) continue;
            res += dfs(j, mask | (1 << j));
        }
        return memo[i][mask] = res;
    }
}
/*
996. 正方形数组的数目
https://leetcode.cn/problems/number-of-squareful-arrays/

给定一个非负整数数组 A，如果该数组每对相邻元素之和是一个完全平方数，则称这一数组为正方形数组。
返回 A 的正方形排列的数目。两个排列 A1 和 A2 不同的充要条件是存在某个索引 i，使得 A1[i] != A2[i]。
提示：
1 <= A.length <= 12
0 <= A[i] <= 1e9

状态压缩动态规划。
时间复杂度 O(n^2 * 2^n)
 */