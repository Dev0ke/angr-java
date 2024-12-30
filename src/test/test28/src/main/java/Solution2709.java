import java.util.Arrays;

public class Solution2709 {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;

        int mx = Arrays.stream(nums).max().orElseThrow();
        // 埃氏筛 预处理 最小质因子
        int[] lpf = new int[mx + 1];
        for (int i = 2; i <= mx; i++) {
            if (lpf[i] == 0) {
                for (int j = i; j <= mx; j += i) {
                    if (lpf[j] == 0) {
                        lpf[j] = i;
                    }
                }
            }
        }

        // O(n + U/logU) 个点, O(nlogU) 条边
        DSU dsu = new DSU(n + mx + 1);
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (x > 1) {
                int p = lpf[x];
                for (x /= p; lpf[x] == p; x /= p) {
                }
                dsu.union(i, n + p);
            }
        }

        for (int i = 0; i < n; i++) {
            if (dsu.find(i) != dsu.find(0)) {
                return false;
            }
        }
        return true;
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            // 路径压缩
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
        }
    }
}
/*
2709. 最大公约数遍历
https://leetcode.cn/problems/greatest-common-divisor-traversal/

第 105 场双周赛 T4。

给你一个下标从 0 开始的整数数组 nums ，你可以在一些下标之间遍历。对于两个下标 i 和 j（i != j），当且仅当 gcd(nums[i], nums[j]) > 1 时，我们可以在两个下标之间通行，其中 gcd 是两个数的 最大公约数 。
你需要判断 nums 数组中 任意 两个满足 i < j 的下标 i 和 j ，是否存在若干次通行可以从 i 遍历到 j 。
如果任意满足条件的下标对都可以遍历，那么返回 true ，否则返回 false 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

并查集。
时间复杂度 O(nlogA)
相似题目: 952. 按公因数计算最大组件大小
https://leetcode.cn/problems/largest-component-size-by-common-factor/
1998. 数组的最大公因数排序
https://leetcode.cn/problems/gcd-sort-of-an-array/
D. Friendly Spiders
https://codeforces.com/contest/1775/problem/D
 */