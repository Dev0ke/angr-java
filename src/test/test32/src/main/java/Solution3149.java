import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3149 {
    private static final int INF = (int) 1e9;
    private int[] nums;
    private int n, full;
    private int[][] memo;
    private List<Integer> ans;

    public int[] findPermutation(int[] nums) {
        this.nums = nums;
        n = nums.length;
        full = (1 << n) - 1;

        memo = new int[1 << n][n];
        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(memo[i], -1);
        }
        dfs(1, 0);
        ans = new ArrayList<>();
        make_ans(1, 0);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(int i, int j) {
        if (i == full) {
            return Math.abs(j - nums[0]);
        }
        if (memo[i][j] != -1) return memo[i][j];
        int res = INF;
        for (int k = 0; k < n; k++) {
            if ((i >> k & 1) == 1) continue;
            res = Math.min(res, dfs(i | 1 << k, k) + Math.abs(j - nums[k]));
        }
        return memo[i][j] = res;
    }

    private void make_ans(int i, int j) {
        ans.add(j);
        if (i == full) {
            return;
        }
        int final_res = dfs(i, j);
        for (int k = 0; k < n; k++) {
            if ((i >> k & 1) == 1) continue;
            if (dfs(i | 1 << k, k) + Math.abs(j - nums[k]) == final_res) {
                make_ans(i | 1 << k, k);
                break;
            }
        }
    }
}
/*
3149. 找出分数最低的排列
https://leetcode.cn/problems/find-the-minimum-cost-array-permutation/description/

第 397 场周赛 T4。

给你一个数组 nums ，它是 [0, 1, 2, ..., n - 1] 的一个 排列。对于任意一个 [0, 1, 2, ..., n - 1] 的排列 perm ，其 分数 定义为：
score(perm) = |perm[0] - nums[perm[1]]| + |perm[1] - nums[perm[2]]| + ... + |perm[n - 1] - nums[perm[0]]|
返回具有 最低 分数的排列 perm 。如果存在多个满足题意且分数相等的排列，则返回其中 字典序最小 的一个。
提示：
2 <= n == nums.length <= 14
nums 是 [0, 1, 2, ..., n - 1] 的一个排列。

状态压缩动态规划 + 记录路径。
时间复杂度 O(n^2 * 2*n)。
1、暴力：枚举所有排列？
 - 暴力做法中，我们关心的是什么？
2、暴力做法中，哪里有重复的子问题？状压 DP 优化了什么？
3、状压 DP（记忆化搜索）
4、记忆化搜索怎么输出方案
 - 怎么保证字典序最小
5、状压 DP（递推）
6、递推怎么输出方案
---
rating 2659 (clist.by)
相似题目: 996. 正方形数组的数目
https://leetcode.cn/problems/number-of-squareful-arrays/
2741. 特别的排列
https://leetcode.cn/problems/special-permutations/
1681. 最小不兼容性
https://leetcode.cn/problems/minimum-incompatibility/
1363. 形成三的最大倍数
https://leetcode.cn/problems/largest-multiple-of-three/description/
 */