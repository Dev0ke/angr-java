import java.util.Arrays;

public class Solution3224 {
    // 1674
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        DiffArray diff = new DiffArray(k + 1);
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i], b = nums[n - 1 - i];
            int mn = Math.min(a, b);
            int mx = Math.max(a, b);
            // 0 次操作后值域：[mx-mn, mx-mn]
            // 1 次操作后值域：[0, max(k-mn, mx)]
            // 2 次操作后值域：[0, k]
            diff.rangeAdd(0, k, 2);
            diff.rangeAdd(0, Math.max(k - mn, mx), -1);
            diff.rangeAdd(mx - mn, mx - mn, -1);
        }
        int[] a = diff.originalArray();
        return Arrays.stream(a).min().orElseThrow();
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
3224. 使差值相等的最少数组改动次数
https://leetcode.cn/problems/minimum-array-changes-to-make-differences-equal/description/

第 135 场双周赛 T3。

给你一个长度为 n 的整数数组 nums ，n 是 偶数 ，同时给你一个整数 k 。
你可以对数组进行一些操作。每次操作中，你可以将数组中 任一 元素替换为 0 到 k 之间的 任一 整数。
执行完所有操作以后，你需要确保最后得到的数组满足以下条件：
- 存在一个整数 X ，满足对于所有的 (0 <= i < n) 都有 abs(a[i] - a[n - i - 1]) = X 。
请你返回满足以上条件 最少 修改次数。
提示：
2 <= n == nums.length <= 10^5
n 是偶数。
0 <= nums[i] <= k <= 10^5

值域差分。
分类讨论在替换 0/1/2 个数后的值域范围。
时间复杂度 O(n)。
相似题目: 1674. 使数组互补的最少操作次数
https://leetcode.cn/problems/minimum-moves-to-make-array-complementary/description/
 */