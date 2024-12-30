public class Solution3334 {
    public long maxScore(int[] nums) {
        int n = nums.length;

        // 前后缀分解
        long[] gcd_L = new long[n];
        long[] lcm_L = new long[n];
        lcm_L[0] = 1;
        for (int i = 1; i < n; i++) {
            gcd_L[i] = getGCD(gcd_L[i - 1], nums[i - 1]);
            lcm_L[i] = getLCM(lcm_L[i - 1], nums[i - 1]);
        }

        long[] gcd_R = new long[n];
        long[] lcm_R = new long[n];
        lcm_R[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            gcd_R[i] = getGCD(gcd_R[i + 1], nums[i + 1]);
            lcm_R[i] = getLCM(lcm_R[i + 1], nums[i + 1]);
        }

        // 不移除
        long ans = getGCD(gcd_L[n - 1], nums[n - 1]) * getLCM(lcm_L[n-1], nums[n-1]);
        // 移除一个
        for (int i = 0; i < n; i++) {
            long gcd = getGCD(gcd_L[i], gcd_R[i]);
            long lcm = getLCM(lcm_L[i], lcm_R[i]);
            ans = Math.max(ans, gcd * lcm);
        }
        return ans;
    }

    private long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }

    private long getLCM(long num1, long num2) {
        return num1 / getGCD(num1, num2) * num2;
    }
}
/*
3334. 数组的最大因子得分
https://leetcode.cn/problems/find-the-maximum-factor-score-of-array/description/

第 421 场周赛 T1。

给你一个整数数组 nums。
因子得分 定义为数组所有元素的最小公倍数（LCM）与最大公约数（GCD）的 乘积。
在 最多 移除一个元素的情况下，返回 nums 的 最大因子得分。
注意，单个数字的 LCM 和 GCD 都是其本身，而 空数组 的因子得分为 0。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 30

中国时间：2024-10-27 10:30
东莞·三丫坡 的自助餐不错，，从 VP 来看，是比较难的一场周赛，，
相似题目: 238. 除自身以外数组的乘积
https://leetcode.cn/problems/product-of-array-except-self/
 */