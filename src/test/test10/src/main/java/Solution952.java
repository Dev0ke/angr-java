import java.util.Arrays;

public class Solution952 {
    private static final int MAX_N = (int) (1e5 + 5);

    public int largestComponentSize(int[] nums) {
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

        int[] cnt = new int[MAX_N];
        for (int i = 0; i < n; i++) {
            int fa = dsu.find(i);
            cnt[fa]++;
        }
        return Arrays.stream(cnt).max().orElseThrow();
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
952. 按公因数计算最大组件大小
https://leetcode.cn/problems/largest-component-size-by-common-factor/

给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图：
- 有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记；
- 只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。
返回 图中最大连通组件的大小 。
提示：
1 <= nums.length <= 2 * 10^4
1 <= nums[i] <= 10^5
nums 中所有值都 不同

并查集连公因数
相似题目: 1998. 数组的最大公因数排序
https://leetcode.cn/problems/gcd-sort-of-an-array/
 */