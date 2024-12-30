public class Solution1186 {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int k = 1;
        // f[i][k] 表示以 arr[i] 结尾，删除 k 次的非空子数组的最大和
        int[][] f = new int[n][k + 1];
        f[0][0] = arr[0];
        int ans = arr[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], 0) + arr[i];
            f[i][1] = Math.max(f[i - 1][1] + arr[i], f[i - 1][0]);
            ans = Math.max(ans, Math.max(f[i][0], f[i][1]));
        }
        return ans;
    }
}
/*
1186. 删除一次得到子数组最大和
https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/description/

给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
注意，删除一个元素后，子数组 不能为空。
提示：
1 <= arr.length <= 10^5
-10^4 <= arr[i] <= 10^4

动态规划
 */