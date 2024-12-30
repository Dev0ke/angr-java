import java.util.Arrays;

public class Solution53 {
    // 动态规划
    // 时间复杂度 O(n)
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i] 代表以第 i 个数结尾的「连续子数组的最大和」
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    static class V2 {
        // 动态规划（状态压缩）
        // 时间复杂度 O(n)
        // 空间复杂度 O(1)
        public int maxSubArray(int[] nums) {
            int dp = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp = nums[i] + Math.max(dp, 0);
                max = Math.max(max, dp);
            }
            return max;
        }
    }

    static class V3 {
        public int maxSubArray(int[] nums) {
            MaxSubArraySegTree seg = new MaxSubArraySegTree(nums);
            return seg.query(1, nums.length);
        }

        static class MaxSubArraySegTree {
            Node[] tree;
            static final int INF = (int) 1e9;

            static class Node {
                // 分别表示 [l,r] 区间：前缀最大子段和，后缀最大子段和，最大子段和，区间和
                int maxL, maxR, maxSum, sum;

                public Node(int maxL, int maxR, int maxSum, int sum) {
                    this.maxL = maxL;
                    this.maxR = maxR;
                    this.maxSum = maxSum;
                    this.sum = sum;
                }
            }

            int[] nums;
            int n;

            public MaxSubArraySegTree(int[] nums) {
                this.nums = nums;
                this.n = nums.length;
                tree = new Node[4 * n];
                Arrays.setAll(tree, e -> new Node(0, 0, 0, 0));

                build(1, 1, n);
            }

            void build(int p, int l, int r) {
                if (l == r) {
                    int val = nums[l - 1];
                    tree[p].maxL = tree[p].maxR = tree[p].maxSum = tree[p].sum = val;
                    return;
                }
                int mid = l + (r - l) / 2;
                build(p << 1, l, mid);
                build(p << 1 | 1, mid + 1, r);
                tree[p] = pushUp(tree[p << 1], tree[p << 1 | 1]);
            }

            // nums[pos] 修改为 val
            void modify(int pos, int val) {
                modify(1, 1, n, pos, val);
            }

            void modify(int p, int l, int r, int pos, int val) {
                if (l > pos || r < pos) {
                    return;
                }
                if (l == pos && r == pos) {
                    tree[p].maxL = tree[p].maxR = tree[p].maxSum = tree[p].sum = val;
                    return;
                }
                int mid = l + (r - l) / 2;
                modify(p << 1, l, mid, pos, val);
                modify(p << 1 | 1, mid + 1, r, pos, val);
                tree[p] = pushUp(tree[p * 2], tree[p * 2 + 1]);
            }

            // 查询 [l,r] 区间最大子段和
            int query(int ql, int qr) {
                return query(1, 1, n, ql, qr).maxSum;
            }

            Node query(int p, int l, int r, int ql, int qr) {
                if (l > qr || r < ql) {
                    return new Node(-INF, -INF, -INF, 0);
                }
                if (ql <= l && r <= qr) {
                    return tree[p];
                }
                int mid = l + (r - l) / 2;
                Node ls = query(p << 1, l, mid, ql, qr);
                Node rs = query(p << 1 | 1, mid + 1, r, ql, qr);
                return pushUp(ls, rs);
            }

            Node pushUp(Node ls, Node rs) {
                int maxL = Math.max(ls.maxL, ls.sum + rs.maxL);
                int maxR = Math.max(rs.maxR, rs.sum + ls.maxR);
                // max(l.maxSum, r.maxSum, l.maxR + r.maxL)
                int maxSum = Math.max(Math.max(ls.maxSum, rs.maxSum), ls.maxR + rs.maxL);
                int sum = ls.sum + rs.sum;
                return new Node(maxL, maxR, maxSum, sum);
            }
        }
    }

    static class V4 {
        // TLE 调和级数 理论是 O(nlogn)
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] ps = new int[n + 1];
            for (int i = 0; i < n; i++) {
                ps[i + 1] = ps[i] + nums[i];
            }

            int ans = Integer.MIN_VALUE;
            for (int span = 1; span <= n; span++) {
                for (int i = 0; i + span <= n; i++) {
                    ans = Math.max(ans, ps[i + span] - ps[i]);
                }
            }
            return ans;
        }
    }
}
/*
53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/

给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组 是数组中的一个连续部分。
提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。

动态规划
时间复杂度 O(n)
线段树 时间复杂度 O(nlogn)
相似题目: 152. 乘积最大子数组
https://leetcode.cn/problems/maximum-product-subarray/
918. 环形子数组的最大和
https://leetcode.cn/problems/maximum-sum-circular-subarray/
$1746. 经过一次操作后的最大子数组和
https://leetcode.cn/problems/maximum-subarray-sum-after-one-operation/
H. Gambling
https://codeforces.com/contest/1692/problem/H
1749. 任意子数组和的绝对值的最大值
https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/description/
1191. K 次串联后最大子数组之和
https://leetcode.cn/problems/k-concatenation-maximum-sum/description/
 */
