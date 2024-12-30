public class Solution1524 {
    private static final int MOD = (int) (1e9 + 7);

    public int numOfSubarrays(int[] arr) {
        int[] ps = new int[2];
        int sum = 0;
        ps[sum]++;
        long ans = 0;
        for (int v : arr) {
            sum = (sum + v) % 2;
            ans += ps[sum ^ 1];
            ps[sum]++;
        }
        ans %= MOD;
        return (int) ans;
    }
}
/*
1524. 和为奇数的子数组数目
https://leetcode.cn/problems/number-of-sub-arrays-with-odd-sum/description/

给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
提示：
1 <= arr.length <= 10^5
1 <= arr[i] <= 100

前缀和。统计 和的奇偶 情况即可。
时间复杂度 O(n)。
 */