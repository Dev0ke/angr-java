import java.util.Arrays;

public class Solution1498 {
    private static final int MOD = (int) (1e9 + 7);

    public int numSubseq(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);

        long cnt = 0;
        for (int i = 0; i < len; i++) {

            int left = i;
            int right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                // nums[i] + nums[mid] <= target TTTFFF
                if (nums[i] + nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int j = left - 1;

            // 快速幂
            if (j - i >= 0) {
                cnt += quickPow(2, j - i);
                cnt %= MOD;
            }
        }
        return (int) cnt;
    }

    // 模下的 a^b
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
1498. 满足条件的子序列数目
https://leetcode.cn/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/

给你一个整数数组 nums 和一个整数 target 。
请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
由于答案可能很大，请将结果对 10^9 + 7 取余后返回。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6
1 <= target <= 10^6

二分 + 快速幂
 */