public class Solution923 {
    private static final int MOD = (int) (1e9 + 7);

    public int threeSumMulti(int[] arr, int target) {
        int k = 3;
        long[][] f = new long[k + 1][target + 1];
        f[0][0] = 1;
        for (int v : arr) {
            for (int i = target; i >= v; i--) {
                for (int j = k; j >= 1; j--) {
                    f[j][i] = (f[j][i] + f[j - 1][i - v]) % MOD;
                }
            }
        }
        return (int) f[k][target];
    }
}
/*
923. 三数之和的多种可能
https://leetcode.cn/problems/3sum-with-multiplicity/description/

给定一个整数数组 arr ，以及一个整数 target 作为目标值，返回满足 i < j < k 且 arr[i] + arr[j] + arr[k] == target 的元组 i, j, k 的数量。
由于结果会非常大，请返回 10^9 + 7 的模。
提示：
3 <= arr.length <= 3000
0 <= arr[i] <= 100
0 <= target <= 300

0-1 背包 求方案数。
物品重量 1，价值 arr[i]
背包容量恰好 k，价值恰好 target
时间复杂度 O(3 * target)。
 */