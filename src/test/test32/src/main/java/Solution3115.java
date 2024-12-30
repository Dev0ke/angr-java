public class Solution3115 {
    public int maximumPrimeDifference(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i])) {
                l = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (isPrime(nums[i])) {
                r = i;
                break;
            }
        }
        return r - l;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
/*
3115. 质数的最大距离
https://leetcode.cn/problems/maximum-prime-difference/description/

第 393 场周赛 T2。

给你一个整数数组 nums。
返回两个（不一定不同的）素数在 nums 中 下标 的 最大距离。
提示：
1 <= nums.length <= 3 * 10^5
1 <= nums[i] <= 100
输入保证 nums 中至少有一个素数。

找第一个质数和最后一个质数 下标即可。
时间复杂度 O(nlogn)。判断是否质数 时间复杂度 O(logn)。
 */