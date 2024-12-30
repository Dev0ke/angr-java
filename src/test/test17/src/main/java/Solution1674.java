public class Solution1674 {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int MX = limit * 2 + 2;
        DiffArray diff = new DiffArray(MX + 1);
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i], b = nums[n - 1 - i];
            int mn = Math.min(a, b);
            int mx = Math.max(a, b);
            // 0 次操作后值域：[mx+mn, mx+mn]
            // 1 次操作后值域：[1+mn, lim+mx]
            // 2 次操作后值域：[2, lim*2+2]
            diff.rangeAdd(2, MX, 2);
            diff.rangeAdd(1 + mn, limit + mx, -1);
            diff.rangeAdd(mx + mn, mx + mn, -1);
        }
        int[] a = diff.originalArray();
        int ans = n / 2;
        for (int i = 2; i <= MX; i++) {
            ans = Math.min(ans, a[i]);
        }
        return ans;
    }

    static class DiffArray {
        int n;
        int[] diff;

        public DiffArray(int n) {
            this.n = n;
            diff = new int[n + 1];
        }

        void rangeAdd(int i, int j, int inc) {
            diff[i] += inc;
            diff[j + 1] -= inc;
        }

        int[] originalArray() { // 获取原数组
            int[] a = new int[n];
            a[0] = diff[0];
            for (int i = 1; i < n; i++) {
                a[i] = a[i - 1] + diff[i];
            }
            return a;
        }
    }
}
/*
1674. 使数组互补的最少操作次数
https://leetcode.cn/problems/minimum-moves-to-make-array-complementary/description/

给你一个长度为 偶数 n 的整数数组 nums 和一个整数 limit 。每一次操作，你可以将 nums 中的任何整数替换为 1 到 limit 之间的另一个整数。
如果对于所有下标 i（下标从 0 开始），nums[i] + nums[n - 1 - i] 都等于同一个数，则数组 nums 是 互补的 。例如，数组 [1,2,3,4] 是互补的，因为对于所有下标 i ，nums[i] + nums[n - 1 - i] = 5 。
返回使数组 互补 的 最少 操作次数。
提示：
n == nums.length
2 <= n <= 10^5
1 <= nums[i] <= limit <= 10^5
n 是偶数。

值域差分。
分类讨论在替换 0/1/2 个数后的值域范围。
时间复杂度 O(n)。
相似题目: 3224. 使差值相等的最少数组改动次数
https://leetcode.cn/problems/minimum-array-changes-to-make-differences-equal/description/
 */