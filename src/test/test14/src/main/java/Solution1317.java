public class Solution1317 {
    public int[] getNoZeroIntegers(int n) {
        for (int A = 1; A < n; ++A) {
            int B = n - A;
            if (!("" + A + B).contains("0")) {
                return new int[]{A, B};
            }
        }
        return new int[0];
    }
}
/*
1317. 将整数转换为两个无零整数的和
https://leetcode.cn/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/

「无零整数」是十进制表示中 不含任何 0 的正整数。
给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
- A 和 B 都是无零整数
- A + B = n
题目数据保证至少有一个有效的解决方案。
如果存在多个有效解决方案，你可以返回其中任意一个。
提示：
2 <= n <= 10^4

数据范围较小，直接枚举即可。
时间复杂度 O(nlogn)。
 */