import java.util.Arrays;

public class Solution1959 {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;

        // g[i][j] 表示 nums[i, j] 段最大值乘以长度再减去这一段元素和
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int j = i; j < n; j++) {
                max = Math.max(max, nums[j]);
                sum += nums[j];
                g[i][j] = max * (j - i + 1) - sum;
            }
        }

        // f[i][j] 表示将 nums 前 i 个元素分成 j 段的浪费的最小总空间
        // k 次调整可以分成 k+1 段，结果为 f[n-1][k+1]
        int[][] f = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k + 1; j++) {
                for (int i0 = 0; i0 <= i; i0++) {
                    if (i0 == 0) {
                        f[i][j] = Math.min(f[i][j], g[i0][i]);
                    } else {
                        f[i][j] = Math.min(f[i][j], f[i0 - 1][j - 1] + g[i0][i]);
                    }
                }
            }
        }
        return f[n - 1][k + 1];
    }
}
/*
1959. K 次调整数组大小浪费的最小总空间
https://leetcode.cn/problems/minimum-total-space-wasted-with-k-resizing-operations/

第 58 场双周赛 T3。

你正在设计一个动态数组。给你一个下标从 0 开始的整数数组 nums ，其中 nums[i] 是 i 时刻数组中的元素数目。除此以外，你还有一个整数 k ，表示你可以 调整 数组大小的 最多 次数（每次都可以调整成 任意 大小）。
t 时刻数组的大小 sizet 必须大于等于 nums[t] ，因为数组需要有足够的空间容纳所有元素。t 时刻 浪费的空间 为 sizet - nums[t] ，总 浪费空间为满足 0 <= t < nums.length 的每一个时刻 t 浪费的空间 之和 。
在调整数组大小不超过 k 次的前提下，请你返回 最小总浪费空间 。
注意：数组最开始时可以为 任意大小 ，且 不计入 调整大小的操作次数。
提示：
1 <= nums.length <= 200
1 <= nums[i] <= 10^6
0 <= k <= nums.length - 1

动态规划
时间复杂度 O(n^2 * k)
空间复杂度 O(n(n+k))
 */