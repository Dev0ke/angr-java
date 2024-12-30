public class Solution2644 {
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxScore = 0;
        int minDivisor = divisors[0];

        for (int divisor : divisors) {
            int score = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    score++;
                }
            }
            if (maxScore < score) {
                maxScore = score;
                minDivisor = divisor;
            } else if (maxScore == score && minDivisor > divisor) {
                minDivisor = divisor;
            }
        }
        return minDivisor;
    }
}
/*
2644. 找出可整除性得分最大的整数
https://leetcode.cn/problems/find-the-maximum-divisibility-score/

第 341 场周赛 T2。

给你两个下标从 0 开始的整数数组 nums 和 divisors 。
divisors[i] 的 可整除性得分 等于满足 nums[j] 能被 divisors[i] 整除的下标 j 的数量。
返回 可整除性得分 最大的整数 divisors[i] 。如果有多个整数具有最大得分，则返回数值最小的一个。
提示：
1 <= nums.length, divisors.length <= 1000
1 <= nums[i], divisors[i] <= 10^9

模拟。
 */