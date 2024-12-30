import java.util.HashMap;
import java.util.Map;

public class Solution1569 {
    private static final int MOD = (int) (1e9 + 7);

    public int numOfWays(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        Map<Integer, TreeNode> found = new HashMap<>();
        DSU dsu = new DSU(n);
        Comb comb = new Comb(n);
        for (int i = n - 1; i >= 0; --i) {
            int val = nums[i] - 1;
            TreeNode node = new TreeNode();
            if (val > 0 && found.containsKey(val - 1)) {
                int l_child = dsu.find(val - 1);
                node.left = found.get(l_child);
                node.size += node.left.size;
                dsu.union(val, l_child);
            }
            if (val < n - 1 && found.containsKey(val + 1)) {
                int r_child = dsu.find(val + 1);
                node.right = found.get(r_child);
                node.size += node.right.size;
                dsu.union(val, r_child);
            }

            int l_size = node.left != null ? node.left.size : 0;
            int r_size = node.right != null ? node.right.size : 0;
            int l_ans = node.left != null ? node.left.ans : 1;
            int r_ans = node.right != null ? node.right.ans : 1;
            node.ans = (int) (comb.binom(l_size + r_size, l_size) * l_ans % MOD * r_ans % MOD);
            found.put(val, node);
        }

        return (found.get(nums[0] - 1).ans - 1 + MOD) % MOD;
    }

    static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
            sz = n;
        }

        int find(int x) {
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) {
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
            sz--;
        }
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int size;
        int ans;

        TreeNode() {
            size = 1;
            ans = 0;
        }
    }

    private static class Comb {
        private final long[] fac, invfac;

        public Comb(int n) {
            fac = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) {
                fac[i] = fac[i - 1] * i % MOD;
            }
            invfac = new long[n + 1];
            for (int i = 0; i <= n; i++) {
                invfac[i] = quickPow(fac[i], MOD - 2);
            }
        }

        // C(n, m) = n! / m!(n-m)!
        private long binom(int n, int m) {
            if (n < m || m < 0) return 0;
            return fac[n] * invfac[m] % MOD * invfac[n - m] % MOD;
        }

        // 模下的 a^b
        private long quickPow(long a, long b) {
            long res = 1L;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res = res * a % MOD;
                }
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }
    }
}
/*
1569. 将子数组重新排序得到同一个二叉搜索树的方案数
https://leetcode.cn/problems/number-of-ways-to-reorder-array-to-get-same-bst/description/

给你一个数组 nums 表示 1 到 n 的一个排列。我们按照元素在 nums 中的顺序依次插入一个初始为空的二叉搜索树（BST）。请你统计将 nums 重新排序后，统计满足如下条件的方案数：重排后得到的二叉搜索树与 nums 原本数字顺序得到的二叉搜索树相同。
比方说，给你 nums = [2,1,3]，我们得到一棵 2 为根，1 为左孩子，3 为右孩子的树。数组 [2,3,1] 也能得到相同的 BST，但 [3,2,1] 会得到一棵不同的 BST 。
请你返回重排 nums 后，与原数组 nums 得到相同二叉搜索树的方案数。
由于答案可能会很大，请将结果对 10^9 + 7 取余数。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= nums.length
nums 中所有数 互不相同 。

并查集 + 组合数学。
https://leetcode.cn/problems/number-of-ways-to-reorder-array-to-get-same-bst/solutions/403712/jiang-zi-shu-zu-zhong-xin-pai-xu-de-dao-tong-yi-2/
时间复杂度 O(nlogn)。
 */