import java.util.ArrayList;
import java.util.List;

public class Solution300 {
    // 动态规划
    // 时间复杂度 O(n^2)
    // 空间复杂度 O(n)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // 定义 dp[i] 为包含第 i 个元素的最长上升子序列长度
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 严格递增
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 贪心 + 二分查找
    // 时间复杂度 O(nlogn)
    // 空间复杂度 O(n)
    public int lengthOfLIS2(int[] nums) {
        List<Integer> a = new ArrayList<>();
        for (int x : nums) {
            int j = lowerBound(a, x);
            if (j == a.size()) a.add(x);
            else a.set(j, x);
        }
        return a.size();
    }

    private int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }

    // 线段树
    public int lengthOfLIS3(int[] nums) {
        int offset = 10000;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += offset;
        }

        DynamicSegTree dynamicSegTree = new DynamicSegTree();
        for (int num : nums) {
            int max = dynamicSegTree.getMax(0, num - 1);
            dynamicSegTree.update(num, num, max + 1);
        }
        return dynamicSegTree.getMax(0, offset * 2);
    }

    private static class DynamicSegTree {
        private static class Node {
            // 左子树
            Node ls;
            // 右子树
            Node rs;
            // 区间最大值
            int max;
            // 懒标记
            int lazy;
        }

        private static final int N = 20000;
        private final Node root = new Node();

        // 区间更新 [l,r] 置为 val
        void update(int l, int r, int val) {
            this.update(l, r, val, 0, N, root);
        }

        // 区间查询 [l,r] 最大值
        int getMax(int l, int r) {
            return this.getMax(l, r, 0, N, root);
        }

        private void update(int l, int r, int val, int s, int t, Node node) {
            if (l <= s && t <= r) {
                node.max = val;
                node.lazy = val;
                return;
            }
            int mid = s + (t - s) / 2;
            pushDown(node);
            if (l <= mid) {
                update(l, r, val, s, mid, node.ls);
            }
            if (r > mid) {
                update(l, r, val, mid + 1, t, node.rs);
            }
            pushUp(node);
        }

        private int getMax(int l, int r, int s, int t, Node node) {
            if (l <= s && t <= r) {
                return node.max;
            }
            int mid = s + (t - s) / 2;
            pushDown(node);
            int max = 0;
            if (l <= mid) {
                max = Math.max(max, getMax(l, r, s, mid, node.ls));
            }
            if (r > mid) {
                max = Math.max(max, getMax(l, r, mid + 1, t, node.rs));
            }
            return max;
        }

        private void pushDown(Node node) {
            if (node.ls == null) {
                node.ls = new Node();
            }
            if (node.rs == null) {
                node.rs = new Node();
            }
            if (node.lazy > 0) {
                node.ls.max = node.lazy;
                node.rs.max = node.lazy;
                node.ls.lazy = node.lazy;
                node.rs.lazy = node.lazy;
                node.lazy = 0;
            }
        }

        private void pushUp(Node node) {
            node.max = Math.max(node.ls.max, node.rs.max);
        }
    }
}
/*
300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/

给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
提示：
1 <= nums.length <= 2500
-10^4 <= nums[i] <= 10^4
进阶：
你能将算法的时间复杂度降低到 O(n log(n)) 吗?

LIS 模板题。二分优化后：
时间复杂度 O(nlogn)
空间复杂度 O(n)
相似题目: 673. 最长递增子序列的个数
https://leetcode.cn/problems/number-of-longest-increasing-subsequence/
1671. 得到山形数组的最少删除次数
https://leetcode.cn/problems/minimum-number-of-removals-to-make-mountain-array/
1713. 得到子序列的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-a-subsequence/
1964. 找出到每个位置为止最长的有效障碍赛跑路线
https://leetcode.cn/problems/find-the-longest-valid-obstacle-course-at-each-position/
$3231. 要删除的递增子序列的最小数量
https://leetcode.cn/problems/minimum-number-of-increasing-subsequence-to-be-removed/description/
 */