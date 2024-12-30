public class Solution3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int digitSum = 0;
        for (int i = x; i > 0; i /= 10) {
            digitSum += i % 10;
        }
        if (x % digitSum == 0) return digitSum;
        return -1;
    }
}
/*
3099. 哈沙德数
https://leetcode.cn/problems/harshad-number/description/

第 391 场周赛 T1。

如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x 各个数位上的数字之和，否则，返回 -1 。
提示：
1 <= x <= 100

模拟。
时间复杂度 O(logx)
 */