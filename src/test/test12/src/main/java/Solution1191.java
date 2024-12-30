import java.util.Arrays;

public class Solution1191 {
    private static final int MOD = (int) (1e9 + 7);

    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum = Arrays.stream(arr).sum();

        long ps = 0, ans = 0;
        int t = k > 1 ? 2 : 1;
        while (t-- > 0) {
            for (int v : arr) {
                ps = Math.max(ps, 0) + v;
                ans = Math.max(ans, ps);
            }
        }

        if (sum > 0) {
            long k2 = Math.max(0, k - 2);
            ans = (ans + sum * k2) % MOD;
        }
        return (int) (ans % MOD);
    }
}
/*
1191. K 次串联后最大子数组之和
https://leetcode.cn/problems/k-concatenation-maximum-sum/description/

给定一个整数数组 arr 和一个整数 k ，通过重复 k 次来修改数组。
例如，如果 arr = [1, 2] ， k = 3 ，那么修改后的数组将是 [1, 2, 1, 2, 1, 2] 。
返回修改后的数组中的最大的子数组之和。注意，子数组长度可以是 0，在这种情况下它的总和也是 0。
由于 结果可能会很大，需要返回的 10^9 + 7 的 模 。
提示：
1 <= arr.length <= 10^5
1 <= k <= 10^5
-10^4 <= arr[i] <= 10^4

贪心 + 动态规划。
先求 2 倍数组的最大子数组和。
求原数组和 sum。如果 sum > 0，结果可以加上 k-2 个 sum。
相似题目: 53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/
 */