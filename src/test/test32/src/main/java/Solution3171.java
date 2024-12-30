public class Solution3171 {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int[][] ps = new int[n + 1][31];
        for (int bit = 0; bit < 31; bit++) {
            for (int i = 0; i < n; i++) {
                ps[i + 1][bit] = ps[i][bit];
                if ((nums[i] >> bit & 1) == 1) {
                    ps[i + 1][bit] += 1;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = i, r = n;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (bitwiseAnd(ps, i, mid) <= k) r = mid;
                else l = mid + 1;
            }

            if (l < n) ans = Math.min(ans, k - bitwiseAnd(ps, i, l));
            if (l - 1 >= 0) ans = Math.min(ans, bitwiseAnd(ps, i, l - 1) - k);
        }
        return ans;
    }

    private int bitwiseAnd(int[][] ps, int l, int r) {
        int res = 0;
        for (int bit = 0; bit < 31; bit++) {
            int s = ps[r + 1][bit] - ps[l][bit];
            if (s == r - l + 1) {
                res |= 1 << bit;
            }
        }
        return res;
    }

    public int minimumDifference2(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            ans = Math.min(ans, Math.abs(x - k));
            for (int j = i - 1; j >= 0 && (nums[j] & x) != nums[j]; j--) {
                nums[j] &= x;
                ans = Math.min(ans, Math.abs(nums[j] - k));
            }
        }
        return ans;
    }
}
/*
3171. 找到按位与最接近 K 的子数组
https://leetcode.cn/problems/find-subarray-with-bitwise-and-closest-to-k/description/

第 400 场周赛 T4。

给你一个数组 nums 和一个整数 k 。你需要找到 nums 的一个 子数组，满足子数组中所有元素按位与运算 AND 的值与 k 的 绝对差 尽可能 小 。换言之，你需要选择一个子数组 nums[l..r] 满足 |k - (nums[l] AND nums[l + 1] ... AND nums[r])| 最小。
请你返回 最小 的绝对差值。
子数组是数组中连续的 非空 元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= 10^9

按位与显然是存在单调性的（单调减），因此可用拆位 + 二分答案。
时间复杂度 O(nlogn)。
也可以用按位 AND 的性质。
相似题目: 1521. 找到最接近目标值的函数值
https://leetcode.cn/problems/find-a-value-of-a-mysterious-function-closest-to-target/
 */