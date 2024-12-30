public class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            // 抹去最右边的 1
            right = right & (right - 1);
        }
        return right;
    }
}
/*
201. 数字范围按位与
https://leetcode.cn/problems/bitwise-and-of-numbers-range/

给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
提示：
0 <= left <= right <= 2^31 - 1

Brian Kernighan 算法
n = n & (n - 1) 相当于 抹去最右边的 1
 */