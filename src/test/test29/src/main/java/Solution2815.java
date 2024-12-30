import java.util.Arrays;

public class Solution2815 {
    public int maxSum(int[] nums) {
        int[] max = new int[10];
        Arrays.fill(max, -1);
        int ans = -1;
        for (int num : nums) {
            int maximumDigit = maximumDigit(num);
            if (max[maximumDigit] != -1) {
                ans = Math.max(ans, max[maximumDigit] + num);
            }
            max[maximumDigit] = Math.max(max[maximumDigit], num);
        }
        return ans;
    }

    // 数位上最大的数字
    private int maximumDigit(int num) {
        int res = 0;
        while (num > 0) {
            int x = num % 10;
            res = Math.max(res, x);
            num /= 10;
        }
        return res;
    }
}
/*
2815. 数组中的最大数对和
https://leetcode.cn/problems/max-pair-sum-in-an-array/

第 358 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 。请你从 nums 中找出和 最大 的一对数，且这两个数数位上最大的数字相等。
返回最大和，如果不存在满足题意的数字对，返回 -1 。
提示：
2 <= nums.length <= 100
1 <= nums[i] <= 10^4

VP场，贪心。
 */