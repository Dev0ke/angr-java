public class Solution813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] ps = new double[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        // f[i][_k] 表示将前 i 个数分成 _k 份时可以得到的最大分数
        // f[i][_k] = max(f[j][_k-1] + avg[j+1][i]) (j < i)
        // avg[j+1][i] 表示 nums [j+1,i] 的平均值，使用前缀和预处理，avg[j+1][i] = (preSum[i+1] - preSum[j+1]) / (i-j)
        double[][] f = new double[n][k + 1];

        // 分成 1 个组
        // f[i][1] = avg[0][i]
        for (int i = 0; i < n; i++) {
            f[i][1] = (ps[i + 1] - ps[0]) / (i + 1);
        }

        // 分成 2-k 个组
        for (int _k = 2; _k <= k; _k++) {
            for (int i = 0; i < n; i++) {
                double max = f[i][0];
                for (int j = 0; j < i; j++) {
                    double avg = (ps[i + 1] - ps[j + 1]) / (i - j);
                    max = Math.max(max, f[j][_k - 1] + avg);
                }
                f[i][_k] = max;
            }
        }
        return f[n - 1][k];
    }
}
/*
813. 最大平均值和的分组
https://leetcode.cn/problems/largest-sum-of-averages/

给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。
注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
返回我们所能得到的最大 分数 是多少。答案误差在 10^-6 内被视为是正确的。
提示:
1 <= nums.length <= 100
1 <= nums[i] <= 10^4
1 <= k <= nums.length

划分型 DP
时间复杂度 O(k*n^2)
 */