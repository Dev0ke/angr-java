public class Solution1390 {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            int factor_cnt = 0; // 因数的个数
            int factor_sum = 0; // 因数的和
            for (int i = 1; i * i <= v; i++) {
                if (v % i != 0) continue;
                factor_cnt++;
                factor_sum += i;
                if (v / i != i) { // 两个因数不相等
                    factor_cnt++;
                    factor_sum += v / i;
                }
            }
            if (factor_cnt == 4) {
                ans += factor_sum;
            }
        }
        return ans;
    }
}
/*
1390. 四因数
https://leetcode.cn/problems/four-divisors/description/

给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。如果数组中不存在满足题意的整数，则返回 0 。
提示：
1 <= nums.length <= 10^4
1 <= nums[i] <= 10^5

模拟。
时间复杂度 O(n * sqrt(C))。
还有 O(π^2(C) + C + N) 的筛法解法。
 */