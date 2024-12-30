public class Solution2177 {
    public long[] sumOfThree(long num) {
        if (num % 3 == 0) {
            long mid = num / 3;
            return new long[]{mid - 1, mid, mid + 1};
        }
        return new long[]{};
    }
}
/*
2177. 找到和为给定整数的三个连续整数
https://leetcode.cn/problems/find-three-consecutive-integers-that-sum-to-a-given-number/

第 72 场双周赛 T2。

给你一个整数 num ，请你返回三个连续的整数，它们的 和 为 num 。如果 num 无法被表示成三个连续整数的和，请你返回一个 空 数组。
提示：
0 <= num <= 10^15

数学。标记难度为中等，应为简单题。
时间复杂度 O(1)
 */