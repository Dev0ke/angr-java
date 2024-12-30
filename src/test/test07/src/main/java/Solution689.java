public class Solution689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int L) {
        reverse(nums); // 将回溯「字典序最大」转换为「字典序最小」
        int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        int k = 3;
        // f[i][j] 表示前 j 个数分成 i 段，每段选一个子数组，对应的最大和
        long[][] f = new long[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = i * L; j + (k - i) * L <= n; j++) {
                f[i][j] = Math.max(f[i][j - 1], f[i - 1][j - L] + ps[j] - ps[j - L]);
            }
        }

        int[] ans = new int[3];
        int j = n, i = 3, idx = 0;
        while (i >= 1) {
            // f[i][j] 仅由两个可能的点转移而来
            if (f[i][j - 1] > f[i - 1][j - L] + ps[j] - ps[j - L]) {
                j--;
            } else {
                ans[idx++] = n - j;
                j -= L;
                i--;
            }
        }
        return ans;
    }

    private void reverse(int[] nums) {
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
/*
689. 三个无重叠子数组的最大和
https://leetcode.cn/problems/maximum-sum-of-3-non-overlapping-subarrays/description/

给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且全部数字和（3 * k 项）最大的子数组，并返回这三个子数组。
以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
提示：
1 <= nums.length <= 2 * 10^4
1 <= nums[i] < 2^16
1 <= k <= floor(nums.length / 3)

划分型 DP。
此题也可以用动态规划求解，总体思路是我们用 dp[i][j] 表示到数组第 j 个元素为止，前 i 个互不重叠的子数组的最大值。
对于当前第 j 个元素所对应的值，我们有不取和取两种选择，选择不取该元素，则值为到 j−1 个元素时前 i 个互不重叠的子数组的最大值，即 dp[i][j−1] ，
选择取该元素，则值为到 j−k 个元素时前 i−1 个互不重叠的子数组的最大值 dp[i−1][j−k] 加上最后一段子数组的和，我们选择这两种情况下较大值即可，可以得到如下状态转移方程：
dp[i][j]=max(dp[i][j−1],dp[i−1][j−k]+sum[j]−sum[j−k])
其中，sum 为前缀和数组。
时间复杂度 O(3n)。
相似题目: 3077. K 个不相交子数组的最大能量值
https://leetcode.cn/problems/maximum-strength-of-k-disjoint-subarrays/description/
 */