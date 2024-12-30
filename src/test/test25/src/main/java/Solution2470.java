public class Solution2470 {
    public int subarrayLCM(int[] nums, int k) {
        int len = nums.length;

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int lcm = nums[i];
            for (int j = i; j < len; j++) {
                lcm = lcm / getGCD(lcm, nums[j]) * nums[j];
                if (lcm == k) {
                    cnt++;
                } else if (lcm > k) {
                    // 防止溢出
                    break;
                }
            }
        }
        return cnt;
    }

    private static int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
2470. 最小公倍数为 K 的子数组数目
https://leetcode.cn/problems/number-of-subarrays-with-lcm-equal-to-k/

第 319 场周赛 T2。

给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的 子数组 中满足 元素最小公倍数为 k 的子数组数目。
子数组 是数组中一个连续非空的元素序列。
数组的最小公倍数 是可被所有数组元素整除的最小正整数。
提示：
1 <= nums.length <= 1000
1 <= nums[i], k <= 1000

没有加 break 被 hack 了。。痛失 AK
相似题目: 2447. 最大公因数等于 K 的子数组数目
https://leetcode.cn/problems/number-of-subarrays-with-gcd-equal-to-k/
 */